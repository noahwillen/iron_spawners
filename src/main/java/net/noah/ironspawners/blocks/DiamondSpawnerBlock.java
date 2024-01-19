package net.noah.ironspawners.blocks;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.noah.ironspawners.blockentities.DiamondSpawnerBlockEntity;
import net.noah.ironspawners.blockentities.GoldSpawnerBlockEntity;
import net.noah.ironspawners.init.Registration;
import org.jetbrains.annotations.Nullable;

public class DiamondSpawnerBlock extends IronSpawnersBlockBase{

    public static final String DIAMOND_SPAWNER = "diamond_spawner";

    public DiamondSpawnerBlock(Properties pProperties) {
        super(pProperties);
    }

    @Nullable
    @Override
    public BlockEntity newBlockEntity(BlockPos pPos, BlockState pState) {
        return new DiamondSpawnerBlockEntity(pPos, pState);
    }

    @Nullable
    @Override
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(Level pLevel, BlockState pState, BlockEntityType<T> pBlockEntityType) {
        return createSpawnerTicker(pLevel, pBlockEntityType, Registration.DIAMOND_SPAWNER_BLOCK_ENTITY.get());
    }
}
