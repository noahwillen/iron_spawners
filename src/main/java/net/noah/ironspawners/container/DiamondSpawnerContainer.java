package net.noah.ironspawners.container;

import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.noah.ironspawners.blockentities.DiamondSpawnerBlockEntity;
import net.noah.ironspawners.blockentities.GoldSpawnerBlockEntity;
import net.noah.ironspawners.init.Registration;

public class DiamondSpawnerContainer extends IronSpawnersContainerBase {
    public DiamondSpawnerContainer(int pContainerId, Level pLevel, BlockPos pPos, Inventory pPlayerInv, Player pPlayer) {
        super(Registration.DIAMOND_SPAWNER_CONTAINER.get(), pContainerId, pLevel, pPos, pPlayerInv, pPlayer);
        this.blockEntity=(DiamondSpawnerBlockEntity)pLevel.getBlockEntity(pPos);
    }
}
