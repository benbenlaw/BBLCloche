package com.benbenlaw.cloche.event.client;

import com.benbenlaw.cloche.Cloche;
import com.benbenlaw.cloche.block.ClocheBlocks;
import com.benbenlaw.cloche.item.ClocheItems;
import com.benbenlaw.core.util.TooltipUtil;
import net.minecraft.ChatFormatting;
import net.minecraft.client.Minecraft;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.event.CommandEvent;
import net.neoforged.neoforge.event.entity.player.ItemTooltipEvent;

@EventBusSubscriber(modid = Cloche.MOD_ID)
public class TooltipEvent {

    @SubscribeEvent
    public static void onTooltipEvent(ItemTooltipEvent event) {
        ItemStack stack = event.getItemStack();

        TooltipUtil.addShiftTooltip(stack, event, ClocheItems.NO_OTHER_DROPS_UPGRADE.asItem(), "tooltip.cloche.no_other_drops_upgrade");
        TooltipUtil.addShiftTooltip(stack, event, ClocheItems.SHEARS_UPGRADE.asItem(), "tooltip.cloche.shears_upgrade");
        TooltipUtil.addShiftTooltip(stack, event, ClocheItems.MAIN_OUTPUT_UPGRADE.asItem(), "tooltip.cloche.main_output_upgrade");
        TooltipUtil.addShiftTooltip(stack, event, ClocheItems.NO_SEEDS_UPGRADE.asItem(), "tooltip.cloche.no_seeds_upgrade");
        TooltipUtil.addShiftTooltip(stack, event, ClocheBlocks.CLOCHE.asItem(), "tooltip.cloche.cloche");
    }

}


