package com.benbenlaw.cloche.util;

import com.benbenlaw.cloche.recipe.DimensionalUpgradeRecipe;
import com.benbenlaw.cloche.recipe.SpeedUpgradeRecipe;
import net.minecraft.resources.ResourceLocation;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class ClientSpeedUpgradeRecipeCache {

    private static Map<ResourceLocation, SpeedUpgradeRecipe> cachedRecipes = new HashMap<>();

    public static void setRecipe(Map<ResourceLocation, SpeedUpgradeRecipe> recipes) {
        cachedRecipes = recipes;
    }

    public static Collection<SpeedUpgradeRecipe> getRecipes() {
        return cachedRecipes.values();
    }
}
