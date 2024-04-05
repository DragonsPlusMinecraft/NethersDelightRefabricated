package umpaz.nethersdelight.integration.emi.recipe;

import dev.emi.emi.api.recipe.EmiRecipe;
import dev.emi.emi.api.recipe.EmiRecipeCategory;
import dev.emi.emi.api.stack.EmiIngredient;
import dev.emi.emi.api.stack.EmiStack;
import dev.emi.emi.api.widget.SlotWidget;
import dev.emi.emi.api.widget.WidgetHolder;
import net.minecraft.client.gui.screens.inventory.tooltip.ClientTooltipComponent;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import umpaz.nethersdelight.NethersDelight;
import umpaz.nethersdelight.common.registry.NDItems;
import umpaz.nethersdelight.common.tag.NDTags;
import umpaz.nethersdelight.integration.emi.NDRecipeCategories;
import umpaz.nethersdelight.integration.emi.NDRecipeWorkstations;
import vectorwing.farmersdelight.common.utility.ClientRenderUtils;

import java.util.List;

public class CompositionEmiRecipe implements EmiRecipe {
    private static final ResourceLocation BACKGROUND = new ResourceLocation(NethersDelight.MODID, "textures/gui/jei/composition.png");

    private static final EmiStack RICH_SOUL_SOIL = EmiStack.of(NDItems.RICH_SOUL_SOIL.get());
    private static final EmiIngredient ACCELERATORS = EmiIngredient.of(NDTags.SOUL_COMPOST_ACTIVATORS);
    private static final EmiIngredient FLAMES = EmiIngredient.of(NDTags.SOUL_COMPOST_FLAMES);

    private static final ClientTooltipComponent LIGHT_TOOLTIP = createTooltip(".light");
    private static final ClientTooltipComponent FLUID_TOOLTIP = createTooltip(".fluid");
    private static final ClientTooltipComponent ACCELERATORS_TOOLTIP = createTooltip(".accelerators");
    private static final ClientTooltipComponent NETHER_TOOLTIP = createTooltip(".nether");

    @Override
    public EmiRecipeCategory getCategory() {
        return NDRecipeCategories.COMPOSITION;
    }

    @Override
    public @Nullable ResourceLocation getId() {
        return new ResourceLocation(NethersDelight.MODID, "composition/dummy");
    }

    @Override
    public List<EmiIngredient> getInputs() {
        return List.of(NDRecipeWorkstations.SOUL_COMPOST);
    }

    @Override
    public List<EmiStack> getOutputs() {
        return List.of(RICH_SOUL_SOIL);
    }

    @Override
    public int getDisplayWidth() {
        return 102;
    }

    @Override
    public int getDisplayHeight() {
        return 62;
    }

    @Override
    public void addWidgets(WidgetHolder widgets) {
        widgets.addTexture(BACKGROUND, 0, 0, 102, 41, 8, 9);

        addSlot(widgets, NDRecipeWorkstations.SOUL_COMPOST, 0, 16);
        addSlot(widgets, RICH_SOUL_SOIL, 84, 16).recipeContext(this);
        addSlot(widgets, ACCELERATORS, 55, 44);
        addSlot(widgets, FLAMES, 39, 44);

        widgets.addTooltip((mouseX, mouseY) -> {
            if (ClientRenderUtils.isCursorInsideBounds(32, 30, 11, 11, mouseX, mouseY)) {
                return List.of(LIGHT_TOOLTIP);
            } else if (ClientRenderUtils.isCursorInsideBounds(45, 30, 11, 11, mouseX, mouseY)) {
                return List.of(FLUID_TOOLTIP);
            } else if (ClientRenderUtils.isCursorInsideBounds(59, 30, 11, 11, mouseX, mouseY)) {
                return List.of(ACCELERATORS_TOOLTIP);
            } else if (ClientRenderUtils.isCursorInsideBounds(41, 1, 16, 19, mouseX, mouseY)) {
                return List.of(NETHER_TOOLTIP);
            }
            return List.of();
        }, 0, 0, widgets.getWidth(), widgets.getHeight());
    }

    private SlotWidget addSlot(WidgetHolder widgets, EmiIngredient ingredient, int x, int y) {
        return widgets.addSlot(ingredient, x, y).backgroundTexture(BACKGROUND, 119, 0);
    }

    private static ClientTooltipComponent createTooltip(@NotNull String suffix) {
        return ClientTooltipComponent.create(Component.translatable(NethersDelight.MODID + ".jei.composition" + suffix).getVisualOrderText());
    }

}
