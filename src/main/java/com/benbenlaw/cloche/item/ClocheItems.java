package com.benbenlaw.cloche.item;

import com.benbenlaw.cloche.Cloche;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.Item;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ClocheItems {

    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(Cloche.MOD_ID);

    public static final DeferredItem<Item> NO_SEEDS_UPGRADE = ITEMS.registerItem("no_seeds_upgrade",
            properties -> new Item(new Item.Properties().setId(createID("no_seeds_upgrade"))));

    public static final DeferredItem<Item> MAIN_OUTPUT_UPGRADE = ITEMS.registerItem("main_output_upgrade",
            properties -> new Item(new Item.Properties().setId(createID("main_output_upgrade"))));

    public static final DeferredItem<Item> SHEARS_UPGRADE = ITEMS.registerItem("shears_upgrade",
            properties -> new Item(new Item.Properties().setId(createID("shears_upgrade"))));

    public static final DeferredItem<Item> NO_OTHER_DROPS_UPGRADE = ITEMS.registerItem("no_other_drops_upgrade",
            properties -> new Item(new Item.Properties().setId(createID("no_other_drops_upgrade"))));

    public static final DeferredItem<Item> MUTATION_UPGRADE = ITEMS.registerItem("mutation_upgrade",
            properties -> new Item(new Item.Properties().setId(createID("mutation_upgrade"))));



    public static ResourceKey<Item> createID(String name) {
        return ResourceKey.create(Registries.ITEM, Cloche.identifier(name));
    }
}
