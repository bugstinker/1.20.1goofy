package net.dragm.goofymod.datagen;

import net.dragm.goofymod.GoofyMod;
import net.dragm.goofymod.block.ModBlocks;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.minecraftforge.common.data.BlockTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagGenerator extends BlockTagsProvider {
    public ModBlockTagGenerator(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, GoofyMod.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider pProvider) {

        this.tag(BlockTags.MINEABLE_WITH_PICKAXE)
                .add(ModBlocks.PLATINUM_BLOCK_CLUMP.get(),
                ModBlocks.DEEPSLATE_PLATINUM_ORE.get(),
                ModBlocks.PLATINUM_BLOCK.get(),
                ModBlocks.PLATINUM_ORE.get());

        //-----------------------------------------------------

        this.tag(BlockTags.NEEDS_IRON_TOOL)
                .add(ModBlocks.PLATINUM_BLOCK.get());

        this.tag(BlockTags.NEEDS_IRON_TOOL)
                .add(ModBlocks.PLATINUM_BLOCK_CLUMP.get());

        this.tag(BlockTags.FENCES)
                .add(ModBlocks.PLATINUM_FENCE.get());
        this.tag(BlockTags.FENCE_GATES)
                .add(ModBlocks.PLATINUM_FENCE_GATE.get());
        this.tag(BlockTags.WALLS)
                .add(ModBlocks.PLATINUM_WALL.get());
    }
}
