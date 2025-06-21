package com.benbenlaw.cloche.data;

import com.benbenlaw.cloche.Cloche;
import com.benbenlaw.cloche.block.ClocheBlock;
import com.benbenlaw.cloche.block.ClocheBlocks;
import com.benbenlaw.cloche.item.ClocheItems;
import net.minecraft.client.data.models.BlockModelGenerators;
import net.minecraft.client.data.models.ItemModelGenerators;
import net.minecraft.client.data.models.ModelProvider;
import net.minecraft.client.data.models.MultiVariant;
import net.minecraft.client.data.models.blockstates.MultiVariantGenerator;
import net.minecraft.client.data.models.model.*;
import net.minecraft.core.Direction;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import org.jetbrains.annotations.NotNull;


import java.util.concurrent.CompletableFuture;
import java.util.stream.Stream;

import static net.minecraft.client.data.models.BlockModelGenerators.createBooleanModelDispatch;
import static net.minecraft.client.data.models.BlockModelGenerators.plainVariant;

public class ClocheModelProvider extends ModelProvider {


    public ClocheModelProvider(PackOutput output) {
        super(output, Cloche.MOD_ID);
    }

    @Override
    protected void registerModels(BlockModelGenerators blockModels, ItemModelGenerators itemModels) {

        // Items
        itemModels.generateFlatItem(ClocheItems.OVERWORLD_UPGRADE.get(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(ClocheItems.NETHER_UPGRADE.get(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(ClocheItems.END_UPGRADE.get(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(ClocheItems.TWILIGHT_FOREST_UPGRADE.get(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(ClocheItems.NO_SEEDS_UPGRADE.get(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(ClocheItems.NO_OTHER_DROPS_UPGRADE.get(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(ClocheItems.MAIN_OUTPUT_UPGRADE.get(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(ClocheItems.SHEARS_UPGRADE.get(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(ClocheItems.FIXED_SPEED_UPGRADE_1.get(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(ClocheItems.FIXED_SPEED_UPGRADE_2.get(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(ClocheItems.FIXED_SPEED_UPGRADE_3.get(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(ClocheItems.PERCENTAGE_SPEED_UPGRADE_1.get(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(ClocheItems.PERCENTAGE_SPEED_UPGRADE_2.get(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(ClocheItems.PERCENTAGE_SPEED_UPGRADE_3.get(), ModelTemplates.FLAT_ITEM);
    }

    @Override
    protected @NotNull Stream<? extends Holder<Block>> getKnownBlocks() {
        return ClocheBlocks.BLOCKS.getEntries().stream().filter(x -> !x.is(ClocheBlocks.CLOCHE.getId()));
    }

    @Override
    protected @NotNull Stream<? extends Holder<Item>> getKnownItems() {
        return ClocheItems.ITEMS.getEntries().stream();
    }

    @Override
    public @NotNull String getName() {
        return Cloche.MOD_ID + " Models";
    }
}