package com.benbenlaw.cloche.data;

import com.benbenlaw.cloche.Cloche;
import com.benbenlaw.cloche.item.ClocheItems;
import com.benbenlaw.cloche.util.ClocheTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.KeyTagProvider;
import net.minecraft.data.tags.TagsProvider;
import net.minecraft.world.item.Item;
import net.neoforged.neoforge.common.data.ItemTagsProvider;
import org.jetbrains.annotations.NotNull;

import java.util.concurrent.CompletableFuture;

public class ClocheItemTags extends ItemTagsProvider {

    public ClocheItemTags(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider) {
        super(output, lookupProvider, Cloche.MOD_ID);
    }

    @Override
    protected void addTags(HolderLookup.@NotNull Provider provider) {

        tag(ClocheTags.Items.UPGRADES)
                .add(ClocheItems.NO_SEEDS_UPGRADE.get())
                .add(ClocheItems.NO_OTHER_DROPS_UPGRADE.get())
                .add(ClocheItems.END_UPGRADE.get())
                .add(ClocheItems.NETHER_UPGRADE.get())
                .add(ClocheItems.OVERWORLD_UPGRADE.get())
                .add(ClocheItems.TWILIGHT_FOREST_UPGRADE.get())
                .add(ClocheItems.SHEARS_UPGRADE.get())
                .add(ClocheItems.MAIN_OUTPUT_UPGRADE.get())
                .add(ClocheItems.PERCENTAGE_SPEED_UPGRADE_1.get())
                .add(ClocheItems.PERCENTAGE_SPEED_UPGRADE_2.get())
                .add(ClocheItems.PERCENTAGE_SPEED_UPGRADE_3.get())
                .add(ClocheItems.FIXED_SPEED_UPGRADE_1.get())
                .add(ClocheItems.FIXED_SPEED_UPGRADE_2.get())
                .add(ClocheItems.FIXED_SPEED_UPGRADE_3.get());
    }


    @Override
    public @NotNull String getName() {
        return Cloche.MOD_ID + " Item Tags";
    }
}
