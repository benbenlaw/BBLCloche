package com.benbenlaw.cloche.block;

import com.benbenlaw.cloche.Cloche;
import com.benbenlaw.cloche.block.entity.ClocheBlockEntity;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class ClocheBlockEntities {

    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES = DeferredRegister.create(BuiltInRegistries.BLOCK_ENTITY_TYPE, Cloche.MOD_ID);


    public static final Supplier<BlockEntityType<ClocheBlockEntity>> CLOCHE_BLOCK_ENTITY =
            BLOCK_ENTITIES.register("cloche_block_entity", () ->
                    new BlockEntityType<>(ClocheBlockEntity::new, ClocheBlocks.CLOCHE.get()));

}
