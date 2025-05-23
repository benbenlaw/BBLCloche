package com.benbenlaw.cloche.item;

import com.benbenlaw.cloche.Cloche;
import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ClocheItems {

    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(Cloche.MOD_ID);

    public static final DeferredItem<Item> OVERWORLD_UPGRADE = ITEMS.register("overworld_upgrade",
            () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> NETHER_UPGRADE = ITEMS.register("nether_upgrade",
            () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> END_UPGRADE = ITEMS.register("end_upgrade",
            () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> NO_SEEDS_UPGRADE = ITEMS.register("no_seeds_upgrade",
            () -> new UpgradeItem(new Item.Properties(), "tooltip.cloche.upgrade.no_seeds"));
    public static final DeferredItem<Item> MAIN_OUTPUT_UPGRADE = ITEMS.register("main_output_upgrade",
            () -> new UpgradeItem(new Item.Properties(), "tooltip.cloche.upgrade.main_output_upgrade"));
    public static final DeferredItem<Item> SHEARS_UPGRADE = ITEMS.register("shears_upgrade",
            () -> new UpgradeItem(new Item.Properties(), "tooltip.cloche.upgrade.shears_upgrade"));
    public static final DeferredItem<Item> NO_OTHER_DROPS_UPGRADE = ITEMS.register("no_other_drops_upgrade",
            () -> new UpgradeItem(new Item.Properties(), "tooltip.cloche.upgrade.no_other_drops_upgrade"));

    //Speed Upgrades
    public static final DeferredItem<Item> FIXED_SPEED_UPGRADE_1 = ITEMS.register("fixed_speed_upgrade_1",
            () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> FIXED_SPEED_UPGRADE_2 = ITEMS.register("fixed_speed_upgrade_2",
            () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> FIXED_SPEED_UPGRADE_3 = ITEMS.register("fixed_speed_upgrade_3",
            () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> PERCENTAGE_SPEED_UPGRADE_1 = ITEMS.register("percentage_speed_upgrade_1",
            () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> PERCENTAGE_SPEED_UPGRADE_2 = ITEMS.register("percentage_speed_upgrade_2",
            () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> PERCENTAGE_SPEED_UPGRADE_3 = ITEMS.register("percentage_speed_upgrade_3",
            () -> new Item(new Item.Properties()));

    //Modded Dimensional Upgrades
    public static final DeferredItem<Item> TWILIGHT_FOREST_UPGRADE = ITEMS.register("twilight_forest_upgrade",
            () -> new Item(new Item.Properties()));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }

}
