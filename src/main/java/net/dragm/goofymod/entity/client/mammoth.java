package net.dragm.goofymod.entity.client;// Made with Blockbench 4.8.3
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports


import net.dragm.goofymod.GoofyMod;
import net.dragm.goofymod.entity.custom.MammothEntity;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import software.bernie.geckolib.constant.DataTickets;
import software.bernie.geckolib.core.animatable.model.CoreGeoBone;
import software.bernie.geckolib.core.animation.AnimationState;
import software.bernie.geckolib.model.GeoModel;
import software.bernie.geckolib.model.data.EntityModelData;

public class mammoth extends GeoModel<MammothEntity> {
	@Override
	public ResourceLocation getModelResource(MammothEntity animatable) {
		return new ResourceLocation(GoofyMod.MOD_ID, "geo/mammoth.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(MammothEntity animatable) {
		return new ResourceLocation(GoofyMod.MOD_ID, "textures/entity/mammoth.png");
	}

	@Override
	public ResourceLocation getAnimationResource(MammothEntity animatable) {
		return new ResourceLocation(GoofyMod.MOD_ID, "animations/mammoth.animation.json");
	}

	@Override
	public void setCustomAnimations(MammothEntity animatable, long instanceId, AnimationState<MammothEntity> animationState) {
		CoreGeoBone head = getAnimationProcessor().getBone("Head");

		if (head != null) {
			EntityModelData entityData = animationState.getData(DataTickets.ENTITY_MODEL_DATA);

			head.setRotX(entityData.headPitch() * Mth.DEG_TO_RAD);
			head.setRotY(entityData.netHeadYaw() * Mth.DEG_TO_RAD);
		}
	}
}