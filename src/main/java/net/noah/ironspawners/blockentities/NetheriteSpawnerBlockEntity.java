package net.noah.ironspawners.blockentities;

import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.level.block.state.BlockState;
import net.noah.ironspawners.container.GoldSpawnerContainer;
import net.noah.ironspawners.container.NetheriteSpawnerContainer;
import net.noah.ironspawners.init.Registration;
import org.jetbrains.annotations.Nullable;

public class NetheriteSpawnerBlockEntity extends IronSpawnersBlockEntityBase{
    public NetheriteSpawnerBlockEntity(BlockPos pPos, BlockState pBlockState) {
        super(Registration.NETHERITE_SPAWNER_BLOCK_ENTITY.get(), pPos, pBlockState);
    }

    @Override
    public int getMaxDelay() {
        return 80;
    }

    @Override
    public int getSpawnCount() {
        return 5;
    }

    @Override
    public Component getDisplayName() {
        return Component.translatable("block.ironspawners.netherite_spawner");
    }

    @Nullable
    @Override
    public AbstractContainerMenu createMenu(int pContainerId, Inventory pPlayerInventory, Player pPlayer) {
        return new NetheriteSpawnerContainer(pContainerId, level, worldPosition, pPlayerInventory, pPlayer);
    }
}
