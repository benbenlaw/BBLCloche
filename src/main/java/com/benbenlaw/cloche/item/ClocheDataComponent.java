package com.benbenlaw.cloche.item;

import com.benbenlaw.cloche.Cloche;
import com.benbenlaw.cloche.item.util.CropData;
import net.minecraft.core.component.DataComponentType;
import net.minecraft.core.registries.BuiltInRegistries;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ClocheDataComponent {

    public static final DeferredRegister<DataComponentType<?>> COMPONENTS = DeferredRegister.create(BuiltInRegistries.DATA_COMPONENT_TYPE, Cloche.MOD_ID);

    public static final DeferredHolder<DataComponentType<?>, DataComponentType<CropData>> CROP_DATA =
            COMPONENTS.register("crop_data", () ->
                    DataComponentType.<CropData>builder()
                            .persistent(CropData.CODEC)
                            .networkSynchronized(CropData.STREAM_CODEC)
                            .cacheEncoding()
                            .build());

}
