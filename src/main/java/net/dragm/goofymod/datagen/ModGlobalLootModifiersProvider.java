package net.dragm.goofymod.datagen;

import net.dragm.goofymod.GoofyMod;
import net.dragm.goofymod.item.ModItems;
import net.dragm.goofymod.loot.AddItemModifier;
import net.minecraft.data.PackOutput;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.storage.loot.predicates.LootItemBlockStatePropertyCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemRandomChanceCondition;
import net.minecraftforge.common.data.GlobalLootModifierProvider;

public class ModGlobalLootModifiersProvider extends GlobalLootModifierProvider {
    public ModGlobalLootModifiersProvider(PackOutput output ) {
        super(output, GoofyMod.MOD_ID);
    }

    @Override
    protected void start() {
        add("pine_cone_from_leaf", new AddItemModifier(new LootItemCondition[]{
                LootItemBlockStatePropertyCondition.hasBlockStateProperties(Blocks.SPRUCE_LEAVES).build(),
                LootItemRandomChanceCondition.randomChance(0.90f).build()}, ModItems.PINE_CONE.get()));
    }
}
