package umpaz.nethersdelight.common.registry;

import io.github.fabricators_of_create.porting_lib.util.LazyRegistrar;
import net.minecraft.core.Direction;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.item.*;
import umpaz.nethersdelight.NethersDelight;
import umpaz.nethersdelight.common.item.FungusColonyItem;
import umpaz.nethersdelight.common.item.MacheteItem;
import umpaz.nethersdelight.common.item.MagmaGelatinItem;
import umpaz.nethersdelight.common.item.PropelpearlItem;
import umpaz.nethersdelight.common.utility.NDFoods;
import vectorwing.farmersdelight.common.item.ConsumableItem;

import java.util.function.Supplier;

public class NDItems {

    public static final LazyRegistrar<Item> ITEMS = LazyRegistrar.create(BuiltInRegistries.ITEM, NethersDelight.MODID);

    // Workstations
    public static final Supplier<Item> BLACKSTONE_STOVE = ITEMS.register("blackstone_stove",
            () -> new BlockItem(NDBlocks.BLACKSTONE_STOVE.get(), new Item.Properties())
    );
    public static final Supplier<Item> BLACKSTONE_FURNACE = ITEMS.register("blackstone_furnace",
            () -> new BlockItem(NDBlocks.BLACKSTONE_FURNACE.get(), new Item.Properties())
    );
    public static final Supplier<Item> NETHER_BRICK_SMOKER = ITEMS.register("nether_brick_smoker",
            () -> new BlockItem(NDBlocks.NETHER_BRICK_SMOKER.get(), new Item.Properties())
    );
    public static final Supplier<Item> BLACKSTONE_BLAST_FURNACE = ITEMS.register("blackstone_blast_furnace",
            () -> new BlockItem(NDBlocks.BLACKSTONE_BLAST_FURNACE.get(), new Item.Properties())
    );
    // Blocks
    public static final Supplier<Item> CRIMSON_FUNGUS_COLONY = ITEMS.register("crimson_fungus_colony",
            () -> new FungusColonyItem(NDBlocks.CRIMSON_FUNGUS_COLONY.get(), new Item.Properties())
    );
    public static final Supplier<Item> WARPED_FUNGUS_COLONY = ITEMS.register("warped_fungus_colony",
            () -> new FungusColonyItem(NDBlocks.WARPED_FUNGUS_COLONY.get(), new Item.Properties())
    );
    public static final Supplier<Item> SOUL_COMPOST = ITEMS.register("soul_compost",
            () -> new BlockItem(NDBlocks.SOUL_COMPOST.get(), new Item.Properties()));
    public static final Supplier<Item> RICH_SOUL_SOIL = ITEMS.register("rich_soul_soil",
            () -> new BlockItem(NDBlocks.RICH_SOUL_SOIL.get(), new Item.Properties())
    );
    public static final Supplier<Item> MIMICARNATION = ITEMS.register("mimicarnation",
            () -> new BlockItem(NDBlocks.MIMICARNATION.get(), new Item.Properties())
    );
    public static final Supplier<Item> HOGLIN_TROPHY = ITEMS.register("hoglin_trophy",
            () -> new BlockItem(NDBlocks.HOGLIN_TROPHY.get(), new Item.Properties())
    );
    public static final Supplier<Item> STUFFED_HOGLIN = ITEMS.register("stuffed_hoglin",
            () -> new BlockItem(NDBlocks.STUFFED_HOGLIN.get(), new Item.Properties().stacksTo(1))
    );

    public static final Supplier<Item> PROPELPLANT_CANE = ITEMS.register("propelplant_cane",
            () -> new BlockItem(NDBlocks.PROPELPLANT_CANE.get(), new Item.Properties())
    );

    public static final Supplier<Item> PROPELPLANT_TORCH = ITEMS.register("propelplant_torch",
            () -> new StandingAndWallBlockItem(
                    NDBlocks.PROPELPLANT_TORCH.get(),
                    NDBlocks.PROPELPLANT_WALL_TORCH.get(),
                    new Item.Properties(),
                    Direction.DOWN
            )
    );

    // Items
    public static final Supplier<Item> HOGLIN_HIDE = ITEMS.register("hoglin_hide",
            () -> new Item(new Item.Properties())
    );
    public static final Supplier<Item> RAW_STUFFED_HOGLIN = ITEMS.register("raw_stuffed_hoglin",
            () -> new Item(new Item.Properties().stacksTo(1))
    );
    public static final Supplier<Item> HOGLIN_LOIN = ITEMS.register("hoglin_loin",
            () -> new Item(new Item.Properties().food(NDFoods.HOGLIN_LOIN))
    );
    public static final Supplier<Item> HOGLIN_SIRLOIN = ITEMS.register("hoglin_sirloin",
            () -> new Item(new Item.Properties().food(NDFoods.HOGLIN_SIRLOIN))
    );
    public static final Supplier<Item> STRIDER_SLICE = ITEMS.register("strider_slice",
            () -> new Item(new Item.Properties().food(NDFoods.STRIDER_SLICE).fireResistant())
    );
    public static final Supplier<Item> GROUND_STRIDER = ITEMS.register("ground_strider",
            () -> new Item(new Item.Properties().food(NDFoods.GROUND_STRIDER).fireResistant())
    );
    public static final Supplier<Item> HOGLIN_EAR = ITEMS.register("hoglin_ear",
            () -> new Item(new Item.Properties().food(NDFoods.HOGLIN_EAR))
    );
    public static final Supplier<Item> WARPED_MOLDY_MEAT = ITEMS.register("warped_moldy_meat",
            () -> new ConsumableItem(new Item.Properties().food(NDFoods.WARPED_MOLDY_MEAT).craftRemainder(Items.BOWL).stacksTo(16))
    );
    public static final Supplier<Item> GRILLED_STRIDER = ITEMS.register("grilled_strider",
            () -> new ConsumableItem(new Item.Properties().food(NDFoods.GRILLED_STRIDER).craftRemainder(Items.BOWL).stacksTo(16))
    );
    public static final Supplier<Item> STRIDER_MOSS_STEW = ITEMS.register("strider_moss_stew",
            () -> new ConsumableItem(new Item.Properties().food(NDFoods.STRIDER_MOSS_STEW).craftRemainder(Items.BOWL).stacksTo(16))
    );
    public static final Supplier<Item> PLATE_OF_STUFFED_HOGLIN_SNOUT = ITEMS.register("plate_of_stuffed_hoglin_snout",
            () -> new ConsumableItem(new Item.Properties().food(NDFoods.PLATE_OF_STUFFED_HOGLIN_SNOUT).craftRemainder(Items.BOWL).stacksTo(16))
    );
    public static final Supplier<Item> PLATE_OF_STUFFED_HOGLIN_HAM = ITEMS.register("plate_of_stuffed_hoglin_ham",
            () -> new ConsumableItem(new Item.Properties().food(NDFoods.PLATE_OF_STUFFED_HOGLIN_HAM).craftRemainder(Items.BOWL).stacksTo(16))
    );
    public static final Supplier<Item> PLATE_OF_STUFFED_HOGLIN_ROAST = ITEMS.register("plate_of_stuffed_hoglin_roast",
            () -> new ConsumableItem(new Item.Properties().food(NDFoods.PLATE_OF_STUFFED_HOGLIN_ROAST).craftRemainder(Items.BOWL).stacksTo(16))
    );
    public static final Supplier<Item> PROPELPEARL = ITEMS.register("propelpearl",
            () -> new PropelpearlItem(new Item.Properties().food(NDFoods.PROPELPEARL))
    );
    public static final Supplier<Item> NETHER_SKEWER = ITEMS.register("nether_skewer",
            () -> new ConsumableItem(new Item.Properties().food(NDFoods.NETHER_SKEWER).craftRemainder(Items.BLAZE_ROD))
    );
    public static final Supplier<Item> MAGMA_GELATIN = ITEMS.register("magma_gelatin",
            () -> new MagmaGelatinItem(new Item.Properties().food(NDFoods.MAGMA_GELATIN).stacksTo(1).craftRemainder(Items.BUCKET))
    );
    public static final Supplier<Item> IRON_MACHETE = ITEMS.register("iron_machete",
            () -> new MacheteItem(Tiers.IRON, 2, -2.6F, new Item.Properties())
    );
    public static final Supplier<Item> DIAMOND_MACHETE = ITEMS.register("diamond_machete",
            () -> new MacheteItem(Tiers.DIAMOND, 2, -2.6F, new Item.Properties())
    );
    public static final Supplier<Item> NETHERITE_MACHETE = ITEMS.register("netherite_machete",
            () -> new MacheteItem(Tiers.NETHERITE, 2, -2.6F, new Item.Properties())
    );
    public static final Supplier<Item> GOLDEN_MACHETE = ITEMS.register("golden_machete",
            () -> new MacheteItem(Tiers.GOLD, 2, -2.6F, new Item.Properties())
    );
}
