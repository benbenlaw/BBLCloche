package com.benbenlaw.cloche.item;

import com.benbenlaw.cloche.Cloche;
import com.benbenlaw.cloche.block.ClocheBlock;
import com.benbenlaw.cloche.block.ClocheBlocks;
import com.benbenlaw.core.Core;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ClocheItems {

    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(Cloche.MOD_ID);

    public static final DeferredItem<Item> OVERWORLD_UPGRADE = ITEMS.registerItem("overworld_upgrade", Item::new);
    public static final DeferredItem<Item> NETHER_UPGRADE = ITEMS.registerItem("nether_upgrade", Item::new);
    public static final DeferredItem<Item> END_UPGRADE = ITEMS.registerItem("end_upgrade", Item::new);

    public static final DeferredItem<Item> NO_SEEDS_UPGRADE = ITEMS.register("no_seeds_upgrade",
            () -> new UpgradeItem(new Item.Properties().setId(getKey("no_seeds_upgrade")), "tooltip.cloche.upgrade.no_seeds"));

    public static final DeferredItem<Item> MAIN_OUTPUT_UPGRADE = ITEMS.register("main_output_upgrade",
            () -> new UpgradeItem(new Item.Properties().setId(getKey("main_output_upgrade")), "tooltip.cloche.upgrade.main_output_upgrade"));

    public static final DeferredItem<Item> SHEARS_UPGRADE = ITEMS.register("shears_upgrade",
            () -> new UpgradeItem(new Item.Properties().setId(getKey("shears_upgrade")), "tooltip.cloche.upgrade.shears_upgrade"));

    public static final DeferredItem<Item> NO_OTHER_DROPS_UPGRADE = ITEMS.register("no_other_drops_upgrade",
            () -> new UpgradeItem(new Item.Properties().setId(getKey("no_other_drops_upgrade")), "tooltip.cloche.upgrade.no_other_drops_upgrade"));

    //Speed Upgrades
    public static final DeferredItem<Item> FIXED_SPEED_UPGRADE_1 = ITEMS.registerItem("fixed_speed_upgrade_1", Item::new);
    public static final DeferredItem<Item> FIXED_SPEED_UPGRADE_2 = ITEMS.registerItem("fixed_speed_upgrade_2", Item::new);
    public static final DeferredItem<Item> FIXED_SPEED_UPGRADE_3 = ITEMS.registerItem("fixed_speed_upgrade_3", Item::new);
    public static final DeferredItem<Item> PERCENTAGE_SPEED_UPGRADE_1 = ITEMS.registerItem("percentage_speed_upgrade_1", Item::new);
    public static final DeferredItem<Item> PERCENTAGE_SPEED_UPGRADE_2 = ITEMS.registerItem("percentage_speed_upgrade_2", Item::new);
    public static final DeferredItem<Item> PERCENTAGE_SPEED_UPGRADE_3 = ITEMS.registerItem("percentage_speed_upgrade_3", Item::new);

    //Modded Dimensional Upgrades
    public static final DeferredItem<Item> TWILIGHT_FOREST_UPGRADE = ITEMS.registerItem("twilight_forest_upgrade", Item::new);


    private static ResourceKey<Item> getKey(String name) {
        return ResourceKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath(Cloche.MOD_ID, name));
    }
}
