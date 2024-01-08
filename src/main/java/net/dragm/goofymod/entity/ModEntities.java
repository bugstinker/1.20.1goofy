package net.dragm.goofymod.entity;

import net.dragm.goofymod.GoofyMod;
import net.dragm.goofymod.entity.custom.MammothEntity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModEntities {
    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES =
            DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, GoofyMod.MOD_ID);

    public static final RegistryObject<EntityType<MammothEntity>> MAMMOTH =
            ENTITY_TYPES.register("mammoth", () -> EntityType.Builder.of(MammothEntity::new, MobCategory.CREATURE)
                    .sized(2.5f, 3f).build("mammoth"));

    public static void register(IEventBus eventBus) {
        ENTITY_TYPES.register(eventBus);
    }
}
