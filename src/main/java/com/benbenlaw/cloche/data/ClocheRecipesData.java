package com.benbenlaw.cloche.data;

import com.benbenlaw.cloche.Cloche;
import com.benbenlaw.cloche.block.ClocheBlocks;
import com.benbenlaw.cloche.data.recipe.ClocheRecipeProvider;
import com.benbenlaw.cloche.data.recipe.DimensionalUpgradeRecipeProvider;
import com.benbenlaw.cloche.data.recipe.ResultLists;
import com.benbenlaw.cloche.data.recipe.SpeedRecipeProvider;
import com.benbenlaw.cloche.item.ClocheItems;
import com.benbenlaw.core.item.CoreItems;
import com.benbenlaw.core.recipe.ChanceResult;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.NonNullList;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.neoforged.neoforge.common.Tags;
import net.neoforged.neoforge.common.conditions.ModLoadedCondition;

import java.util.concurrent.CompletableFuture;

public class ClocheRecipesData extends RecipeProvider {

    public ClocheRecipesData(HolderLookup.Provider provider, RecipeOutput output) {
        super(provider, output);
    }

    public static class Runner extends RecipeProvider.Runner {
        public Runner(PackOutput packOutput, CompletableFuture<HolderLookup.Provider> provider) {
            super(packOutput, provider);
        }

        @Override
        protected RecipeProvider createRecipeProvider(HolderLookup.Provider provider, RecipeOutput recipeOutput) {
            return new ClocheRecipesData(provider, recipeOutput);
        }

        @Override
        public String getName() {
            return "My Recipes";
        }
    }

    @Override
    protected void buildRecipes() {
        
        
        // Fixed Speed Upgrade 1 - Crafting Recipe
        shaped(RecipeCategory.MISC, ClocheItems.FIXED_SPEED_UPGRADE_1.get())
                .pattern(" G ")
                .pattern("GUG")
                .pattern(" G ")
                .define('U', CoreItems.UPGRADE_BASE)
                .define('G', Tags.Items.INGOTS_GOLD)
                .group("cloche")
                .unlockedBy("has_item", has(CoreItems.UPGRADE_BASE))
                .save(output);

        // Fixed Speed Upgrade 2 - Crafting Recipe
        shaped(RecipeCategory.MISC, ClocheItems.FIXED_SPEED_UPGRADE_2.get())
                .pattern(" G ")
                .pattern("GUG")
                .pattern(" G ")
                .define('U', ClocheItems.FIXED_SPEED_UPGRADE_1.get())
                .define('G', Tags.Items.GEMS_DIAMOND)
                .group("cloche")
                .unlockedBy("has_item", has(CoreItems.UPGRADE_BASE)).save(output);

        // Fixed Speed Upgrade 3 - Crafting Recipe
        shaped(RecipeCategory.MISC, ClocheItems.FIXED_SPEED_UPGRADE_3.get())
                .pattern(" G ")
                .pattern("GUG")
                .pattern(" G ")
                .define('U', ClocheItems.FIXED_SPEED_UPGRADE_2.get())
                .define('G', Tags.Items.OBSIDIANS)
                .group("cloche")
                .unlockedBy("has_item", has(CoreItems.UPGRADE_BASE))
                .save(output);

        // Percentage Speed Upgrade 1 - Crafting Recipe
        shaped(RecipeCategory.MISC, ClocheItems.PERCENTAGE_SPEED_UPGRADE_1.get())
                .pattern(" G ")
                .pattern("GUG")
                .pattern(" G ")
                .define('U', CoreItems.UPGRADE_BASE)
                .define('G', Items.CLOCK)
                .group("cloche")
                .unlockedBy("has_item", has(CoreItems.UPGRADE_BASE))
                .save(output);

        // Percentage Speed Upgrade 2 - Crafting Recipe
        shaped(RecipeCategory.MISC, ClocheItems.PERCENTAGE_SPEED_UPGRADE_2.get())
                .pattern(" G ")
                .pattern("GUG")
                .pattern(" G ")
                .define('U', ClocheItems.PERCENTAGE_SPEED_UPGRADE_1.get())
                .define('G', Tags.Items.GEMS_DIAMOND)
                .group("cloche")
                .unlockedBy("has_item", has(CoreItems.UPGRADE_BASE))
                .save(output);

        // Percentage Speed Upgrade 3 - Crafting Recipe
        shaped(RecipeCategory.MISC, ClocheItems.PERCENTAGE_SPEED_UPGRADE_3.get())
                .pattern(" G ")
                .pattern("GUG")
                .pattern(" G ")
                .define('U', ClocheItems.PERCENTAGE_SPEED_UPGRADE_2.get())
                .define('G', Tags.Items.OBSIDIANS)
                .group("cloche")
                .unlockedBy("has_item", has(CoreItems.UPGRADE_BASE))
                .save(output);

        // Shears Upgrade - Crafting Recipe
        shaped(RecipeCategory.MISC, ClocheItems.SHEARS_UPGRADE.get())
                .pattern(" S ")
                .pattern("SUS")
                .pattern(" S ")
                .define('U', CoreItems.UPGRADE_BASE)
                .define('S', Tags.Items.TOOLS_SHEAR)
                .group("cloche")
                .unlockedBy("has_item", has(CoreItems.UPGRADE_BASE))
                .save(output);

        // Main Output Upgrade - Crafting Recipe
        shaped(RecipeCategory.MISC, ClocheItems.MAIN_OUTPUT_UPGRADE.get())
                .pattern(" C ")
                .pattern("CUC")
                .pattern(" C ")
                .define('U', CoreItems.UPGRADE_BASE)
                .define('C', Items.GOLDEN_CARROT)
                .group("cloche")
                .unlockedBy("has_item", has(CoreItems.UPGRADE_BASE))
                .save(output);

        // End Upgrade - Crafting Recipe
        shaped(RecipeCategory.MISC, ClocheItems.END_UPGRADE.get())
                .pattern(" P ")
                .pattern("PUP")
                .pattern(" P ")
                .define('U', CoreItems.UPGRADE_BASE)
                .define('P', Items.PURPUR_BLOCK)
                .group("cloche")
                .unlockedBy("has_item", has(CoreItems.UPGRADE_BASE))
                .save(output);

        // Nether Upgrade - Crafting Recipe
        shaped(RecipeCategory.MISC, ClocheItems.NETHER_UPGRADE.get())
                .pattern(" W ")
                .pattern("WUW")
                .pattern(" W ")
                .define('U', CoreItems.UPGRADE_BASE)
                .define('W', Items.NETHER_WART_BLOCK)
                .group("cloche")
                .unlockedBy("has_item", has(CoreItems.UPGRADE_BASE))
                .save(output);

        // Overworld Upgrade - Crafting Recipe
        shaped(RecipeCategory.MISC, ClocheItems.OVERWORLD_UPGRADE.get())
                .pattern(" G ")
                .pattern("GUG")
                .pattern(" G ")
                .define('U', CoreItems.UPGRADE_BASE)
                .define('G', Items.GRASS_BLOCK)
                .group("cloche")
                .unlockedBy("has_item", has(CoreItems.UPGRADE_BASE))
                .save(output);

        // Twilight Forest Upgrade - Crafting Recipe
        shaped(RecipeCategory.MISC, ClocheItems.TWILIGHT_FOREST_UPGRADE.get())
                .pattern(" G ")
                .pattern("GUG")
                .pattern(" G ")
                .define('U', CoreItems.UPGRADE_BASE)
                .define('G', TagKey.create(Registries.ITEM, ResourceLocation.parse("twilightforest:logs")))
                .group("cloche")
                .unlockedBy("has_item", has(CoreItems.UPGRADE_BASE))
                .save(output.withConditions(new ModLoadedCondition("twilightforest")));

        // No Seed Upgrade - Crafting Recipe
        shaped(RecipeCategory.MISC, ClocheItems.NO_SEEDS_UPGRADE.get())
                .pattern(" S ")
                .pattern("SUS")
                .pattern(" S ")
                .define('U', CoreItems.UPGRADE_BASE)
                .define('S', Tags.Items.SEEDS)
                .group("cloche")
                .unlockedBy("has_item", has(CoreItems.UPGRADE_BASE))
                .save(output);

        // No Other Drops Upgrade
        shapeless(RecipeCategory.MISC, ClocheItems.NO_OTHER_DROPS_UPGRADE.get())
                .requires(ClocheItems.NO_SEEDS_UPGRADE.get())
                .requires(ClocheItems.MAIN_OUTPUT_UPGRADE.get())
                .unlockedBy("has_item", has(ClocheItems.NO_SEEDS_UPGRADE.get()))
                .save(output);

        // Cloche - Crafting Recipe
        shaped(RecipeCategory.MISC, ClocheBlocks.CLOCHE.get())
                .pattern("III")
                .pattern("WDW")
                .pattern("III")
                .define('I', Tags.Items.INGOTS_IRON)
                .define('W', Tags.Items.BUCKETS_WATER)
                .define('D', ItemTags.DIRT)
                .group("cloche")
                .unlockedBy("has_item", has(Tags.Items.INGOTS_IRON))
                .save(output);

        // Upgrades - Speed
        SpeedRecipeProvider.SpeedUpgradeRecipeBuilder(Ingredient.of(ClocheItems.FIXED_SPEED_UPGRADE_1), "fixed", 200)
                .unlockedBy("has_item", has(ClocheItems.FIXED_SPEED_UPGRADE_1))
                .save(output, String.valueOf(ResourceLocation.fromNamespaceAndPath(Cloche.MOD_ID, "upgrades/fixed_speed_1")));
        SpeedRecipeProvider.SpeedUpgradeRecipeBuilder(Ingredient.of(ClocheItems.FIXED_SPEED_UPGRADE_2), "fixed", 400)
                .unlockedBy("has_item", has(ClocheItems.FIXED_SPEED_UPGRADE_2))
                .save(output, String.valueOf(ResourceLocation.fromNamespaceAndPath(Cloche.MOD_ID, "upgrades/fixed_speed_2")));
        SpeedRecipeProvider.SpeedUpgradeRecipeBuilder(Ingredient.of(ClocheItems.FIXED_SPEED_UPGRADE_3), "fixed", 600)
                .unlockedBy("has_item", has(ClocheItems.FIXED_SPEED_UPGRADE_3))
                .save(output, String.valueOf(ResourceLocation.fromNamespaceAndPath(Cloche.MOD_ID, "upgrades/fixed_speed_3")));


        SpeedRecipeProvider.SpeedUpgradeRecipeBuilder(Ingredient.of(ClocheItems.PERCENTAGE_SPEED_UPGRADE_1), "percentage", 20)
                .unlockedBy("has_item", has(ClocheItems.PERCENTAGE_SPEED_UPGRADE_1))
                .save(output, String.valueOf(ResourceLocation.fromNamespaceAndPath(Cloche.MOD_ID, "upgrades/percentage_speed_1")));
        SpeedRecipeProvider.SpeedUpgradeRecipeBuilder(Ingredient.of(ClocheItems.PERCENTAGE_SPEED_UPGRADE_2), "percentage", 40)
                .unlockedBy("has_item", has(ClocheItems.PERCENTAGE_SPEED_UPGRADE_2))
                .save(output, String.valueOf(ResourceLocation.fromNamespaceAndPath(Cloche.MOD_ID, "upgrades/percentage_speed_2")));
        SpeedRecipeProvider.SpeedUpgradeRecipeBuilder(Ingredient.of(ClocheItems.PERCENTAGE_SPEED_UPGRADE_3), "percentage", 60)
                .unlockedBy("has_item", has(ClocheItems.PERCENTAGE_SPEED_UPGRADE_3))
                .save(output, String.valueOf(ResourceLocation.fromNamespaceAndPath(Cloche.MOD_ID, "upgrades/percentage_speed_3")));

        // Upgrades - Dimensional

        DimensionalUpgradeRecipeProvider.DimensionalUpgradeRecipeBuilder((Ingredient.of(ClocheItems.OVERWORLD_UPGRADE)), "minecraft:overworld")
                .unlockedBy("has_item", has(ClocheItems.OVERWORLD_UPGRADE))
                .save(output, String.valueOf(ResourceLocation.fromNamespaceAndPath(Cloche.MOD_ID, "upgrades/overworld")));

        DimensionalUpgradeRecipeProvider.DimensionalUpgradeRecipeBuilder((Ingredient.of(ClocheItems.NETHER_UPGRADE)), "minecraft:the_nether")
                .unlockedBy("has_item", has(ClocheItems.NETHER_UPGRADE))
                .save(output, String.valueOf(ResourceLocation.fromNamespaceAndPath(Cloche.MOD_ID, "upgrades/nether")));

        DimensionalUpgradeRecipeProvider.DimensionalUpgradeRecipeBuilder((Ingredient.of(ClocheItems.END_UPGRADE)), "minecraft:the_end")
                .unlockedBy("has_item", has(ClocheItems.END_UPGRADE))
                .save(output, String.valueOf(ResourceLocation.fromNamespaceAndPath(Cloche.MOD_ID, "upgrades/end")));

        // Cloche Wheat
        ClocheRecipeProvider.ClocheRecipeBuilder(Ingredient.of(Items.WHEAT_SEEDS), this.tag(ItemTags.DIRT), null,
                        null, 1200, ResultLists.WHEAT_RESULTS, null)
                .save(output, String.valueOf(ResourceLocation.fromNamespaceAndPath(Cloche.MOD_ID, "cloche/wheat")));

        // Cloche Potato
        ClocheRecipeProvider.ClocheRecipeBuilder(Ingredient.of(Items.POTATO), this.tag(ItemTags.DIRT), null,
                        null, 1200, ResultLists.POTATO_RESULTS, null)
                .save(output, String.valueOf(ResourceLocation.fromNamespaceAndPath(Cloche.MOD_ID, "cloche/potato")));

        // Cloche Beetroot
        ClocheRecipeProvider.ClocheRecipeBuilder(Ingredient.of(Items.BEETROOT_SEEDS), this.tag(ItemTags.DIRT), null,
                        null, 1200, ResultLists.BEETROOT_RESULTS, null)
                .save(output, String.valueOf(ResourceLocation.fromNamespaceAndPath(Cloche.MOD_ID, "cloche/beetroot")));

        // Cloche Melon
        ClocheRecipeProvider.ClocheRecipeBuilder(Ingredient.of(Items.MELON_SEEDS), this.tag(ItemTags.SAND), null,
                        null, 1200, ResultLists.MELON_RESULTS, null)
                .save(output, String.valueOf(ResourceLocation.fromNamespaceAndPath(Cloche.MOD_ID, "cloche/melon")));

        // Cloche Pumpkin
        ClocheRecipeProvider.ClocheRecipeBuilder(Ingredient.of(Items.PUMPKIN_SEEDS), this.tag(ItemTags.DIRT), null,
                        null, 1200, ResultLists.PUMPKIN_RESULTS, null)
                .save(output, String.valueOf(ResourceLocation.fromNamespaceAndPath(Cloche.MOD_ID, "cloche/pumpkin")));

        // Cloche Chorus Fruit
        ClocheRecipeProvider.ClocheRecipeBuilder(Ingredient.of(Items.CHORUS_FRUIT), Ingredient.of(Items.END_STONE), null,
                        "minecraft:the_end", 1200, ResultLists.CHORUS_FRUIT_RESULTS, null)
                .save(output, String.valueOf(ResourceLocation.fromNamespaceAndPath(Cloche.MOD_ID, "cloche/chorus_fruit")));

        // Oak Sapling
        ClocheRecipeProvider.ClocheRecipeBuilder(Ingredient.of(Items.OAK_SAPLING), this.tag(ItemTags.DIRT), null,
                        null, 1200, ResultLists.OAK_SAPLING_RESULTS, new ItemStack(Items.OAK_LEAVES, 2))
                .save(output, String.valueOf(ResourceLocation.fromNamespaceAndPath(Cloche.MOD_ID, "cloche/oak_sapling")));

        // Spruce Sapling
        ClocheRecipeProvider.ClocheRecipeBuilder(Ingredient.of(Items.SPRUCE_SAPLING), this.tag(ItemTags.DIRT), null,
                        null, 1200, ResultLists.SPRUCE_SAPLING_RESULTS, new ItemStack(Items.SPRUCE_LEAVES, 2))
                .save(output, String.valueOf(ResourceLocation.fromNamespaceAndPath(Cloche.MOD_ID, "cloche/spruce_sapling")));

        // Birch Sapling
        ClocheRecipeProvider.ClocheRecipeBuilder(Ingredient.of(Items.BIRCH_SAPLING), this.tag(ItemTags.DIRT), null,
                        null, 1200, ResultLists.BIRCH_SAPLING_RESULTS, new ItemStack(Items.BIRCH_LEAVES, 2))
                .save(output, String.valueOf(ResourceLocation.fromNamespaceAndPath(Cloche.MOD_ID, "cloche/birch_sapling")));

        // Jungle Sapling
        ClocheRecipeProvider.ClocheRecipeBuilder(Ingredient.of(Items.JUNGLE_SAPLING), this.tag(ItemTags.DIRT), null,
                        null, 1200, ResultLists.JUNGLE_SAPLING_RESULTS, new ItemStack(Items.JUNGLE_LEAVES, 2))
                .save(output, String.valueOf(ResourceLocation.fromNamespaceAndPath(Cloche.MOD_ID, "cloche/jungle_sapling")));

        // Acacia Sapling
        ClocheRecipeProvider.ClocheRecipeBuilder(Ingredient.of(Items.ACACIA_SAPLING), this.tag(ItemTags.DIRT), null,
                        null, 1200, ResultLists.ACACIA_SAPLING_RESULTS, new ItemStack(Items.ACACIA_LEAVES, 2))
                .save(output, String.valueOf(ResourceLocation.fromNamespaceAndPath(Cloche.MOD_ID, "cloche/acacia_sapling")));

        // Cherry Sapling
        ClocheRecipeProvider.ClocheRecipeBuilder(Ingredient.of(Items.CHERRY_SAPLING), this.tag(ItemTags.DIRT), null,
                        null, 1200, ResultLists.CHERRY_SAPLING_RESULTS, new ItemStack(Items.CHERRY_LEAVES, 2))
                .save(output, String.valueOf(ResourceLocation.fromNamespaceAndPath(Cloche.MOD_ID, "cloche/cherry_sapling")));

        //Mangrove Sapling
        ClocheRecipeProvider.ClocheRecipeBuilder(Ingredient.of(Items.MANGROVE_PROPAGULE), this.tag(ItemTags.DIRT), null,
                        null, 1200, ResultLists.MANGROVE_SAPLING_RESULTS, new ItemStack(Items.MANGROVE_LEAVES, 2))
                .save(output, String.valueOf(ResourceLocation.fromNamespaceAndPath(Cloche.MOD_ID, "cloche/mangrove_sapling")));

        // Dark Oak Sapling
        ClocheRecipeProvider.ClocheRecipeBuilder(Ingredient.of(Items.DARK_OAK_SAPLING), this.tag(ItemTags.DIRT), null,
                        null, 1200, ResultLists.DARK_OAK_SAPLING_RESULTS, new ItemStack(Items.DARK_OAK_LEAVES, 2))
                .save(output, String.valueOf(ResourceLocation.fromNamespaceAndPath(Cloche.MOD_ID, "cloche/dark_oak_sapling")));

        // Crimson Fungus
        ClocheRecipeProvider.ClocheRecipeBuilder(Ingredient.of(Items.CRIMSON_FUNGUS), this.tag(ItemTags.DIRT), null,
                        "minecraft:the_nether", 1200, ResultLists.CRIMSON_FUNGUS_RESULTS, null)
                .save(output, String.valueOf(ResourceLocation.fromNamespaceAndPath(Cloche.MOD_ID, "cloche/crimson_fungus")));

        // Warped Fungus
        ClocheRecipeProvider.ClocheRecipeBuilder(Ingredient.of(Items.WARPED_FUNGUS), this.tag(ItemTags.DIRT), null,
                        "minecraft:the_nether", 1200, ResultLists.WARPED_FUNGUS_RESULTS, null)
                .save(output, String.valueOf(ResourceLocation.fromNamespaceAndPath(Cloche.MOD_ID, "cloche/warped_fungus")));

        // Single Item Recipes
        createSingleItemRecipe(new ItemStack(Items.DANDELION), this.tag(ItemTags.DIRT), 1200, "dandelion", output);
        createSingleItemRecipe(new ItemStack(Items.POPPY), this.tag(ItemTags.DIRT), 1200, "poppy", output);
        createSingleItemRecipe(new ItemStack(Items.BLUE_ORCHID), this.tag(ItemTags.DIRT), 1200, "blue_orchid", output);
        createSingleItemRecipe(new ItemStack(Items.ALLIUM), this.tag(ItemTags.DIRT), 1200, "allium", output);
        createSingleItemRecipe(new ItemStack(Items.AZURE_BLUET), this.tag(ItemTags.DIRT), 1200, "azure_bluet", output);
        createSingleItemRecipe(new ItemStack(Items.RED_TULIP), this.tag(ItemTags.DIRT), 1200, "red_tulip", output);
        createSingleItemRecipe(new ItemStack(Items.ORANGE_TULIP), this.tag(ItemTags.DIRT), 1200, "orange_tulip", output);
        createSingleItemRecipe(new ItemStack(Items.WHITE_TULIP), this.tag(ItemTags.DIRT), 1200, "white_tulip", output);
        createSingleItemRecipe(new ItemStack(Items.PINK_TULIP), this.tag(ItemTags.DIRT), 1200, "pink_tulip", output);
        createSingleItemRecipe(new ItemStack(Items.OXEYE_DAISY), this.tag(ItemTags.DIRT), 1200, "oxeye_daisy", output);
        createSingleItemRecipe(new ItemStack(Items.CORNFLOWER), this.tag(ItemTags.DIRT), 1200, "cornflower", output);
        createSingleItemRecipe(new ItemStack(Items.LILY_OF_THE_VALLEY), this.tag(ItemTags.DIRT), 1200, "lily_of_the_valley", output);
        createSingleItemRecipe(new ItemStack(Items.WITHER_ROSE), this.tag(ItemTags.DIRT), 1200, "wither_rose", output);
        createSingleItemRecipe(new ItemStack(Items.PINK_PETALS), this.tag(ItemTags.DIRT), 1200, "pink_petals", output);
        createSingleItemRecipe(new ItemStack(Items.SPORE_BLOSSOM), this.tag(ItemTags.DIRT), 1200, "spore_blossom", output);
        createSingleItemRecipe(new ItemStack(Items.FERN), this.tag(ItemTags.DIRT), 1200, "fern", output);
        createSingleItemRecipe(new ItemStack(Items.SHORT_GRASS), this.tag(ItemTags.DIRT), 1200, "short_grass", output);
        createSingleItemRecipe(new ItemStack(Items.SUNFLOWER), this.tag(ItemTags.DIRT), 1200, "sunflower", output);
        createSingleItemRecipe(new ItemStack(Items.LILAC), this.tag(ItemTags.DIRT), 1200, "lilac", output);
        createSingleItemRecipe(new ItemStack(Items.ROSE_BUSH), this.tag(ItemTags.DIRT), 1200, "rose_bush", output);
        createSingleItemRecipe(new ItemStack(Items.PEONY), this.tag(ItemTags.DIRT), 1200, "peony", output);
        createSingleItemRecipe(new ItemStack(Items.GLOW_LICHEN),this.tag(Tags.Items.STONES), 1200, "glow_lichen", output);
        createSingleItemRecipe(new ItemStack(Items.LILY_PAD), this.tag(Tags.Items.BUCKETS_WATER), 1200, "lily_pad", output);
        createSingleItemRecipe(new ItemStack(Items.SEAGRASS), this.tag(Tags.Items.BUCKETS_WATER), 1200, "seagrass", output);
        createSingleItemRecipe(new ItemStack(Items.SEA_PICKLE), this.tag(Tags.Items.BUCKETS_WATER), 1200, "sea_pickle", output);
        createSingleItemRecipe(new ItemStack(Items.KELP), this.tag(Tags.Items.BUCKETS_WATER), 1200, "kelp", output);
        createSingleItemRecipe(new ItemStack(Items.VINE), this.tag(ItemTags.JUNGLE_LOGS), 1200, "vine", output);
        createSingleItemRecipe(new ItemStack(Items.COCOA_BEANS), this.tag(ItemTags.JUNGLE_LOGS), 1200, "cocoa_beans", output);
        createSingleItemRecipe(new ItemStack(Items.BAMBOO), this.tag(ItemTags.DIRT), 1200, "bamboo", output);
        createSingleItemRecipe(new ItemStack(Items.SUGAR_CANE), this.tag(ItemTags.DIRT), 1200, "sugar_cane", output);
        createSingleItemRecipe(new ItemStack(Items.CACTUS), this.tag(ItemTags.SAND), 1200, "cactus", output);
        createSingleItemRecipe(new ItemStack(Items.SWEET_BERRIES), this.tag(ItemTags.DIRT), 1200, "sweet_berries", output);
        createSingleItemRecipe(new ItemStack(Items.NETHER_WART), Ingredient.of(Items.SOUL_SAND), 1200, "nether_wart", output);
        createSingleItemRecipe(new ItemStack(Items.CARROT), this.tag(ItemTags.DIRT), 1200, "carrot", output);
        createSingleItemRecipe(new ItemStack(Items.BROWN_MUSHROOM), this.tag(ItemTags.DIRT), 1200, "brown_mushroom", output);
        createSingleItemRecipe(new ItemStack(Items.RED_MUSHROOM), this.tag(ItemTags.DIRT), 1200, "red_mushroom", output);

    }



    public void createSingleItemRecipe(ItemStack item, Ingredient soil, int duration, String name, RecipeOutput consumer) {

        NonNullList<ChanceResult> SINGLE_ITEM_RESULTS = NonNullList.create();
        SINGLE_ITEM_RESULTS.add(new ChanceResult(new ItemStack(item.getItem()), 1.0f));

        ClocheRecipeProvider.ClocheRecipeBuilder(Ingredient.of(item.getItem()), soil, null,
                        null, duration, SINGLE_ITEM_RESULTS, null)
                .save(consumer, String.valueOf(ResourceLocation.fromNamespaceAndPath(Cloche.MOD_ID, "cloche/" + name)));

    }

    /*
    public void createSingleItemRecipe(ItemStack item, TagKey<Item> soil, int duration, String name, RecipeOutput consumer) {

        NonNullList<ChanceResult> SINGLE_ITEM_RESULTS = NonNullList.create();
        SINGLE_ITEM_RESULTS.add(new ChanceResult(new ItemStack(item.getItem()), 1.0f));

        ClocheRecipeProvider.ClocheRecipeBuilder(Ingredient.of(item.getItem()), soil
                        , null,
                        null, duration, SINGLE_ITEM_RESULTS, null)
                .save(consumer, String.valueOf(ResourceLocation.fromNamespaceAndPath(Cloche.MOD_ID, "cloche/" + name)));

    }

     */
}
