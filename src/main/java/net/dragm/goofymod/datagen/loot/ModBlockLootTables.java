package net.dragm.goofymod.datagen.loot;

import net.dragm.goofymod.block.ModBlocks;
import net.dragm.goofymod.block.custom.CursedEyeCropBlock;
import net.dragm.goofymod.block.custom.StrawberryCropBlock;
import net.dragm.goofymod.item.ModItems;
import net.minecraft.advancements.critereon.StatePropertiesPredicate;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.data.loot.packs.VanillaBlockLoot;
import net.minecraft.world.flag.FeatureFlagSet;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.ApplyBonusCount;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.predicates.LootItemBlockStatePropertyCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.RegistryObject;

import java.util.Set;

public class ModBlockLootTables extends BlockLootSubProvider {
    public ModBlockLootTables() {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags());
    }


    @Override
    protected void generate() {
        this.dropSelf(ModBlocks.PLATINUM_BLOCK.get());
        this.dropSelf(ModBlocks.PLATINUM_BLOCK_CLUMP.get());

//------------------------------------------------------------------------------------------------------------------------------------------//

        this.add(ModBlocks.PLATINUM_ORE.get(),
                block -> createPlatinumDrops(ModBlocks.PLATINUM_ORE.get(), ModItems.PLATINUM_CLUMP.get()));
        this.add(ModBlocks.MUD_BLOCK.get(),
                block -> createPlatinumDrops(ModBlocks.MUD_BLOCK.get(), ModItems.MUD.get()));
        this.add(ModBlocks.DEEPSLATE_PLATINUM_ORE.get(),
                block -> createPlatinumDrops(ModBlocks.DEEPSLATE_PLATINUM_ORE.get(), ModItems.PLATINUM_CLUMP.get()));

//-----------------------------------------------------------------------------------------------------------------------------------------

        this.dropSelf(ModBlocks.PLATINUM_STAIRS.get());
        this.dropSelf(ModBlocks.PLATINUM_BUTTON.get());
        this.dropSelf(ModBlocks.PLATINUM_PRESSURE_PLATE.get());
        this.dropSelf(ModBlocks.PLATINUM_TRAPDOOR.get());
        this.dropSelf(ModBlocks.PLATINUM_FENCE.get());
        this.dropSelf(ModBlocks.PLATINUM_FENCE_GATE.get());
        this.dropSelf(ModBlocks.PLATINUM_WALL.get());
        this.dropSelf(ModBlocks.INCUBATOR.get());

//-----------------------------------------------------------------------------------------------------------

        this.add(ModBlocks.PLATINUM_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.PLATINUM_SLAB.get()));
        this.add(ModBlocks.PLATINUM_DOOR.get(),
                block -> createDoorTable(ModBlocks.PLATINUM_DOOR.get()));

        LootItemCondition.Builder lootitemcondition$builder = LootItemBlockStatePropertyCondition
                .hasBlockStateProperties(ModBlocks.STRAWBERRY_CROP.get())
                .setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(StrawberryCropBlock.AGE, 5));

        this.add(ModBlocks.STRAWBERRY_CROP.get(), createCropDrops(ModBlocks.STRAWBERRY_CROP.get(), ModItems.STRAWBERRY.get(),
                ModItems.STRAWBERRY_SEED.get(), lootitemcondition$builder));

        LootItemCondition.Builder lootitemcondition$builder1 = LootItemBlockStatePropertyCondition
                .hasBlockStateProperties(ModBlocks.CURSED_EYE_CROP.get())
                .setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(CursedEyeCropBlock.AGE, 5));

        this.add(ModBlocks.CURSED_EYE_CROP.get(), createCropDrops(ModBlocks.CURSED_EYE_CROP.get(), ModItems.CURSED_EYE.get(),
                ModItems.CURSED_EYE_SEED.get(), lootitemcondition$builder1));
    }

    protected LootTable.Builder createPlatinumDrops(Block pBlock, Item item) {
        return createSilkTouchDispatchTable(pBlock,
                this.applyExplosionDecay(pBlock,
                        LootItem.lootTableItem(item)
                                .apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0f, 2.0f)))
                                .apply(ApplyBonusCount.addOreBonusCount(Enchantments.BLOCK_FORTUNE))));
    }

    @Override
    protected Iterable<Block> getKnownBlocks() {
        return ModBlocks.BLOCKS.getEntries().stream().map(RegistryObject::get)::iterator;
    }
}
