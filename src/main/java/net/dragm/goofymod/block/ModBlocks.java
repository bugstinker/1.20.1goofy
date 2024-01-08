package net.dragm.goofymod.block;

import net.dragm.goofymod.GoofyMod;
import net.dragm.goofymod.block.custom.IncubatorBlock;
import net.dragm.goofymod.block.custom.CursedEyeCropBlock;
import net.dragm.goofymod.block.custom.StrawberryCropBlock;
import net.dragm.goofymod.item.ModItems;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.material.PushReaction;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class ModBlocks  {

    //BLOCKS
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, GoofyMod.MOD_ID);
    public static final RegistryObject<Block> PLATINUM_BLOCK = registerBlock("platinum_block",
        () -> new Block(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK)));
    public static final RegistryObject<Block> MUD_BLOCK = registerBlock("mud_block",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.DIRT)));
    public static final RegistryObject<Block> PLATINUM_BLOCK_CLUMP = registerBlock("platinum_block_clump",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK)));

    public static final RegistryObject<Block> PLATINUM_ORE = registerBlock("platinum_ore",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.copy(Blocks.IRON_ORE)
                    .strength(4f).requiresCorrectToolForDrops(), UniformInt.of(3, 6)));
    public static final RegistryObject<Block> DEEPSLATE_PLATINUM_ORE = registerBlock("deepslate_platinum_ore",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.copy(Blocks.DEEPSLATE_IRON_ORE)
                    .strength(4.5f).requiresCorrectToolForDrops(), UniformInt.of(3, 6)));


    //BLOCK ENTITIES
    public static final RegistryObject<Block> INCUBATOR = registerBlock("incubator",
            () -> new IncubatorBlock(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).noOcclusion()));

//------------------------------------------------------------------BUILDINGBLOCKS
public static final RegistryObject<Block> PLATINUM_STAIRS = registerBlock("platinum_stairs",
        () -> new StairBlock(() -> ModBlocks.PLATINUM_BLOCK.get().defaultBlockState(),
                BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK)));
    public static final RegistryObject<Block> PLATINUM_SLAB = registerBlock("platinum_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK)));
    //----------------------------------------------
    public static final RegistryObject<Block> PLATINUM_BUTTON = registerBlock("platinum_button",
            () -> new ButtonBlock(BlockBehaviour.Properties.copy(Blocks.STONE_BUTTON),
                    BlockSetType.IRON, 10, true));
    public static final RegistryObject<Block> PLATINUM_PRESSURE_PLATE = registerBlock("platinum_pressure_plate",
            () -> new PressurePlateBlock(PressurePlateBlock.Sensitivity.EVERYTHING, BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK),
            BlockSetType.IRON));
//----------------------------------------------------
    public static final RegistryObject<Block> PLATINUM_FENCE = registerBlock("platinum_fence",
            () -> new FenceBlock(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK)));
    public static final RegistryObject<Block> PLATINUM_FENCE_GATE = registerBlock("platinum_fence_gate",
            () -> new FenceGateBlock(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK), SoundEvents.IRON_TRAPDOOR_OPEN, SoundEvents.IRON_TRAPDOOR_CLOSE));
    public static final RegistryObject<Block> PLATINUM_WALL = registerBlock("platinum_wall",
            () -> new WallBlock(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK)));
//----------------------------------------------------
    public static final RegistryObject<Block> PLATINUM_DOOR = registerBlock("platinum_door",
            () -> new DoorBlock(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).noOcclusion(),
                    BlockSetType.IRON));
    public static final RegistryObject<Block> PLATINUM_TRAPDOOR = registerBlock("platinum_trapdoor",
            () -> new TrapDoorBlock(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).noOcclusion(),
                    BlockSetType.IRON));

    //CROPS
    public static final RegistryObject<Block> STRAWBERRY_CROP = BLOCKS.register("strawberry_crop",
            () -> new StrawberryCropBlock(BlockBehaviour.Properties.copy(Blocks.WHEAT).noOcclusion().noCollission()));
    public static final RegistryObject<Block> CURSED_EYE_CROP = BLOCKS.register("cursed_eye_crop",
            () -> new CursedEyeCropBlock(BlockBehaviour.Properties.of().mapColor(MapColor.PLANT).noCollission().randomTicks().instabreak().sound(SoundType.CROP).pushReaction(PushReaction.DESTROY)));


    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }
    private static <T extends Block>RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block)
    {
        return ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }

    public static void register(IEventBus eventBus)
    {
        BLOCKS.register(eventBus);
    }
}
