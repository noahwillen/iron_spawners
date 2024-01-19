package net.noah.ironspawners.container;

import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.noah.ironspawners.blockentities.EmeraldSpawnerBlockEntity;
import net.noah.ironspawners.blockentities.GoldSpawnerBlockEntity;
import net.noah.ironspawners.init.Registration;

public class EmeraldSpawnerContainer extends IronSpawnersContainerBase {
    public EmeraldSpawnerContainer(int pContainerId, Level pLevel, BlockPos pPos, Inventory pPlayerInv, Player pPlayer) {
        super(Registration.EMERALD_SPAWNER_CONTAINER.get(), pContainerId, pLevel, pPos, pPlayerInv, pPlayer);
        this.blockEntity=(EmeraldSpawnerBlockEntity)pLevel.getBlockEntity(pPos);
    }
}
