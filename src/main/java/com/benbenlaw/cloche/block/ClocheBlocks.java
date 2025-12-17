package com.benbenlaw.cloche.block;

import com.benbenlaw.cloche.Cloche;
import com.benbenlaw.cloche.block.custom.ClocheBlock;
import com.benbenlaw.cloche.item.ClocheItems;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class ClocheBlocks {

    public static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(Cloche.MOD_ID);


    public static final DeferredBlock<Block> CLOCHE = registerBlock("cloche",
            () -> new ClocheBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE)
                    .noOcclusion().setId(createID("cloche"))));



    private static <T extends Block> DeferredBlock<T> registerBlock(String name, Supplier<T> block) {
        DeferredBlock<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    private static <T extends Block> void registerBlockItem(String name, DeferredBlock<T> block) {
        ClocheItems.ITEMS.registerItem(name, (properties) -> new BlockItem(block.get(), properties.useBlockDescriptionPrefix()));
    }

    public static ResourceKey<Block> createID(String name) {
        return ResourceKey.create(Registries.BLOCK, Cloche.identifier(name));
    }

}
