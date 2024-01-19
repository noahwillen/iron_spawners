package net.noah.ironspawners.blockentities;

import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.level.block.state.BlockState;
import net.noah.ironspawners.container.IronSpawnerContainer;
import net.noah.ironspawners.init.Registration;
import org.jetbrains.annotations.Nullable;

public class IronSpawnerBlockEntity extends IronSpawnersBlockEntityBase{
    public IronSpawnerBlockEntity(BlockPos pPos, BlockState pBlockState) {
        super(Registration.IRON_SPAWNER_BLOCK_ENTITY.get(), pPos, pBlockState);
    }

    @Override
    public int getMaxDelay() {
        return 600;
    }

    @Override
    public int getSpawnCount() {
        return 3;
    }

    @Override
    public Component getDisplayName() {
        return Component.translatable("block.ironspawners.iron_spawner");
    }

    @Nullable
    @Override
    public AbstractContainerMenu createMenu(int pContainerId, Inventory pPlayerInventory, Player pPlayer) {
        return new IronSpawnerContainer(pContainerId, level, worldPosition, pPlayerInventory, pPlayer);
    }
}
