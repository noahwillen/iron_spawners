package net.noah.ironspawners.container;

import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.noah.ironspawners.blockentities.GoldSpawnerBlockEntity;
import net.noah.ironspawners.blockentities.NetheriteSpawnerBlockEntity;
import net.noah.ironspawners.init.Registration;

public class NetheriteSpawnerContainer extends IronSpawnersContainerBase {
    public NetheriteSpawnerContainer(int pContainerId, Level pLevel, BlockPos pPos, Inventory pPlayerInv, Player pPlayer) {
        super(Registration.NETHERITE_SPAWNER_CONTAINER.get(), pContainerId, pLevel, pPos, pPlayerInv, pPlayer);
        this.blockEntity=(NetheriteSpawnerBlockEntity)pLevel.getBlockEntity(pPos);
    }
}
