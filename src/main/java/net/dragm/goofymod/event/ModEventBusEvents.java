package net.dragm.goofymod.event;

import net.dragm.goofymod.GoofyMod;
import net.dragm.goofymod.entity.ModEntities;
import net.dragm.goofymod.entity.custom.MammothEntity;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = GoofyMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)

public class ModEventBusEvents {

    @SubscribeEvent
    public static void RegisterAttributes(EntityAttributeCreationEvent event) {
        event.put(ModEntities.MAMMOTH.get(), MammothEntity.createAttributes().build());
    }
}
