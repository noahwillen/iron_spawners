package net.noah.ironspawners.gui;

import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.player.Inventory;
import net.noah.ironspawners.container.IronSpawnerContainer;

public class IronSpawnerScreen extends IronSpawnersScreenBase<IronSpawnerContainer> {
    public IronSpawnerScreen(IronSpawnerContainer pMenu, Inventory pPlayerInventory, Component pTitle) {
        super(pMenu, pPlayerInventory, pTitle);
    }
}
