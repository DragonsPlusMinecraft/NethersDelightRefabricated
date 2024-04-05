package umpaz.nethersdelight.integration.emi;

import dev.emi.emi.api.EmiEntrypoint;
import dev.emi.emi.api.EmiPlugin;
import dev.emi.emi.api.EmiRegistry;
import dev.emi.emi.api.recipe.VanillaEmiRecipeCategories;
import umpaz.nethersdelight.integration.emi.recipe.CompositionEmiRecipe;

@EmiEntrypoint
public class NDEMIPlugin implements EmiPlugin {

    @Override
    public void register(EmiRegistry registry) {
        registry.addWorkstation(VanillaEmiRecipeCategories.CAMPFIRE_COOKING, NDRecipeWorkstations.BLACKSTONE_STOVE);
        registry.addWorkstation(VanillaEmiRecipeCategories.SMELTING, NDRecipeWorkstations.BLACKSTONE_FURNACE);
        registry.addWorkstation(VanillaEmiRecipeCategories.SMOKING, NDRecipeWorkstations.NETHER_BRICK_SMOKER);
        registry.addWorkstation(VanillaEmiRecipeCategories.BLASTING, NDRecipeWorkstations.BLACKSTONE_BLAST_FURNACE);
        registry.addCategory(NDRecipeCategories.COMPOSITION);
        registry.addRecipe(new CompositionEmiRecipe());
    }

}
