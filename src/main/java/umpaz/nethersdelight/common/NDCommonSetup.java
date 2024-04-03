package umpaz.nethersdelight.common;

import net.minecraft.world.level.block.ComposterBlock;
import umpaz.nethersdelight.common.registry.NDCreativeTab;
import umpaz.nethersdelight.common.registry.NDItems;


public class NDCommonSetup {

    public static void init() {
        NDCreativeTab.buildContents();
        registerCompostables();
    }

    public static void registerCompostables() {
        ComposterBlock.COMPOSTABLES.put(NDItems.WARPED_FUNGUS_COLONY.get(), 1.0F);
        ComposterBlock.COMPOSTABLES.put(NDItems.CRIMSON_FUNGUS_COLONY.get(), 1.0F);
        ComposterBlock.COMPOSTABLES.put(NDItems.PROPELPLANT_CANE.get(), 0.4F);
    }
}