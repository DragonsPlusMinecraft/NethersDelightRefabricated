package umpaz.nethersdelight.common.registry;

import io.github.fabricators_of_create.porting_lib.util.LazyRegistrar;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.level.block.entity.BlockEntityType;
import umpaz.nethersdelight.NethersDelight;
import umpaz.nethersdelight.common.block.entity.BlackstoneBlastFurnaceBlockEntity;
import umpaz.nethersdelight.common.block.entity.BlackstoneFurnaceBlockEntity;
import umpaz.nethersdelight.common.block.entity.BlackstoneStoveBlockEntity;
import umpaz.nethersdelight.common.block.entity.NetherBrickSmokerBlockEntity;

import java.util.function.Supplier;

public class NDBlockEntityTypes {

    public static final LazyRegistrar<BlockEntityType<?>> BLOCK_ENTITY_TYPES = LazyRegistrar.create(BuiltInRegistries.BLOCK_ENTITY_TYPE, NethersDelight.MODID);

    public static final Supplier<BlockEntityType<BlackstoneStoveBlockEntity>> BLACKSTONE_STOVE = BLOCK_ENTITY_TYPES.register("blackstone_stove",
            () -> BlockEntityType.Builder.of(BlackstoneStoveBlockEntity::new, NDBlocks.BLACKSTONE_STOVE.get()).build(null));

    public static final Supplier<BlockEntityType<BlackstoneFurnaceBlockEntity>> BLACKSTONE_FURNACE = BLOCK_ENTITY_TYPES.register("blackstone_furnace",
            () -> BlockEntityType.Builder.of(BlackstoneFurnaceBlockEntity::new, NDBlocks.BLACKSTONE_FURNACE.get()).build(null));

    public static final Supplier<BlockEntityType<NetherBrickSmokerBlockEntity>> NETHER_BRICK_SMOKER = BLOCK_ENTITY_TYPES.register("nether_brick_smoker",
            () -> BlockEntityType.Builder.of(NetherBrickSmokerBlockEntity::new, NDBlocks.NETHER_BRICK_SMOKER.get()).build(null));

    public static final Supplier<BlockEntityType<BlackstoneBlastFurnaceBlockEntity>> BLACKSTONE_BLAST_FURNACE = BLOCK_ENTITY_TYPES.register("blackstone_blast_furnace",
            () -> BlockEntityType.Builder.of(BlackstoneBlastFurnaceBlockEntity::new, NDBlocks.BLACKSTONE_BLAST_FURNACE.get()).build(null));
}
