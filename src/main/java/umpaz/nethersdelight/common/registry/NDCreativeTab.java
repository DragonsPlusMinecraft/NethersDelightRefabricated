package umpaz.nethersdelight.common.registry;

import io.github.fabricators_of_create.porting_lib.util.LazyRegistrar;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import umpaz.nethersdelight.NethersDelight;
import umpaz.nethersdelight.common.utility.NDTextUtils;

import java.util.Set;
import java.util.function.Supplier;

public class NDCreativeTab {
    public static final LazyRegistrar<CreativeModeTab> TABS = LazyRegistrar.create(Registries.CREATIVE_MODE_TAB, NethersDelight.MODID);

    public static final Supplier<CreativeModeTab> NETHERS_DELIGHT_TAB = TABS.register("main",
            () -> FabricItemGroup.builder()
                    .title(NDTextUtils.getTranslation("itemGroup.main"))
                    .icon(NDItems.BLACKSTONE_STOVE.get()::getDefaultInstance)
                    .build()
    );

    private static void acceptFoodsAndDrinksTabContents(FabricItemGroupEntries entries) {
        acceptFoodItems(entries);
    }

    private static void acceptToolsAndUtilitiesContents(FabricItemGroupEntries entries) {
        acceptMacheteItems(entries);
    }

    private static void acceptCombatContents(FabricItemGroupEntries entries) {
        acceptMacheteItems(entries);
    }

    private static void acceptMainTabContents(FabricItemGroupEntries entries) {
        acceptWorkstations(entries);
        acceptBlocks(entries);
        acceptItems(entries);
    }

    private static void acceptWorkstations(FabricItemGroupEntries entries) {
        entries.accept(NDItems.BLACKSTONE_STOVE.get());
        entries.accept(NDItems.BLACKSTONE_FURNACE.get());
        entries.accept(NDItems.NETHER_BRICK_SMOKER.get());
        entries.accept(NDItems.BLACKSTONE_BLAST_FURNACE.get());
    }

    private static void acceptBlocks(FabricItemGroupEntries entries) {
        entries.accept(NDItems.CRIMSON_FUNGUS_COLONY.get());
        entries.accept(NDItems.WARPED_FUNGUS_COLONY.get());
        entries.accept(NDItems.SOUL_COMPOST.get());
        entries.accept(NDItems.RICH_SOUL_SOIL.get());
        entries.accept(NDItems.MIMICARNATION.get());
        entries.accept(NDItems.HOGLIN_TROPHY.get());
        entries.accept(NDItems.STUFFED_HOGLIN.get());
        entries.accept(NDItems.PROPELPLANT_CANE.get());
        entries.accept(NDItems.PROPELPLANT_TORCH.get());
    }

    private static void acceptItems(FabricItemGroupEntries entries) {
        acceptMacheteItems(entries);
        acceptFoodItems(entries);

        entries.accept(NDItems.HOGLIN_HIDE.get());
        entries.addBefore(
                NDItems.STUFFED_HOGLIN.get().getDefaultInstance(),
                Set.of(NDItems.RAW_STUFFED_HOGLIN.get().getDefaultInstance()),
                CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS
        );
    }

    private static void acceptMacheteItems(FabricItemGroupEntries entries) {
        entries.accept(NDItems.IRON_MACHETE.get());
        entries.accept(NDItems.GOLDEN_MACHETE.get());
        entries.accept(NDItems.DIAMOND_MACHETE.get());
        entries.accept(NDItems.NETHERITE_MACHETE.get());
    }

    private static void acceptFoodItems(FabricItemGroupEntries entries) {
        entries.accept(NDItems.HOGLIN_LOIN.get());
        entries.accept(NDItems.HOGLIN_SIRLOIN.get());
        entries.accept(NDItems.HOGLIN_EAR.get());
        entries.accept(NDItems.STRIDER_SLICE.get());
        entries.accept(NDItems.GRILLED_STRIDER.get());
        entries.accept(NDItems.GROUND_STRIDER.get());
        entries.accept(NDItems.WARPED_MOLDY_MEAT.get());
        entries.accept(NDItems.STRIDER_MOSS_STEW.get());
        entries.accept(NDItems.PLATE_OF_STUFFED_HOGLIN_SNOUT.get());
        entries.accept(NDItems.PLATE_OF_STUFFED_HOGLIN_HAM.get());
        entries.accept(NDItems.PLATE_OF_STUFFED_HOGLIN_ROAST.get());
        entries.accept(NDItems.NETHER_SKEWER.get());
        entries.accept(NDItems.MAGMA_GELATIN.get());
        entries.addAfter(
            NDItems.PROPELPLANT_CANE.get().getDefaultInstance(),
            Set.of(NDItems.PROPELPEARL.get().getDefaultInstance()),
            CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS
        );
    }

    public static void buildContents() {
        ItemGroupEvents
            .modifyEntriesEvent(CreativeModeTabs.FOOD_AND_DRINKS)
            .register(NDCreativeTab::acceptFoodsAndDrinksTabContents);
        ItemGroupEvents
            .modifyEntriesEvent(CreativeModeTabs.TOOLS_AND_UTILITIES)
            .register(NDCreativeTab::acceptToolsAndUtilitiesContents);
        ItemGroupEvents
            .modifyEntriesEvent(CreativeModeTabs.COMBAT)
            .register(NDCreativeTab::acceptCombatContents);
        ItemGroupEvents
            .modifyEntriesEvent(ResourceKey.create(Registries.CREATIVE_MODE_TAB, new ResourceLocation(NethersDelight.MODID, "main")))
            .register(NDCreativeTab::acceptMainTabContents);
    }

}
