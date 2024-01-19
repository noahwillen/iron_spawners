package net.noah.ironspawners.gui;

import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.player.Inventory;
import net.noah.ironspawners.container.EmeraldSpawnerContainer;
import net.noah.ironspawners.container.GoldSpawnerContainer;

public class EmeraldSpawnerScreen extends IronSpawnersScreenBase<EmeraldSpawnerContainer> {
    public EmeraldSpawnerScreen(EmeraldSpawnerContainer pMenu, Inventory pPlayerInventory, Component pTitle) {
        super(pMenu, pPlayerInventory, pTitle);
    }
}
