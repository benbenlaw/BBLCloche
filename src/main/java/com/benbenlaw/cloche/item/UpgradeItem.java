package com.benbenlaw.cloche.item;

import com.benbenlaw.core.item.TooltipUtil;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.component.TooltipDisplay;

import java.util.List;
import java.util.function.Consumer;

public class UpgradeItem extends Item {
    private final String tooltip;

    public UpgradeItem(Properties properties, String tooltip) {
        super(properties);
        this.tooltip = tooltip;
    }

    @Override
    public void appendHoverText(ItemStack p_41421_, TooltipContext p_339594_, TooltipDisplay p_399753_, Consumer<Component> p_399884_, TooltipFlag p_41424_) {
        TooltipUtil.addShiftTooltip(p_399753_,p_399884_, Component.nullToEmpty(tooltip));
    }
}
