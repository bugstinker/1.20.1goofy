package net.dragm.goofymod.datagen;

import net.dragm.goofymod.GoofyMod;
import net.dragm.goofymod.block.ModBlocks;
import net.dragm.goofymod.block.custom.CursedEyeCropBlock;
import net.dragm.goofymod.block.custom.StrawberryCropBlock;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.client.model.generators.ConfiguredModel;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Function;

public class ModBlockStateProvider extends BlockStateProvider {
    public ModBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, GoofyMod.MOD_ID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        blockWithItem(ModBlocks.PLATINUM_BLOCK);
        blockWithItem(ModBlocks.MUD_BLOCK);
        blockWithItem(ModBlocks.PLATINUM_BLOCK_CLUMP);

        blockWithItem(ModBlocks.PLATINUM_ORE);
        blockWithItem(ModBlocks.DEEPSLATE_PLATINUM_ORE);

        stairsBlock(((StairBlock) ModBlocks.PLATINUM_STAIRS.get()), blockTexture(ModBlocks.PLATINUM_BLOCK.get()));
        slabBlock(((SlabBlock) ModBlocks.PLATINUM_SLAB.get()), blockTexture(ModBlocks.PLATINUM_BLOCK.get()), blockTexture(ModBlocks.PLATINUM_BLOCK.get()));

        buttonBlock(((ButtonBlock) ModBlocks.PLATINUM_BUTTON.get()), blockTexture(ModBlocks.PLATINUM_BLOCK.get()));
        pressurePlateBlock(((PressurePlateBlock) ModBlocks.PLATINUM_PRESSURE_PLATE.get()), blockTexture(ModBlocks.PLATINUM_BLOCK.get()));

        fenceBlock(((FenceBlock) ModBlocks.PLATINUM_FENCE.get()), blockTexture(ModBlocks.PLATINUM_BLOCK.get()));
        fenceGateBlock(((FenceGateBlock) ModBlocks.PLATINUM_FENCE_GATE.get()), blockTexture(ModBlocks.PLATINUM_BLOCK.get()));
        wallBlock(((WallBlock) ModBlocks.PLATINUM_WALL.get()), blockTexture(ModBlocks.PLATINUM_BLOCK.get()));

        doorBlockWithRenderType(((DoorBlock) ModBlocks.PLATINUM_DOOR.get()), modLoc("block/platinum_door_bottom"),
                modLoc("block/platinum_door_top"),
                "cutout");
        trapdoorBlockWithRenderType(((TrapDoorBlock) ModBlocks.PLATINUM_TRAPDOOR.get()), modLoc("block/platinum_trapdoor"),
                true,
                "cutout");


        makeStrawberryCrop((CropBlock)ModBlocks.STRAWBERRY_CROP.get(), "strawberry_stage", "strawberry_stage");
        makeCursedEyeCrop((CropBlock)ModBlocks.CURSED_EYE_CROP.get(), "cursed_eye_stage", "cursed_eye_stage");

        simpleBlockWithItem(ModBlocks.INCUBATOR.get(), new ModelFile.UncheckedModelFile(modLoc("block/incubator")));
    }

    public void makeStrawberryCrop(CropBlock block, String modelName, String textureName) {
        Function<BlockState, ConfiguredModel[]> function = state -> strawberryStates(state, block, modelName, textureName);

        getVariantBuilder(block).forAllStates(function);
    }


    private ConfiguredModel[] strawberryStates(BlockState state, CropBlock block, String modelName, String textureName) {
        ConfiguredModel[] models = new ConfiguredModel[1];
        models[0] = new ConfiguredModel(models().crop(modelName + state.getValue(((StrawberryCropBlock) block).getAgeProperty()),
                new ResourceLocation(GoofyMod.MOD_ID, "block/" + textureName + state.getValue(((StrawberryCropBlock) block).getAgeProperty()))).renderType("cutout"));

        return models;
    }

    public void makeCursedEyeCrop(CropBlock block, String modelName, String textureName) {
        Function<BlockState, ConfiguredModel[]> function = state -> cursedEyeStates(state, block, modelName, textureName);

        getVariantBuilder(block).forAllStates(function);
    }


    private ConfiguredModel[] cursedEyeStates(BlockState state, CropBlock block, String modelName, String textureName) {
        ConfiguredModel[] models = new ConfiguredModel[1];
        models[0] = new ConfiguredModel(models().cross(modelName + state.getValue(((CursedEyeCropBlock) block).getAgeProperty()),
                new ResourceLocation(GoofyMod.MOD_ID, "block/" + textureName + state.getValue(((CursedEyeCropBlock) block).getAgeProperty()))).renderType("cutout"));

        return models;
    }

    private void blockWithItem(RegistryObject<Block> blockRegistryObject) {
        simpleBlockWithItem(blockRegistryObject.get(), cubeAll(blockRegistryObject.get()));
    }
}
