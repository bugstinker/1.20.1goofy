package net.dragm.goofymod.item;

import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;

public class ModFood {
    public static final FoodProperties STRAWBERRY = new FoodProperties.Builder().nutrition(4).fast()
            .saturationMod(0.2f).build();
    public static final FoodProperties CURSED_EYE = new FoodProperties.Builder().nutrition(10).fast()
            .saturationMod(10f).effect( () -> new MobEffectInstance(MobEffects.REGENERATION, 200), 1f).build();
}
