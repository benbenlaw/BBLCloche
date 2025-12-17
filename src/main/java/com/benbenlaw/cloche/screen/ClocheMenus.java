package com.benbenlaw.cloche.screen;

import com.benbenlaw.cloche.Cloche;
import com.benbenlaw.cloche.screen.cloche.ClocheMenu;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.inventory.MenuType;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.common.extensions.IMenuTypeExtension;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ClocheMenus {
    public static final DeferredRegister<MenuType<?>> MENUS = DeferredRegister.create(BuiltInRegistries.MENU, Cloche.MOD_ID);

    public static final DeferredHolder<MenuType<?>, MenuType<ClocheMenu>> CLOCHE_MENU = MENUS.register("cloche_menu",
            () -> IMenuTypeExtension.create(ClocheMenu::new));
}


