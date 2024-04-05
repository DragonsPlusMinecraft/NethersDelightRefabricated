package umpaz.nethersdelight.integration.emi;

import dev.emi.emi.api.recipe.EmiRecipeCategory;
import dev.emi.emi.api.render.EmiRenderable;
import net.minecraft.resources.ResourceLocation;
import umpaz.nethersdelight.NethersDelight;
import vectorwing.farmersdelight.FarmersDelight;

public class NDRecipeCategories {
    //Using FD's simplified texture for composition, maybe moving to own textures in future?
    private static final ResourceLocation SIMPLIFIED_TEXTURES = FarmersDelight.res("textures/gui/emi/simplified.png");

    public static final EmiRecipeCategory COMPOSITION = new EmiRecipeCategory(
        new ResourceLocation(NethersDelight.MODID, "composition"),
        NDRecipeWorkstations.SOUL_COMPOST,
        simplifiedRenderer(32, 0)
    );

    @SuppressWarnings("SameParameterValue")
    private static EmiRenderable simplifiedRenderer(int u, int v) {
        return (draw, x, y, delta) -> {
            draw.blit(SIMPLIFIED_TEXTURES, x, y, u, v, 16, 16, 48, 16);
        };
    }

}
