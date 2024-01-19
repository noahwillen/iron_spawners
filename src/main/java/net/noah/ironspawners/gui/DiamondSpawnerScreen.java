package net.noah.ironspawners.gui;

import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.player.Inventory;
import net.noah.ironspawners.container.DiamondSpawnerContainer;
import net.noah.ironspawners.container.GoldSpawnerContainer;

public class DiamondSpawnerScreen extends IronSpawnersScreenBase<DiamondSpawnerContainer> {
    public DiamondSpawnerScreen(DiamondSpawnerContainer pMenu, Inventory pPlayerInventory, Component pTitle) {
        super(pMenu, pPlayerInventory, pTitle);
    }
}
