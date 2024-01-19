package net.noah.ironspawners.gui;

import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.player.Inventory;
import net.noah.ironspawners.container.GoldSpawnerContainer;
import net.noah.ironspawners.container.NetheriteSpawnerContainer;

public class NetheriteSpawnerScreen extends IronSpawnersScreenBase<NetheriteSpawnerContainer> {
    public NetheriteSpawnerScreen(NetheriteSpawnerContainer pMenu, Inventory pPlayerInventory, Component pTitle) {
        super(pMenu, pPlayerInventory, pTitle);
    }
}
