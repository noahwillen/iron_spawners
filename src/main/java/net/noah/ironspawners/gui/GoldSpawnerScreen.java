package net.noah.ironspawners.gui;

import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.player.Inventory;
import net.noah.ironspawners.container.GoldSpawnerContainer;
import net.noah.ironspawners.container.IronSpawnerContainer;

public class GoldSpawnerScreen extends IronSpawnersScreenBase<GoldSpawnerContainer> {
    public GoldSpawnerScreen(GoldSpawnerContainer pMenu, Inventory pPlayerInventory, Component pTitle) {
        super(pMenu, pPlayerInventory, pTitle);
    }
}
