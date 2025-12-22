package com.benbenlaw.cloche.data;

import com.benbenlaw.cloche.Cloche;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.common.data.LanguageProvider;
import org.jetbrains.annotations.NotNull;

public class ClocheLangProvider extends LanguageProvider {

    public ClocheLangProvider(PackOutput output) {
        super(output, Cloche.MOD_ID, "en_us");
    }

    @Override
    protected void addTranslations() {
        add("itemGroup.cloche", "Cloche");

        //Blocks
        add("block.cloche.cloche", "Cloche");

        //Items
        add("item.cloche.no_seeds_upgrade", "No Seeds Upgrade");
        add("item.cloche.main_output_upgrade", "Main Output Upgrade");
        add("item.cloche.shears_upgrade", "Shears Upgrade");
        add("item.cloche.no_other_drops_upgrade", "No Other Drops Upgrade");

        //Tooltips - Info
        add("tooltip.upgrade.no_seeds", "Prevents seeds from being produced");
        add("tooltip.upgrade.main_output", "Increases the main output by 1");
        add("tooltip.upgrade.shears", "Add the Shears drop to the outputs");
        add("tooltip.upgrade.no_other_drops", "Prevents all other drops except the main output");

        //JEI
        add("jei.cloche.chance", "Chance: %s");
        add("jei.cloche.main_output", "Effected by Main Output Upgrade");
        add("jei.cloche.shears_result", "Drop added by Shears Upgrade");
        add("jei.cloche.seeds_results", "Removed by No Seeds Upgrade");


    }

    @Override
    public @NotNull String getName() {
        return Cloche.MOD_ID + " Language Provider";
    }
}
