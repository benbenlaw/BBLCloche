package com.benbenlaw.cloche.recipe;

import com.benbenlaw.core.recipe.ChanceResult;
import com.mojang.serialization.Codec;
import com.mojang.serialization.DataResult;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.NonNullList;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.util.RandomSource;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.*;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static com.benbenlaw.cloche.block.entity.ClocheBlockEntity.*;

public record ClocheRecipe (Ingredient seed, Ingredient soil, Optional<Ingredient> catalyst, int duration, NonNullList<ChanceResult> results, ItemStack shearsResult) implements Recipe<RecipeInput> {

    @Override
    public boolean matches(RecipeInput container, @NotNull Level level) {

        boolean needCatalyst = !catalyst.isEmpty();
        if (needCatalyst) {
            if (catalyst.get().test(container.getItem(CATALYST_SLOT))) {
                return seed.test(container.getItem(SEED_SLOT)) && soil.test(container.getItem(SOIL_SLOT));
            } else {
                return false;
            }
        }

        return seed.test(container.getItem(SEED_SLOT)) && soil.test(container.getItem(SOIL_SLOT));

    }

    @Override
    public @NotNull ItemStack assemble(@NotNull RecipeInput input, HolderLookup.@NotNull Provider provider) {
        return results.getFirst().stack().copy();
    }

    @Override
    public @NotNull RecipeSerializer<? extends Recipe<RecipeInput>> getSerializer() {
        return Serializer.INSTANCE;
    }

    @Override
    public @NotNull RecipeType<? extends Recipe<RecipeInput>> getType() {
        return Type.INSTANCE;
    }

    @Override
    public @NotNull PlacementInfo placementInfo() {
        return PlacementInfo.NOT_PLACEABLE;
    }

    @Override
    public @NotNull RecipeBookCategory recipeBookCategory() {
        return RecipeBookCategories.CRAFTING_MISC;
    }

    @Override
    public boolean isSpecial() {
        return true;
    }

    public static class Type implements RecipeType<ClocheRecipe> {
        private Type() {
        }

        public static final ClocheRecipe.Type INSTANCE = new ClocheRecipe.Type();
    }

    public static class Serializer implements RecipeSerializer<ClocheRecipe> {
        public static final ClocheRecipe.Serializer INSTANCE = new Serializer();
        public final MapCodec<ClocheRecipe> CODEC = RecordCodecBuilder.mapCodec((instance) ->
                instance.group(
                        Ingredient.CODEC.fieldOf("seed").forGetter(ClocheRecipe::seed),
                        Ingredient.CODEC.fieldOf("soil").forGetter(ClocheRecipe::soil),
                        Ingredient.CODEC.optionalFieldOf("catalyst").forGetter(ClocheRecipe::catalyst),
                        Codec.INT.fieldOf("duration").forGetter(ClocheRecipe::duration),
                        Codec.list(ChanceResult.CODEC).fieldOf("results").flatXmap(chanceResults -> {
                            NonNullList<ChanceResult> nonNullList = NonNullList.create();
                            nonNullList.addAll(chanceResults);
                            return DataResult.success(nonNullList);
                        }, DataResult::success).forGetter(ClocheRecipe::getRollResults),
                        ItemStack.CODEC.optionalFieldOf("shears_result", ItemStack.EMPTY).forGetter(ClocheRecipe::shearsResult)
                ).apply(instance, ClocheRecipe::new)
        );

        private final StreamCodec<RegistryFriendlyByteBuf, ClocheRecipe> STREAM_CODEC = StreamCodec.of(
                Serializer::write, Serializer::read);

        @Override
        public @NotNull MapCodec<ClocheRecipe> codec() {
            return CODEC;
        }

        @Override
        public @NotNull StreamCodec<RegistryFriendlyByteBuf, ClocheRecipe> streamCodec() {
            return STREAM_CODEC;
        }

        private static ClocheRecipe read(RegistryFriendlyByteBuf buffer) {
            Ingredient seed = Ingredient.CONTENTS_STREAM_CODEC.decode(buffer);
            Ingredient soil = Ingredient.CONTENTS_STREAM_CODEC.decode(buffer);
            Optional<Ingredient> catalyst = Ingredient.OPTIONAL_CONTENTS_STREAM_CODEC.decode(buffer).or(Optional::empty);
            int duration = buffer.readInt();
            int size = buffer.readVarInt();
            NonNullList<ChanceResult> outputs = NonNullList.withSize(size, ChanceResult.EMPTY);
            outputs.replaceAll(ignored -> ChanceResult.read(buffer));
            ItemStack shearsResult = ItemStack.OPTIONAL_STREAM_CODEC.decode(buffer);
            return new ClocheRecipe(seed, soil, catalyst, duration, outputs, shearsResult);
        }
        private static void write(RegistryFriendlyByteBuf buffer, ClocheRecipe recipe) {
            Ingredient.CONTENTS_STREAM_CODEC.encode(buffer, recipe.seed);
            Ingredient.CONTENTS_STREAM_CODEC.encode(buffer, recipe.soil);
            Ingredient.OPTIONAL_CONTENTS_STREAM_CODEC.encode(buffer, recipe.catalyst);
            buffer.writeInt(recipe.duration);
            buffer.writeVarInt(recipe.results.size());
            for (ChanceResult output : recipe.results) {
                output.write(buffer);
            }
            ItemStack.OPTIONAL_STREAM_CODEC.encode(buffer, recipe.shearsResult);
        }
    }


    public List<ItemStack> getResults() {
        return getRollResults().stream()
                .map(ChanceResult::stack)
                .collect(Collectors.toList());
    }

    public NonNullList<ChanceResult> getRollResults() {
        return this.results;
    }

    public List<ItemStack> rollResults(RandomSource rand) {
        List<ItemStack> results = new ArrayList<>();
        List<ChanceResult> rollResults = getRollResults();
        for (ChanceResult output : rollResults) {
            ItemStack stack = output.rollOutput(rand);
            if (!stack.isEmpty())
                results.add(stack);
        }
        return results;
    }





}

