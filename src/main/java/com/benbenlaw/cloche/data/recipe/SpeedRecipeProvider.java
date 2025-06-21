package com.benbenlaw.cloche.data.recipe;

import com.benbenlaw.cloche.Cloche;
import com.benbenlaw.cloche.recipe.DimensionalUpgradeRecipe;
import com.benbenlaw.cloche.recipe.SpeedUpgradeRecipe;
import net.minecraft.advancements.Advancement;
import net.minecraft.advancements.AdvancementRequirements;
import net.minecraft.advancements.AdvancementRewards;
import net.minecraft.advancements.Criterion;
import net.minecraft.advancements.critereon.RecipeUnlockedTrigger;
import net.minecraft.data.recipes.RecipeBuilder;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.Recipe;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.LinkedHashMap;
import java.util.Map;

public class SpeedRecipeProvider implements RecipeBuilder {

    protected String group;
    protected Ingredient ingredient;
    protected String modifierType;
    protected int modifier;

    protected final Map<String, Criterion<?>> criteria = new LinkedHashMap<>();

    public SpeedRecipeProvider(Ingredient ingredient, String modifierType, int modifier) {
        this.ingredient = ingredient;
        this.modifierType = modifierType;
        this.modifier = modifier;
    }

    public static SpeedRecipeProvider SpeedUpgradeRecipeBuilder(Ingredient ingredient, String modifierType, int modifier) {
        return new SpeedRecipeProvider(ingredient, modifierType, modifier);
    }
    @Override
    public @NotNull RecipeBuilder unlockedBy(String name, Criterion<?> criterion) {
        this.criteria.put(name, criterion);
        return this;
    }

    @Override
    public @NotNull RecipeBuilder group(@Nullable String groupName) {
        this.group = groupName;
        return this;
    }

    @Override
    public @NotNull Item getResult() {
        return ItemStack.EMPTY.getItem();
    }


    @Override
    public void save(RecipeOutput recipeOutput, ResourceKey<Recipe<?>> resourceKey) {
        Advancement.Builder builder = Advancement.Builder.advancement()
                .addCriterion("has_the_recipe", RecipeUnlockedTrigger.unlocked(resourceKey))
                .rewards(AdvancementRewards.Builder.recipe(resourceKey))
                .requirements(AdvancementRequirements.Strategy.OR);
        this.criteria.forEach(builder::addCriterion);
        SpeedUpgradeRecipe speedRecipe = new SpeedUpgradeRecipe(ingredient, modifierType, modifier);
        recipeOutput.accept(resourceKey, speedRecipe, builder.build(resourceKey.location().withPrefix("recipes/upgrades/")));
    }



}