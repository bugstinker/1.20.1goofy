package net.dragm.goofymod.entity.client;

import com.mojang.blaze3d.vertex.PoseStack;
import net.dragm.goofymod.GoofyMod;
import net.dragm.goofymod.entity.custom.MammothEntity;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.renderer.GeoEntityRenderer;

public class MammothRenderer extends GeoEntityRenderer<MammothEntity> {
    public MammothRenderer(EntityRendererProvider.Context renderManager) {
        super(renderManager, new mammoth());
    }

    @Override
    public ResourceLocation getTextureLocation(MammothEntity animatable) {
        return new ResourceLocation(GoofyMod.MOD_ID, "textures/entity/mammoth.png");
    }

    @Override
    public void render(MammothEntity entity, float entityYaw, float partialTick, PoseStack poseStack, MultiBufferSource bufferSource, int packedLight) {

        if(entity.isBaby()) {
            poseStack.scale(0.4f,0.4f,0.4f);
        }
        super.render(entity, entityYaw, partialTick, poseStack, bufferSource, packedLight);
    }
}
