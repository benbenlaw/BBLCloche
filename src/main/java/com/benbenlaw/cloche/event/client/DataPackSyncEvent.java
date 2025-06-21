package com.benbenlaw.cloche.event.client;

import com.benbenlaw.cloche.Cloche;
import com.benbenlaw.cloche.recipe.ClocheRecipe;
import com.benbenlaw.cloche.recipe.ClocheRecipes;
import com.benbenlaw.cloche.recipe.DimensionalUpgradeRecipe;
import com.benbenlaw.cloche.recipe.SpeedUpgradeRecipe;
import com.benbenlaw.cloche.util.ClientClocheRecipeCache;
import com.benbenlaw.cloche.util.ClientDimensionalUpgradeRecipeCache;
import com.benbenlaw.cloche.util.ClientSpeedUpgradeRecipeCache;
import com.nimbusds.jose.util.Resource;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.crafting.*;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.RecipesReceivedEvent;
import net.neoforged.neoforge.event.OnDatapackSyncEvent;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@EventBusSubscriber(modid = Cloche.MOD_ID)
public class DataPackSyncEvent {



    @SubscribeEvent
    public static void onDataPackSync(OnDatapackSyncEvent event) {

        event.sendRecipes(ClocheRecipes.CLOCHE_TYPE.get());
        event.sendRecipes(ClocheRecipes.DIMENSIONAL_UPGRADE_TYPE.get());
        event.sendRecipes(ClocheRecipes.SPEED_UPGRADE_TYPE.get());

    }

    @SubscribeEvent
    public static void onRecipeReceived(RecipesReceivedEvent event) {

        RecipeMap recipeMap = event.getRecipeMap();

        Collection<RecipeHolder<ClocheRecipe>> clocheRecipes = recipeMap.byType(ClocheRecipes.CLOCHE_TYPE.get());
        Collection<RecipeHolder<DimensionalUpgradeRecipe>> dimensionalUpgradeRecipes = recipeMap.byType(ClocheRecipes.DIMENSIONAL_UPGRADE_TYPE.get());
        Collection<RecipeHolder<SpeedUpgradeRecipe>> speedUpgradeRecipes = recipeMap.byType(ClocheRecipes.SPEED_UPGRADE_TYPE.get());

        Map<ResourceLocation, ClocheRecipe> clocheRecipeMap = new HashMap<>();
        Map<ResourceLocation, DimensionalUpgradeRecipe> dimensionalUpgradeRecipeMap = new HashMap<>();
        Map<ResourceLocation, SpeedUpgradeRecipe> speedUpgradeRecipeMap = new HashMap<>();

        for (RecipeHolder<ClocheRecipe> recipeHolder : clocheRecipes) {
            clocheRecipeMap.put(recipeHolder.id().location(), recipeHolder.value());
        }

        for (RecipeHolder<DimensionalUpgradeRecipe> recipeHolder : dimensionalUpgradeRecipes) {
            dimensionalUpgradeRecipeMap.put(recipeHolder.id().location(), recipeHolder.value());
        }

        for (RecipeHolder<SpeedUpgradeRecipe> recipeHolder : speedUpgradeRecipes) {
            speedUpgradeRecipeMap.put(recipeHolder.id().location(), recipeHolder.value());
        }

        ClientClocheRecipeCache.setRecipe(clocheRecipeMap);
        ClientDimensionalUpgradeRecipeCache.setRecipe(dimensionalUpgradeRecipeMap);
        ClientSpeedUpgradeRecipeCache.setRecipe(speedUpgradeRecipeMap);


    }
}
