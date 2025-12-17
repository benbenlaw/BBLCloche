package com.benbenlaw.cloche.data;

import com.benbenlaw.cloche.Cloche;
import com.benbenlaw.cloche.item.ClocheItems;
import com.benbenlaw.cloche.util.ClocheTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.common.data.ItemTagsProvider;
import org.jetbrains.annotations.NotNull;

import java.util.concurrent.CompletableFuture;

public class ClocheItemTags extends ItemTagsProvider {

    ClocheItemTags(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider) {
        super(output, lookupProvider, Cloche.MOD_ID);
    }

    @Override
    protected void addTags(HolderLookup.@NotNull Provider provider) {

        //Upgrades
        tag(ClocheTags.Items.UPGRADES).add(ClocheItems.NO_SEEDS_UPGRADE.get());
        tag(ClocheTags.Items.UPGRADES).add(ClocheItems.NO_OTHER_DROPS_UPGRADE.get());
        tag(ClocheTags.Items.UPGRADES).add(ClocheItems.SHEARS_UPGRADE.get());
        tag(ClocheTags.Items.UPGRADES).add(ClocheItems.MAIN_OUTPUT_UPGRADE.get());
    }

    @Override
    public @NotNull String getName() {
        return Cloche.MOD_ID + " Item Tags";
    }
}
