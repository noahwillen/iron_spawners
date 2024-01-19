package net.noah.ironspawners.container;

import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.noah.ironspawners.blockentities.IronSpawnerBlockEntity;
import net.noah.ironspawners.init.Registration;

public class IronSpawnerContainer extends IronSpawnersContainerBase {
    public IronSpawnerContainer(int pContainerId, Level pLevel, BlockPos pPos, Inventory pPlayerInv, Player pPlayer) {
        super(Registration.IRON_SPAWNER_CONTAINER.get(), pContainerId, pLevel, pPos, pPlayerInv, pPlayer);
        this.blockEntity=(IronSpawnerBlockEntity)pLevel.getBlockEntity(pPos);
    }
}
