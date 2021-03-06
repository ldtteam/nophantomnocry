package com.ldtteam.nophantomnocry;

import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.monster.PhantomEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraftforge.event.AnvilUpdateEvent;
import net.minecraftforge.event.entity.living.LivingSpawnEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import org.jetbrains.annotations.NotNull;

@Mod.EventBusSubscriber
public class ModEvents
{
    /**
     * Cancel all phantom spawns not from a spawn egg.
     */
    @SubscribeEvent(priority = EventPriority.HIGH)
    public static void onSpecialSpawn(LivingSpawnEvent.SpecialSpawn event)
    {
        if (!event.getWorld().isClientSide() && (event.getWorld()).dimensionType().bedWorks() && event.getEntity() instanceof PhantomEntity && !(event.getSpawnReason() == SpawnReason.SPAWN_EGG) && !(event.getSpawnReason() == SpawnReason.COMMAND))
        {
            event.setCanceled(true);
        }
    }

    /**
     * Repair elytra with leather
     */
    @SubscribeEvent
    public static void anvilUpdateEvent(@NotNull final AnvilUpdateEvent event)
    {
        if (event.getLeft().getItem() == Items.ELYTRA && event.getRight().getItem() == Items.LEATHER)
        {
            final ItemStack stack = event.getLeft().copy();
            stack.setDamageValue(0);
            event.setCost(5);
            event.setOutput(stack);
        }
    }
}
