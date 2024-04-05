package umpaz.nethersdelight.integration.rei.display;

import me.shedaniel.rei.api.common.category.CategoryIdentifier;
import me.shedaniel.rei.api.common.display.Display;
import me.shedaniel.rei.api.common.entry.EntryIngredient;
import me.shedaniel.rei.api.common.util.EntryIngredients;
import umpaz.nethersdelight.common.registry.NDItems;
import umpaz.nethersdelight.integration.rei.NDCategoryIdentifiers;

import java.util.List;

public class CompositionDisplay implements Display {

    @Override
    public List<EntryIngredient> getInputEntries() {
        return List.of(EntryIngredients.of(NDItems.SOUL_COMPOST.get()));
    }

    @Override
    public List<EntryIngredient> getOutputEntries() {
        return List.of(EntryIngredients.of(NDItems.RICH_SOUL_SOIL.get()));
    }

    @Override
    public CategoryIdentifier<?> getCategoryIdentifier() {
        return NDCategoryIdentifiers.COMPOSITION;
    }

}
