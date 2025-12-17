package com.benbenlaw.cloche.item;

import com.benbenlaw.cloche.Cloche;
import com.benbenlaw.cloche.block.ClocheBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class ClocheCreativeTab {

    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, Cloche.MOD_ID);

    public static final Supplier<CreativeModeTab> CLOCHE_TAB = CREATIVE_MODE_TABS.register("cloche", () -> CreativeModeTab.builder()
            .withTabsBefore(CreativeModeTabs.COMBAT)
            .icon(() -> ClocheBlocks.CLOCHE.get().asItem().getDefaultInstance())
            .title(Component.translatable("itemGroup.cloche"))
            .displayItems(ClocheItems.ITEMS.getEntries()).build());
}
