package com.benbenlaw.cloche.data;

import com.benbenlaw.cloche.Cloche;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.minecraft.data.loot.LootTableProvider;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.data.event.GatherDataEvent;

import java.util.Collections;
import java.util.List;
import java.util.concurrent.CompletableFuture;

@EventBusSubscriber(modid = Cloche.MOD_ID, bus = EventBusSubscriber.Bus.MOD)
public class DataGenerators {


    @SubscribeEvent
    public static void gatherData(GatherDataEvent.Client event) {

        DataGenerator generator = event.getGenerator();
        PackOutput packOutput = generator.getPackOutput();
        CompletableFuture<HolderLookup.Provider> lookupProvider = event.getLookupProvider();

        generator.addProvider(true, new ClocheRecipesData.Runner(packOutput, event.getLookupProvider()));

        generator.addProvider(true, new LootTableProvider(packOutput, Collections.emptySet(),
                List.of(new LootTableProvider.SubProviderEntry(ClocheLootTableProvider::new, LootContextParamSets.BLOCK)), event.getLookupProvider()));

        ClocheBlockTags blockTags = new ClocheBlockTags(packOutput, lookupProvider);
        generator.addProvider(true, blockTags);

        ClocheItemTags itemTags = new ClocheItemTags(packOutput, lookupProvider);
        generator.addProvider(true, itemTags);

        generator.addProvider(true, new ClocheModelProvider(packOutput));
    }
}

