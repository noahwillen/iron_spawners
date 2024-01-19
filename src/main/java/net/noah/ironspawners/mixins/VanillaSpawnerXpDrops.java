package net.noah.ironspawners.mixins;


import net.minecraft.core.BlockPos;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.SpawnerBlock;
import net.minecraft.world.level.block.state.BlockState;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import org.spongepowered.asm.mixin.injection.callback.LocalCapture;

@Mixin(SpawnerBlock.class)
public class VanillaSpawnerXpDrops {

    @Inject(method = "getExpDrop" ,
            at = @At("HEAD"),
            locals = LocalCapture.CAPTURE_FAILHARD,
            remap = false,
            cancellable = true)
    private void injected(BlockState state, LevelReader world, RandomSource randomSource, BlockPos pos, int fortune, int silktouch, CallbackInfoReturnable<Integer> cir) {
        if (silktouch > 0) {
            cir.setReturnValue(0);
        }
    }
}
