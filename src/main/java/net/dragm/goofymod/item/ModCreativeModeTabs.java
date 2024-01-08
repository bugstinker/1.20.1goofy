package net.dragm.goofymod.item;

import net.dragm.goofymod.GoofyMod;
import net.dragm.goofymod.block.ModBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class ModCreativeModeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, GoofyMod.MOD_ID);

    public static final RegistryObject<CreativeModeTab> GOOFY_TAB = CREATIVE_MODE_TABS.register("goofy_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.PLATINUM.get()))
                    .title(Component.translatable("creativetab.goofy_tab"))
                    .displayItems((pParameters, pOutput) -> {
                        //items
                        pOutput.accept(ModItems.PLATINUM.get());
                        pOutput.accept(ModItems.PLATINUM_CLUMP.get());
                        pOutput.accept(ModItems.STRAWBERRY.get());
                        pOutput.accept(ModItems.CURSED_EYE.get());
                        pOutput.accept(ModItems.PINE_CONE.get());
                        pOutput.accept(ModItems.PLATINUM_TANK.get());
                        pOutput.accept(ModItems.PLATINUM_HELMET.get());
                        pOutput.accept(ModItems.PLATINUM_CHESTPLATE.get());
                        pOutput.accept(ModItems.PLATINUM_LEGGINGS.get());
                        pOutput.accept(ModItems.PLATINUM_BOOTS.get());
                        pOutput.accept(ModItems.MUD.get());
                        pOutput.accept(ModItems.STRAWBERRY_SEED.get());
                        pOutput.accept(ModItems.MAMMOTH_SPAWN_EGG.get());
                        pOutput.accept(ModItems.CURSED_EYE_SEED.get());

                        //tools
                        pOutput.accept(ModItems.PLATINUM_SWORD.get());
                        pOutput.accept(ModItems.PLATINUM_PICKAXE.get());
                        pOutput.accept(ModItems.PLATINUM_AXE.get());
                        pOutput.accept(ModItems.PLATINUM_SHOVEL.get());
                        pOutput.accept(ModItems.PLATINUM_HOE.get());

                        //blocks
                        pOutput.accept(ModBlocks.PLATINUM_BLOCK.get());
                        pOutput.accept(ModBlocks.MUD_BLOCK.get());
                        pOutput.accept(ModBlocks.PLATINUM_BLOCK_CLUMP.get());
                        pOutput.accept(ModBlocks.PLATINUM_ORE.get());
                        pOutput.accept(ModBlocks.PLATINUM_STAIRS.get());
                        pOutput.accept(ModBlocks.PLATINUM_SLAB.get());
                        pOutput.accept(ModBlocks.PLATINUM_FENCE.get());
                        pOutput.accept(ModBlocks.PLATINUM_FENCE_GATE.get());
                        pOutput.accept(ModBlocks.PLATINUM_WALL.get());
                        pOutput.accept(ModBlocks.PLATINUM_PRESSURE_PLATE.get());
                        pOutput.accept(ModBlocks.PLATINUM_TRAPDOOR.get());
                        pOutput.accept(ModBlocks.PLATINUM_DOOR.get());
                        pOutput.accept(ModBlocks.PLATINUM_BUTTON.get());

                        //Bock Entities
                        pOutput.accept(ModBlocks.INCUBATOR.get());



                    })
                    .build());

    public static void register(IEventBus eventBus)
    {
        CREATIVE_MODE_TABS.register(eventBus);
    }

}
