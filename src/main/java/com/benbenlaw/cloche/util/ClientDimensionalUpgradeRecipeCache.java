package com.benbenlaw.cloche.util;

import com.benbenlaw.cloche.recipe.ClocheRecipe;
import com.benbenlaw.cloche.recipe.DimensionalUpgradeRecipe;
import net.minecraft.resources.ResourceLocation;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class ClientDimensionalUpgradeRecipeCache {

    private static Map<ResourceLocation, DimensionalUpgradeRecipe> cachedRecipes = new HashMap<>();

    public static void setRecipe(Map<ResourceLocation, DimensionalUpgradeRecipe> recipes) {
        cachedRecipes = recipes;
    }

    public static Collection<DimensionalUpgradeRecipe> getRecipes() {
        return cachedRecipes.values();
    }
}
