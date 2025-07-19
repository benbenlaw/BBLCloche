package com.benbenlaw.cloche.util;

import com.benbenlaw.cloche.recipe.ClocheRecipe;
import net.minecraft.resources.ResourceLocation;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class ClientClocheRecipeCache {

    public static Map<ResourceLocation, ClocheRecipe> cachedRecipes = new HashMap<>();

    public static void setRecipe(Map<ResourceLocation, ClocheRecipe> recipes) {
        cachedRecipes = recipes;
    }

    public static Collection<ClocheRecipe> getRecipes() {
        return cachedRecipes.values();
    }
}
