package umpaz.nethersdelight.integration.rei;

import me.shedaniel.rei.api.client.plugins.REIClientPlugin;
import me.shedaniel.rei.api.client.registry.category.CategoryRegistry;
import me.shedaniel.rei.api.client.registry.display.DisplayRegistry;
import me.shedaniel.rei.api.common.util.EntryStacks;
import me.shedaniel.rei.plugin.common.BuiltinPlugin;
import umpaz.nethersdelight.common.registry.NDItems;
import umpaz.nethersdelight.integration.rei.category.CompositionCategory;
import umpaz.nethersdelight.integration.rei.display.CompositionDisplay;

public class NDREIClientPlugin implements REIClientPlugin {

    @Override
    public void registerDisplays(DisplayRegistry registry) {
        registry.add(new CompositionDisplay());
    }

    @Override
    public void registerCategories(CategoryRegistry registry) {
        registry.add(new CompositionCategory());

        registry.addWorkstations(BuiltinPlugin.CAMPFIRE, EntryStacks.of(NDItems.BLACKSTONE_STOVE.get()));
        registry.addWorkstations(BuiltinPlugin.SMELTING, EntryStacks.of(NDItems.BLACKSTONE_FURNACE.get()));
        registry.addWorkstations(BuiltinPlugin.SMOKING, EntryStacks.of(NDItems.NETHER_BRICK_SMOKER.get()));
        registry.addWorkstations(BuiltinPlugin.BLASTING, EntryStacks.of(NDItems.BLACKSTONE_BLAST_FURNACE.get()));
    }

}
