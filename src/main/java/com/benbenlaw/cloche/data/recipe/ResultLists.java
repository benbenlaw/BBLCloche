package com.benbenlaw.cloche.data.recipe;

import com.benbenlaw.core.recipe.ChanceResult;
import net.minecraft.core.NonNullList;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;

public class ResultLists {

    public static final NonNullList<ChanceResult> WHEAT_RESULTS;
    public static final NonNullList<ChanceResult> POTATO_RESULTS;
    public static final NonNullList<ChanceResult> CARROT_RESULTS;
    public static final NonNullList<ChanceResult> BEETROOT_RESULTS;
    public static final NonNullList<ChanceResult> NETHER_WART_RESULTS;
    public static final NonNullList<ChanceResult> SWEET_BERRY_RESULTS;
    public static final NonNullList<ChanceResult> CACTUS_RESULTS;
    public static final NonNullList<ChanceResult> SUGAR_CANE_RESULTS;
    public static final NonNullList<ChanceResult> MELON_RESULTS;
    public static final NonNullList<ChanceResult> PUMPKIN_RESULTS;
    public static final NonNullList<ChanceResult> BAMBOO_RESULTS;
    public static final NonNullList<ChanceResult> KELP_RESULTS;
    public static final NonNullList<ChanceResult> CHORUS_FRUIT_RESULTS;
    public static final NonNullList<ChanceResult> COCOA_BEANS_RESULTS;
    public static final NonNullList<ChanceResult> BROWN_MUSHROOM_RESULTS;
    public static final NonNullList<ChanceResult> RED_MUSHROOM_RESULTS;
    public static final NonNullList<ChanceResult> LILY_PAD_RESULTS;
    public static final NonNullList<ChanceResult> VINE_RESULTS;
    public static final NonNullList<ChanceResult> CRIMSON_FUNGUS_RESULTS;
    public static final NonNullList<ChanceResult> WARPED_FUNGUS_RESULTS;
    public static final NonNullList<ChanceResult> OAK_SAPLING_RESULTS;
    public static final NonNullList<ChanceResult> SPRUCE_SAPLING_RESULTS;
    public static final NonNullList<ChanceResult> BIRCH_SAPLING_RESULTS;
    public static final NonNullList<ChanceResult> JUNGLE_SAPLING_RESULTS;
    public static final NonNullList<ChanceResult> ACACIA_SAPLING_RESULTS;
    public static final NonNullList<ChanceResult> DARK_OAK_SAPLING_RESULTS;
    public static final NonNullList<ChanceResult> CHERRY_SAPLING_RESULTS;
    public static final NonNullList<ChanceResult> MANGROVE_SAPLING_RESULTS;


    static {
        WHEAT_RESULTS = NonNullList.create();
        WHEAT_RESULTS.add(new ChanceResult(new ItemStack(Items.WHEAT), 1.0f));
        WHEAT_RESULTS.add(new ChanceResult(new ItemStack(Items.WHEAT_SEEDS), 0.2f));

        POTATO_RESULTS = NonNullList.create();
        POTATO_RESULTS.add(new ChanceResult(new ItemStack(Items.POTATO), 1.0f));
        POTATO_RESULTS.add(new ChanceResult(new ItemStack(Items.POISONOUS_POTATO), 0.1f));

        CARROT_RESULTS = NonNullList.create();
        CARROT_RESULTS.add(new ChanceResult(new ItemStack(Items.CARROT), 1.0f));

        BEETROOT_RESULTS = NonNullList.create();
        BEETROOT_RESULTS.add(new ChanceResult(new ItemStack(Items.BEETROOT), 1.0f));
        BEETROOT_RESULTS.add(new ChanceResult(new ItemStack(Items.BEETROOT_SEEDS), 0.2f));

        NETHER_WART_RESULTS = NonNullList.create();
        NETHER_WART_RESULTS.add(new ChanceResult(new ItemStack(Items.NETHER_WART), 1.0f));

        SWEET_BERRY_RESULTS = NonNullList.create();
        SWEET_BERRY_RESULTS.add(new ChanceResult(new ItemStack(Items.SWEET_BERRIES), 1.0f));

        CACTUS_RESULTS = NonNullList.create();
        CACTUS_RESULTS.add(new ChanceResult(new ItemStack(Items.CACTUS), 1.0f));

        SUGAR_CANE_RESULTS = NonNullList.create();
        SUGAR_CANE_RESULTS.add(new ChanceResult(new ItemStack(Items.SUGAR_CANE), 1.0f));

        MELON_RESULTS = NonNullList.create();
        MELON_RESULTS.add(new ChanceResult(new ItemStack(Items.MELON), 1.0f));

        PUMPKIN_RESULTS = NonNullList.create();
        PUMPKIN_RESULTS.add(new ChanceResult(new ItemStack(Items.PUMPKIN), 1.0f));

        BAMBOO_RESULTS = NonNullList.create();
        BAMBOO_RESULTS.add(new ChanceResult(new ItemStack(Items.BAMBOO), 1.0f));

        KELP_RESULTS = NonNullList.create();
        KELP_RESULTS.add(new ChanceResult(new ItemStack(Items.KELP), 1.0f));

        CHORUS_FRUIT_RESULTS = NonNullList.create();
        CHORUS_FRUIT_RESULTS.add(new ChanceResult(new ItemStack(Items.CHORUS_FRUIT), 1.0f));

        COCOA_BEANS_RESULTS = NonNullList.create();
        COCOA_BEANS_RESULTS.add(new ChanceResult(new ItemStack(Items.COCOA_BEANS), 1.0f));

        BROWN_MUSHROOM_RESULTS = NonNullList.create();
        BROWN_MUSHROOM_RESULTS.add(new ChanceResult(new ItemStack(Items.BROWN_MUSHROOM), 1.0f));

        RED_MUSHROOM_RESULTS = NonNullList.create();
        RED_MUSHROOM_RESULTS.add(new ChanceResult(new ItemStack(Items.RED_MUSHROOM), 1.0f));

        LILY_PAD_RESULTS = NonNullList.create();
        LILY_PAD_RESULTS.add(new ChanceResult(new ItemStack(Items.LILY_PAD), 1.0f));

        VINE_RESULTS = NonNullList.create();
        VINE_RESULTS.add(new ChanceResult(new ItemStack(Items.VINE), 1.0f));

        CRIMSON_FUNGUS_RESULTS = NonNullList.create();
        CRIMSON_FUNGUS_RESULTS.add(new ChanceResult(new ItemStack(Items.CRIMSON_STEM, 2), 1.0f));
        CRIMSON_FUNGUS_RESULTS.add(new ChanceResult(new ItemStack(Items.CRIMSON_FUNGUS), 0.5f));

        WARPED_FUNGUS_RESULTS = NonNullList.create();
        WARPED_FUNGUS_RESULTS.add(new ChanceResult(new ItemStack(Items.WARPED_STEM, 2), 1.0f));
        WARPED_FUNGUS_RESULTS.add(new ChanceResult(new ItemStack(Items.WARPED_FUNGUS), 0.5f));

        OAK_SAPLING_RESULTS = NonNullList.create();
        OAK_SAPLING_RESULTS.add(new ChanceResult(new ItemStack(Items.OAK_LOG, 2), 1.0f));
        OAK_SAPLING_RESULTS.add(new ChanceResult(new ItemStack(Items.OAK_SAPLING), 0.2f));
        OAK_SAPLING_RESULTS.add(new ChanceResult(new ItemStack(Items.APPLE), 0.2f));
        OAK_SAPLING_RESULTS.add(new ChanceResult(new ItemStack(Items.STICK), 0.1f));

        SPRUCE_SAPLING_RESULTS = NonNullList.create();
        SPRUCE_SAPLING_RESULTS.add(new ChanceResult(new ItemStack(Items.SPRUCE_LOG, 2), 1.0f));
        SPRUCE_SAPLING_RESULTS.add(new ChanceResult(new ItemStack(Items.SPRUCE_SAPLING), 0.2f));
        SPRUCE_SAPLING_RESULTS.add(new ChanceResult(new ItemStack(Items.STICK), 0.1f));

        BIRCH_SAPLING_RESULTS = NonNullList.create();
        BIRCH_SAPLING_RESULTS.add(new ChanceResult(new ItemStack(Items.BIRCH_LOG, 2), 1.0f));
        BIRCH_SAPLING_RESULTS.add(new ChanceResult(new ItemStack(Items.BIRCH_SAPLING), 0.2f));
        BIRCH_SAPLING_RESULTS.add(new ChanceResult(new ItemStack(Items.STICK), 0.1f));

        JUNGLE_SAPLING_RESULTS = NonNullList.create();
        JUNGLE_SAPLING_RESULTS.add(new ChanceResult(new ItemStack(Items.JUNGLE_LOG, 2), 1.0f));
        JUNGLE_SAPLING_RESULTS.add(new ChanceResult(new ItemStack(Items.JUNGLE_SAPLING), 0.2f));
        JUNGLE_SAPLING_RESULTS.add(new ChanceResult(new ItemStack(Items.COCOA_BEANS), 0.2f));

        ACACIA_SAPLING_RESULTS = NonNullList.create();
        ACACIA_SAPLING_RESULTS.add(new ChanceResult(new ItemStack(Items.ACACIA_LOG, 2), 1.0f));
        ACACIA_SAPLING_RESULTS.add(new ChanceResult(new ItemStack(Items.ACACIA_SAPLING), 0.2f));
        ACACIA_SAPLING_RESULTS.add(new ChanceResult(new ItemStack(Items.STICK), 0.1f));

        DARK_OAK_SAPLING_RESULTS = NonNullList.create();
        DARK_OAK_SAPLING_RESULTS.add(new ChanceResult(new ItemStack(Items.DARK_OAK_LOG, 2), 1.0f));
        DARK_OAK_SAPLING_RESULTS.add(new ChanceResult(new ItemStack(Items.DARK_OAK_SAPLING), 0.2f));
        DARK_OAK_SAPLING_RESULTS.add(new ChanceResult(new ItemStack(Items.APPLE), 0.2f));
        DARK_OAK_SAPLING_RESULTS.add(new ChanceResult(new ItemStack(Items.STICK), 0.1f));

        CHERRY_SAPLING_RESULTS = NonNullList.create();
        CHERRY_SAPLING_RESULTS.add(new ChanceResult(new ItemStack(Items.CHERRY_LOG, 2), 1.0f));
        CHERRY_SAPLING_RESULTS.add(new ChanceResult(new ItemStack(Items.CHERRY_SAPLING), 0.2f));
        CHERRY_SAPLING_RESULTS.add(new ChanceResult(new ItemStack(Items.STICK), 0.1f));

        MANGROVE_SAPLING_RESULTS = NonNullList.create();
        MANGROVE_SAPLING_RESULTS.add(new ChanceResult(new ItemStack(Items.MANGROVE_LOG, 2), 1.0f));
        MANGROVE_SAPLING_RESULTS.add(new ChanceResult(new ItemStack(Items.MANGROVE_PROPAGULE), 0.2f));
        MANGROVE_SAPLING_RESULTS.add(new ChanceResult(new ItemStack(Items.STICK), 0.1f));




    }
}