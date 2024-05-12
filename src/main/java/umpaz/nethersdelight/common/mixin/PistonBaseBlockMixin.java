package umpaz.nethersdelight.common.mixin;

import com.llamalad7.mixinextras.sugar.Local;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.piston.PistonBaseBlock;
import net.minecraft.world.level.block.piston.PistonStructureResolver;
import net.minecraft.world.level.block.state.BlockState;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import umpaz.nethersdelight.common.block.PropelplantCaneBlock;

@Mixin(PistonBaseBlock.class)
public class PistonBaseBlockMixin {

    //TODO: PR PistonEvent to Porting Lib?
    @Inject(method = "triggerEvent", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/level/block/piston/PistonBaseBlock;moveBlocks(Lnet/minecraft/world/level/Level;Lnet/minecraft/core/BlockPos;Lnet/minecraft/core/Direction;Z)Z", ordinal = 0))
    private void explodePropelPlant(BlockState state, Level level, BlockPos pos, int id, int param, CallbackInfoReturnable<Boolean> cir, @Local(ordinal = 0) Direction direction) {
        PistonStructureResolver resolver = new PistonStructureResolver(level, pos, direction, true);
        resolver.resolve();
        resolver.getToDestroy().forEach(nextPos -> {
            BlockState posState = level.getBlockState(nextPos);
            if (!(posState.getBlock() instanceof PropelplantCaneBlock propelplantCaneBlock))
                return;
            propelplantCaneBlock.explode(posState, level, nextPos);
        });
    }

}
