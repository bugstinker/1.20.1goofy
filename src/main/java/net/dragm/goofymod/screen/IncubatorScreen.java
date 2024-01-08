package net.dragm.goofymod.screen;

import com.mojang.blaze3d.systems.RenderSystem;
import net.dragm.goofymod.GoofyMod;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Inventory;

public class IncubatorScreen extends AbstractContainerScreen<IncubatorMenu> {
    private static final ResourceLocation TEXTURE =
            new ResourceLocation(GoofyMod.MOD_ID, "textures/gui/incubator_gui.png");
    public IncubatorScreen(IncubatorMenu pMenu, Inventory pPlayerInventory, Component pTitle) {
        super(pMenu, pPlayerInventory, pTitle);
    }

    @Override
    protected void init() {
        super.init();
        this.inventoryLabelY = 10000;
       // this.titleLabelY = 0;
    }


    @Override
    protected void renderBg(GuiGraphics guiGraphics, float pPartialTick, int pMouseX, int pMouseY) {
        RenderSystem.setShader(GameRenderer::getPositionTexShader);
        RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
        RenderSystem.setShaderTexture(0, TEXTURE);
        int x = (width - imageWidth) / 2;
        int y = (height - imageHeight) / 2;

        guiGraphics.blit(TEXTURE, x, y, 0, 0, imageWidth, imageHeight);

        renderProgressArrow(guiGraphics, x, y);
    }

    private void renderProgressArrow(GuiGraphics guiGraphics, int x, int y) {
        if(menu.isCrafting()) {
            guiGraphics.blit(TEXTURE, x + 81, y + 38, 176, 0, 14, menu.getScaledProgress());
            guiGraphics.blit(TEXTURE, x + 45, y + 38, 176, 0, 14, menu.getScaledProgress());
            guiGraphics.blit(TEXTURE, x + 9, y + 38, 176, 0, 14, menu.getScaledProgress());
            guiGraphics.blit(TEXTURE, x + 117, y + 38, 176, 0, 14, menu.getScaledProgress());
            guiGraphics.blit(TEXTURE, x + 153, y + 38, 176, 0, 14, menu.getScaledProgress());
        }
    }

    @Override
    public void render(GuiGraphics guiGraphics, int mouseX, int mouseY, float delta) {
        renderBackground(guiGraphics);
        super.render(guiGraphics, mouseX, mouseY, delta);
        renderTooltip(guiGraphics, mouseX, mouseY);
    }
}
