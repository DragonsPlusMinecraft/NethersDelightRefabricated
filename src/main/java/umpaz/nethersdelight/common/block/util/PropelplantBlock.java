package umpaz.nethersdelight.common.block.util;


import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.*;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.pathfinder.BlockPathTypes;
import net.minecraft.world.level.pathfinder.PathComputationType;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.minecraftforge.common.IPlantable;
import umpaz.nethersdelight.common.registry.NDItems;
import vectorwing.farmersdelight.common.tag.ModTags;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

public class PropelplantBlock extends BushBlock implements IPlantable, BonemealableBlock {
    public static final BooleanProperty PEARL = BooleanProperty.create("pearl");
    private static final VoxelShape SHAPE = Block.box(2.0D, 0.0D, 2.0D, 14.0D, 16.0D, 14.0D);
    public static final float EXPLOSION_LEVEL = 1.0F;

    public PropelplantBlock(Properties properties) {
        super(properties);
    }

    @Override
    public ItemStack getCloneItemStack(BlockGetter level, BlockPos pos, BlockState state) {
        return new ItemStack(NDItems.PROPELPLANT_CANE.get());
    }

    @Override
    public VoxelShape getShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
        return SHAPE;
    }

    @Override
    public boolean isRandomlyTicking(BlockState state) {
        return true;
    }

    @Override
    public boolean isPathfindable(@Nonnull BlockState state, @Nonnull BlockGetter world, @Nonnull BlockPos pos, @Nonnull PathComputationType path) {
        return false;
    }

    @Override
    public BlockPathTypes getBlockPathType(BlockState state, BlockGetter level, BlockPos pos, @Nullable Mob mob)
    {
        return BlockPathTypes.DAMAGE_OTHER;
    }

    @Override
    public BlockPathTypes getAdjacentBlockPathType(BlockState state, BlockGetter level, BlockPos pos, @Nullable Mob mob, BlockPathTypes originalType)
    {
        return BlockPathTypes.DANGER_OTHER;
    }

    @Override
    public void playerDestroy(Level level, Player player, BlockPos pos, BlockState state, @Nullable BlockEntity blockEntity, ItemStack stack) {
        if (stack.is(ModTags.KNIVES)) {
            dropResources(state, level, pos, blockEntity, player, stack);
        }
        else {
            level.explode(null, pos.getX() + 0.5D, pos.getY() + 0.5D, pos.getZ() + 0.5D, EXPLOSION_LEVEL, false, Level.ExplosionInteraction.NONE);
        }
    }

    @Override
    public void entityInside(BlockState state, Level level, BlockPos pos, Entity entity) {
        if (entity instanceof LivingEntity) {
            entity.makeStuckInBlock(state, new Vec3(0.8D, 0.75D, 0.8D));
            if (!level.isClientSide && !(entity.isCrouching())) {
                level.explode(null, pos.getX() + 0.5D, pos.getY() + 0.5D, pos.getZ() + 0.5D, EXPLOSION_LEVEL, false, Level.ExplosionInteraction.NONE);
                level.removeBlock(pos, false);
            }
        }
        if (entity instanceof Projectile) {
            if (!level.isClientSide) {
                level.explode(null, pos.getX() + 0.5D, pos.getY() + 0.5D, pos.getZ() + 0.5D, EXPLOSION_LEVEL, false, Level.ExplosionInteraction.NONE);
                level.removeBlock(pos, false);
            }
        }
    }

    @Override
    public void onBlockExploded(BlockState state, Level level, BlockPos pos, Explosion explosion)
    {
        level.explode((Entity)null, pos.getX() + 0.5D, pos.getY() + 0.5D, pos.getZ() + 0.5D, EXPLOSION_LEVEL, false, Level.ExplosionInteraction.NONE);
        level.removeBlock(pos, false);
        this.wasExploded(level, pos, explosion);
    }
    @Override
    public boolean canSurvive(BlockState state, LevelReader level, BlockPos pos) {
        BlockPos blockpos = pos.below();
        return this.mayPlaceOn(level.getBlockState(blockpos), level, blockpos);
    }

    @Override
    public boolean isValidBonemealTarget(LevelReader p_256559_, BlockPos p_50898_, BlockState p_50899_, boolean p_50900_) {
        return false;
    }

    @Override
    public boolean isBonemealSuccess(Level level, RandomSource random, BlockPos pos, BlockState state) {
        return false;
    }

    @Override
    public void performBonemeal(ServerLevel level, RandomSource random, BlockPos pos, BlockState state) {

    }

    protected InteractionResult harvestPearls(BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand, BlockHitResult context) {
        int j = 1 + level.random.nextInt(2);
        popResource(level, pos, new ItemStack(NDItems.PROPELPEARL.get(), j));
        level.playSound(null, pos, SoundEvents.SWEET_BERRY_BUSH_PICK_BERRIES, SoundSource.BLOCKS, 1.0F, 0.8F + level.random.nextFloat() * 0.4F);
        level.setBlock(pos, state.setValue(PEARL, Boolean.FALSE), 2);
        return InteractionResult.sidedSuccess(level.isClientSide);
    }
}
