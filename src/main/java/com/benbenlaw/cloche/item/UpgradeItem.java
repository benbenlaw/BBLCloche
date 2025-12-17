package com.benbenlaw.cloche.item;

import net.minecraft.ChatFormatting;
import net.minecraft.client.Minecraft;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.component.TooltipDisplay;
import org.jetbrains.annotations.NotNull;

import java.util.function.Consumer;

public class UpgradeItem extends Item {
    private final String tooltip;

    public UpgradeItem(Properties properties, String tooltip) {
        super(properties);
        this.tooltip = tooltip;
    }

    @SuppressWarnings("deprecation")
    @Override
    public void appendHoverText(@NotNull ItemStack stack, @NotNull TooltipContext context, @NotNull TooltipDisplay display, @NotNull Consumer<Component> consumer, TooltipFlag flag) {
        if (Minecraft.getInstance().hasShiftDown()) {
            consumer.accept(Component.translatable(tooltip).withStyle(ChatFormatting.BLUE));
        } else {
            consumer.accept(Component.translatable("tooltip.bblcore.shift").withStyle(ChatFormatting.YELLOW));
        }
    }
}
