package net.noah.ironspawners.blocks;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.noah.ironspawners.blockentities.IronSpawnerBlockEntity;
import net.noah.ironspawners.init.Registration;
import org.jetbrains.annotations.Nullable;

public class IronSpawnerBlock extends IronSpawnersBlockBase{

    public static final String IRON_SPAWNER = "iron_spawner";

    public IronSpawnerBlock(Properties pProperties) {
        super(pProperties);
    }

    @Nullable
    @Override
    public BlockEntity newBlockEntity(BlockPos pPos, BlockState pState) {
        return new IronSpawnerBlockEntity(pPos, pState);
    }

    @Nullable
    @Override
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(Level pLevel, BlockState pState, BlockEntityType<T> pBlockEntityType) {
        return createSpawnerTicker(pLevel, pBlockEntityType, Registration.IRON_SPAWNER_BLOCK_ENTITY.get());
    }
}
