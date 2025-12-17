package com.benbenlaw.cloche.networking;

import com.benbenlaw.cloche.Cloche;
import net.neoforged.neoforge.network.event.RegisterPayloadHandlersEvent;
import net.neoforged.neoforge.network.registration.PayloadRegistrar;

public class ClocheMessages {
    public static void registerNetworking(final RegisterPayloadHandlersEvent event) {
        final PayloadRegistrar registrar = event.registrar(Cloche.MOD_ID);

    }
}
