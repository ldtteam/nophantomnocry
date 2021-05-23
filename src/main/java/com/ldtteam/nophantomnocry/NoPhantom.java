package com.ldtteam.nophantomnocry;

import net.minecraftforge.fml.common.Mod;

@Mod("nophantomnocry")
public class NoPhantom
{
    /**
     * Constructor to initiate this.
     */
    public NoPhantom()
    {
        Mod.EventBusSubscriber.Bus.FORGE.bus().get().register(ModEvents.class);
    }
}