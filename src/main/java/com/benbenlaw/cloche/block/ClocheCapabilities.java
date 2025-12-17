package com.benbenlaw.cloche.block;

import net.neoforged.neoforge.capabilities.Capabilities;
import net.neoforged.neoforge.capabilities.RegisterCapabilitiesEvent;

public class ClocheCapabilities {

    public static void registerCapabilities(RegisterCapabilitiesEvent event) {

        event.registerBlockEntity(Capabilities.Item.BLOCK, ClocheBlockEntities.CLOCHE_BLOCK_ENTITY.get(),
                (blockEntity, side) -> blockEntity.getItemCapability()
        );

    }

}
