package umpaz.nethersdelight.integration.rei;

import me.shedaniel.rei.api.common.category.CategoryIdentifier;
import net.minecraft.resources.ResourceLocation;
import umpaz.nethersdelight.NethersDelight;
import umpaz.nethersdelight.integration.rei.display.CompositionDisplay;

public class NDCategoryIdentifiers {

    public static final CategoryIdentifier<CompositionDisplay> COMPOSITION =
        CategoryIdentifier.of(new ResourceLocation(NethersDelight.MODID, "plugin/composition"));

}
