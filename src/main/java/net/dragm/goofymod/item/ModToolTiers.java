package net.dragm.goofymod.item;

import net.dragm.goofymod.GoofyMod;
import net.dragm.goofymod.util.ModTags;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.Tiers;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.common.ForgeTier;
import net.minecraftforge.common.TierSortingRegistry;

import java.util.List;

public class ModToolTiers {
    public static final Tier PLATINUM = TierSortingRegistry.registerTier(
            new ForgeTier(5, 2750, 10f, 4f, 25,
                    ModTags.Blocks.NEEDS_PLATINUM_TOOL, () -> Ingredient.of(ModItems.PLATINUM.get())),
            new ResourceLocation(GoofyMod.MOD_ID, "platinum"), List.of(Tiers.NETHERITE), List.of());

}
