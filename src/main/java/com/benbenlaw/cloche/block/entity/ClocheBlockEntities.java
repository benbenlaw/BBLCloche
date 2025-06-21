package com.benbenlaw.cloche.block.entity;

import com.benbenlaw.cloche.Cloche;
import com.benbenlaw.cloche.block.ClocheBlocks;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.capabilities.Capabilities;
import net.neoforged.neoforge.capabilities.RegisterCapabilitiesEvent;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

import javax.annotation.Nonnull;
import java.util.function.Supplier;

public class ClocheBlockEntities {

    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES =
            DeferredRegister.create(BuiltInRegistries.BLOCK_ENTITY_TYPE, Cloche.MOD_ID);

    public static final Supplier<BlockEntityType<ClocheBlockEntity>> CLOCHE_BLOCK_ENTITY =
            BLOCK_ENTITIES.register("cloche_block_entity", () ->
                    new BlockEntityType<>(ClocheBlockEntity::new, ClocheBlocks.CLOCHE.get()));




    public static void registerCapabilities(RegisterCapabilitiesEvent event) {
        event.registerBlockEntity(Capabilities.ItemHandler.BLOCK,
                ClocheBlockEntities.CLOCHE_BLOCK_ENTITY.get(), ClocheBlockEntity::getItemHandlerCapability);
    }
}
