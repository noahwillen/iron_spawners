package net.noah.ironspawners.gui;

import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Inventory;
import net.noah.ironspawners.IronSpawners;
import net.noah.ironspawners.container.IronSpawnersContainerBase;
import org.jetbrains.annotations.NotNull;

public abstract class IronSpawnersScreenBase<T extends IronSpawnersContainerBase> extends AbstractContainerScreen<T> {
    ResourceLocation TEXTURE = new ResourceLocation(IronSpawners.MOD_ID, "textures/gui/spawner.png");

    public IronSpawnersScreenBase(T pMenu, Inventory pPlayerInventory, Component pTitle) {
        super(pMenu, pPlayerInventory, pTitle);

        this.imageWidth=176;
        this.imageHeight=133;
        this.inventoryLabelY=39;
    }

    @Override
    protected void renderBg(GuiGraphics pGuiGraphics, float pPartialTick, int pMouseX, int pMouseY) {
        renderBackground(pGuiGraphics);
        pGuiGraphics.blit(TEXTURE, this.leftPos, this.topPos, 0, 0, this.imageWidth, this.imageHeight);
    }

    @Override
    public void render(@NotNull GuiGraphics pGuiGraphics, int pMouseX, int pMouseY, float pPartialTick) {
        super.render(pGuiGraphics, pMouseX, pMouseY, pPartialTick);
        renderTooltip(pGuiGraphics, pMouseX, pMouseY);
    }
}
