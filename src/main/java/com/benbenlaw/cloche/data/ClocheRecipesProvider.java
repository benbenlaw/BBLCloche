package com.benbenlaw.cloche.data;

import com.benbenlaw.cloche.Cloche;
import com.benbenlaw.cloche.block.ClocheBlocks;
import com.benbenlaw.cloche.data.recipe.ClocheRecipeProvider;
import com.benbenlaw.cloche.data.recipe.ResultLists;
import com.benbenlaw.cloche.item.ClocheItems;
import com.benbenlaw.core.item.CoreItems;
import com.benbenlaw.core.recipe.ChanceResult;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.NonNullList;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.neoforged.neoforge.common.Tags;
import org.jetbrains.annotations.NotNull;

import java.util.concurrent.CompletableFuture;

public class ClocheRecipesProvider extends RecipeProvider {

    public ClocheRecipesProvider(HolderLookup.Provider provider, RecipeOutput output) {
        super(provider, output);
    }

    public static class Runner extends RecipeProvider.Runner {
        public Runner(PackOutput packOutput, CompletableFuture<HolderLookup.Provider> provider) {
            super(packOutput, provider);
        }

        @Override
        protected @NotNull RecipeProvider createRecipeProvider(HolderLookup.@NotNull Provider provider, @NotNull RecipeOutput recipeOutput) {
            return new ClocheRecipesProvider(provider, recipeOutput);
        }

        @Override
        public @NotNull String getName() {
            return Cloche.MOD_ID + " Recipes";
        }
    }
    
    
    @Override
    protected void buildRecipes() {
        
        // Shears Upgrade - Crafting Recipe
        shaped(RecipeCategory.MISC, ClocheItems.SHEARS_UPGRADE.get())
                .pattern(" A ")
                .pattern("ABA")
                .pattern(" A ")
                .define('A', Tags.Items.TOOLS_SHEAR)
                .define('B', CoreItems.UPGRADE_BASE.get())
                .group("cloche")
                .unlockedBy("has_item", has(CoreItems.UPGRADE_BASE.get()))
                .save(output);

        // Main Output Upgrade - Crafting Recipe
        shaped(RecipeCategory.MISC, ClocheItems.MAIN_OUTPUT_UPGRADE.get())
                .pattern(" A ")
                .pattern("ABA")
                .pattern(" A ")
                .define('A', Items.GOLDEN_CARROT)
                .define('B', CoreItems.UPGRADE_BASE.get())
                .group("cloche")
                .unlockedBy("has_item", has(CoreItems.UPGRADE_BASE.get()))
                .save(output);

        // No Seed Upgrade - Crafting Recipe
        shaped(RecipeCategory.MISC, ClocheItems.NO_SEEDS_UPGRADE.get())
                .pattern(" A ")
                .pattern("ABA")
                .pattern(" A ")
                .define('A', Tags.Items.SEEDS)
                .define('B', CoreItems.UPGRADE_BASE.get())
                .group("cloche")
                .unlockedBy("has_item", has(CoreItems.UPGRADE_BASE.get()))
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
                .define('D',  ItemTags.DIRT)
                .group("cloche")
                .unlockedBy("has_item", has(Tags.Items.INGOTS_IRON))
                .save(output);
        

        // Cloche Wheat
        ClocheRecipeProvider.ClocheRecipeBuilder(Ingredient.of(Items.WHEAT_SEEDS), tag(ItemTags.DIRT),
                        null, 1200, ResultLists.WHEAT_RESULTS, null)
                .save(output, "cloche/wheat");

        // Cloche Potato
        ClocheRecipeProvider.ClocheRecipeBuilder(Ingredient.of(Items.POTATO), tag(ItemTags.DIRT),
                        null, 1200, ResultLists.POTATO_RESULTS, null)
                .save(output, "cloche/potato");

        // Cloche Beetroot
        ClocheRecipeProvider.ClocheRecipeBuilder(Ingredient.of(Items.BEETROOT_SEEDS),tag(ItemTags.DIRT),
                        null, 1200, ResultLists.BEETROOT_RESULTS, null)
                .save(output, "cloche/beetroot");

        // Cloche Melon
        ClocheRecipeProvider.ClocheRecipeBuilder(Ingredient.of(Items.MELON_SEEDS), tag(ItemTags.DIRT),
                        null, 1200, ResultLists.MELON_RESULTS, null)
                .save(output, "cloche/melon");

        // Cloche Pumpkin
        ClocheRecipeProvider.ClocheRecipeBuilder(Ingredient.of(Items.PUMPKIN_SEEDS), tag(ItemTags.DIRT),
                        null, 1200, ResultLists.PUMPKIN_RESULTS, null)
                .save(output, "cloche/pumpkin");

        // Cloche Chorus Fruit
        ClocheRecipeProvider.ClocheRecipeBuilder(Ingredient.of(Items.CHORUS_FRUIT), Ingredient.of(Items.END_STONE),
                        null, 1200, ResultLists.CHORUS_FRUIT_RESULTS, null)
                .save(output, "cloche/chorus_fruit");

        // Oak Sapling
        ClocheRecipeProvider.ClocheRecipeBuilder(Ingredient.of(Items.OAK_SAPLING), tag(ItemTags.DIRT),
                        null, 1200, ResultLists.OAK_SAPLING_RESULTS, new ItemStack(Items.OAK_LEAVES, 2))
                .save(output, "cloche/oak_sapling");

        // Spruce Sapling
        ClocheRecipeProvider.ClocheRecipeBuilder(Ingredient.of(Items.SPRUCE_SAPLING), tag(ItemTags.DIRT),
                        null, 1200, ResultLists.SPRUCE_SAPLING_RESULTS, new ItemStack(Items.SPRUCE_LEAVES, 2))
                .save(output, "cloche/spruce_sapling");

        // Birch Sapling
        ClocheRecipeProvider.ClocheRecipeBuilder(Ingredient.of(Items.BIRCH_SAPLING), tag(ItemTags.DIRT),
                        null, 1200, ResultLists.BIRCH_SAPLING_RESULTS, new ItemStack(Items.BIRCH_LEAVES, 2))
                .save(output, "cloche/birch_sapling");

        // Jungle Sapling
        ClocheRecipeProvider.ClocheRecipeBuilder(Ingredient.of(Items.JUNGLE_SAPLING), tag(ItemTags.DIRT),
                        null, 1200, ResultLists.JUNGLE_SAPLING_RESULTS, new ItemStack(Items.JUNGLE_LEAVES, 2))
                .save(output, "cloche/jungle_sapling");

        // Acacia Sapling
        ClocheRecipeProvider.ClocheRecipeBuilder(Ingredient.of(Items.ACACIA_SAPLING), tag(ItemTags.DIRT),
                        null, 1200, ResultLists.ACACIA_SAPLING_RESULTS, new ItemStack(Items.ACACIA_LEAVES, 2))
                .save(output, "cloche/acacia_sapling");

        // Cherry Sapling
        ClocheRecipeProvider.ClocheRecipeBuilder(Ingredient.of(Items.CHERRY_SAPLING), tag(ItemTags.DIRT),
                        null, 1200, ResultLists.CHERRY_SAPLING_RESULTS, new ItemStack(Items.CHERRY_LEAVES, 2))
                .save(output, "cloche/cherry_sapling");

        //Mangrove Sapling
        ClocheRecipeProvider.ClocheRecipeBuilder(Ingredient.of(Items.MANGROVE_PROPAGULE), tag(ItemTags.DIRT),
                        null, 1200, ResultLists.MANGROVE_SAPLING_RESULTS, new ItemStack(Items.MANGROVE_LEAVES, 2))
                .save(output, "cloche/mangrove_sapling");

        // Dark Oak Sapling
        ClocheRecipeProvider.ClocheRecipeBuilder(Ingredient.of(Items.DARK_OAK_SAPLING), tag(ItemTags.DIRT),
                        null, 1200, ResultLists.DARK_OAK_SAPLING_RESULTS, new ItemStack(Items.DARK_OAK_LEAVES, 2))
                .save(output, "cloche/dark_oak_sapling");

        // Crimson Fungus
        ClocheRecipeProvider.ClocheRecipeBuilder(Ingredient.of(Items.CRIMSON_FUNGUS), tag(ItemTags.DIRT),
                        null, 1200, ResultLists.CRIMSON_FUNGUS_RESULTS, null)
                .save(output, "cloche/crimson_fungus");

        // Warped Fungus
        ClocheRecipeProvider.ClocheRecipeBuilder(Ingredient.of(Items.WARPED_FUNGUS), tag(ItemTags.DIRT),
                        null, 1200, ResultLists.WARPED_FUNGUS_RESULTS, null)
                .save(output, "cloche/warped_fungus");

        // Single Item Recipes
        createSingleItemRecipe(new ItemStack(Items.DANDELION), tag(ItemTags.DIRT), 1200, "dandelion", output);
        createSingleItemRecipe(new ItemStack(Items.POPPY), tag(ItemTags.DIRT), 1200, "poppy", output);
        createSingleItemRecipe(new ItemStack(Items.BLUE_ORCHID), tag(ItemTags.DIRT), 1200, "blue_orchid", output);
        createSingleItemRecipe(new ItemStack(Items.ALLIUM), tag(ItemTags.DIRT), 1200, "allium", output);
        createSingleItemRecipe(new ItemStack(Items.AZURE_BLUET), tag(ItemTags.DIRT), 1200, "azure_bluet", output);
        createSingleItemRecipe(new ItemStack(Items.RED_TULIP), tag(ItemTags.DIRT), 1200, "red_tulip", output);
        createSingleItemRecipe(new ItemStack(Items.ORANGE_TULIP), tag(ItemTags.DIRT), 1200, "orange_tulip", output);
        createSingleItemRecipe(new ItemStack(Items.WHITE_TULIP), tag(ItemTags.DIRT), 1200, "white_tulip", output);
        createSingleItemRecipe(new ItemStack(Items.PINK_TULIP), tag(ItemTags.DIRT), 1200, "pink_tulip", output);
        createSingleItemRecipe(new ItemStack(Items.OXEYE_DAISY), tag(ItemTags.DIRT), 1200, "oxeye_daisy", output);
        createSingleItemRecipe(new ItemStack(Items.CORNFLOWER), tag(ItemTags.DIRT), 1200, "cornflower", output);
        createSingleItemRecipe(new ItemStack(Items.LILY_OF_THE_VALLEY), tag(ItemTags.DIRT), 1200, "lily_of_the_valley", output);
        createSingleItemRecipe(new ItemStack(Items.WITHER_ROSE), tag(ItemTags.DIRT), 1200, "wither_rose", output);
        createSingleItemRecipe(new ItemStack(Items.PINK_PETALS), tag(ItemTags.DIRT), 1200, "pink_petals", output);
        createSingleItemRecipe(new ItemStack(Items.SPORE_BLOSSOM), tag(ItemTags.DIRT), 1200, "spore_blossom", output);
        createSingleItemRecipe(new ItemStack(Items.FERN), tag(ItemTags.DIRT), 1200, "fern", output);
        createSingleItemRecipe(new ItemStack(Items.SHORT_GRASS), tag(ItemTags.DIRT), 1200, "short_grass", output);
        createSingleItemRecipe(new ItemStack(Items.SUNFLOWER), tag(ItemTags.DIRT), 1200, "sunflower", output);
        createSingleItemRecipe(new ItemStack(Items.LILAC), tag(ItemTags.DIRT), 1200, "lilac", output);
        createSingleItemRecipe(new ItemStack(Items.ROSE_BUSH), tag(ItemTags.DIRT), 1200, "rose_bush", output);
        createSingleItemRecipe(new ItemStack(Items.PEONY), tag(ItemTags.DIRT), 1200, "peony", output);
        createSingleItemRecipe(new ItemStack(Items.GLOW_LICHEN), tag(Tags.Items.STONES), 1200, "glow_lichen", output);
        createSingleItemRecipe(new ItemStack(Items.LILY_PAD), tag(Tags.Items.BUCKETS_WATER), 1200, "lily_pad", output);
        createSingleItemRecipe(new ItemStack(Items.SEAGRASS), tag(Tags.Items.BUCKETS_WATER), 1200, "seagrass", output);
        createSingleItemRecipe(new ItemStack(Items.SEA_PICKLE), tag(Tags.Items.BUCKETS_WATER), 1200, "sea_pickle", output);
        createSingleItemRecipe(new ItemStack(Items.KELP), tag(Tags.Items.BUCKETS_WATER), 1200, "kelp", output);
        createSingleItemRecipe(new ItemStack(Items.VINE), tag(ItemTags.JUNGLE_LOGS), 1200, "vine", output);
        createSingleItemRecipe(new ItemStack(Items.COCOA_BEANS), tag(ItemTags.JUNGLE_LOGS), 1200, "cocoa_beans", output);
        createSingleItemRecipe(new ItemStack(Items.BAMBOO), tag(ItemTags.DIRT), 1200, "bamboo", output);
        createSingleItemRecipe(new ItemStack(Items.SUGAR_CANE), tag(ItemTags.DIRT), 1200, "sugar_cane", output);
        createSingleItemRecipe(new ItemStack(Items.CACTUS), tag(ItemTags.SAND), 1200, "cactus", output);
        createSingleItemRecipe(new ItemStack(Items.SWEET_BERRIES), tag(ItemTags.DIRT), 1200, "sweet_berries", output);
        createSingleItemRecipe(new ItemStack(Items.NETHER_WART), Ingredient.of(Items.SOUL_SAND), 1200, "nether_wart", output);
        createSingleItemRecipe(new ItemStack(Items.CARROT), tag(ItemTags.DIRT), 1200, "carrot", output);
        createSingleItemRecipe(new ItemStack(Items.BROWN_MUSHROOM), tag(ItemTags.DIRT), 1200, "brown_mushroom", output);
        createSingleItemRecipe(new ItemStack(Items.RED_MUSHROOM), tag(ItemTags.DIRT), 1200, "red_mushroom", output);
    }

    public void createSingleItemRecipe(ItemStack item, Ingredient soil, int duration, String name, RecipeOutput consumer) {

        NonNullList<ChanceResult> SINGLE_ITEM_RESULTS = NonNullList.create();
        SINGLE_ITEM_RESULTS.add(new ChanceResult(new ItemStack(item.getItem()), 1.0f));

        ClocheRecipeProvider.ClocheRecipeBuilder(Ingredient.of(item.getItem()), soil,
                        null, duration, SINGLE_ITEM_RESULTS, null)
                .save(output, "cloche/" + name);

    }
}
