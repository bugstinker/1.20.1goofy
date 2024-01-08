package net.dragm.goofymod.block.entity;

import net.dragm.goofymod.GoofyMod;
import net.dragm.goofymod.block.ModBlocks;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModBlockEntities {
    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES =
            DeferredRegister.create(ForgeRegistries.BLOCK_ENTITY_TYPES, GoofyMod.MOD_ID);

    public static final RegistryObject<BlockEntityType<IncubatorBlockEntity>> INCUBATOR_BLOCK_ENTITY =
            BLOCK_ENTITIES.register("incubator_block_entity", () ->
                    BlockEntityType.Builder.of(IncubatorBlockEntity::new,
                            ModBlocks.INCUBATOR.get()).build(null));
    
    public static void register(IEventBus eventBus) {
        BLOCK_ENTITIES.register(eventBus);
    }
}
