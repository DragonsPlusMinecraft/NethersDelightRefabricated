package umpaz.nethersdelight.integration.rei.category;

import me.shedaniel.math.Point;
import me.shedaniel.math.Rectangle;
import me.shedaniel.rei.api.client.gui.Renderer;
import me.shedaniel.rei.api.client.gui.widgets.Widget;
import me.shedaniel.rei.api.client.gui.widgets.Widgets;
import me.shedaniel.rei.api.client.registry.display.DisplayCategory;
import me.shedaniel.rei.api.common.category.CategoryIdentifier;
import me.shedaniel.rei.api.common.util.EntryIngredients;
import me.shedaniel.rei.api.common.util.EntryStacks;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.NotNull;
import umpaz.nethersdelight.NethersDelight;
import umpaz.nethersdelight.common.registry.NDItems;
import umpaz.nethersdelight.common.tag.NDTags;
import umpaz.nethersdelight.integration.rei.NDCategoryIdentifiers;
import umpaz.nethersdelight.integration.rei.display.CompositionDisplay;

import java.util.ArrayList;
import java.util.List;

public class CompositionCategory implements DisplayCategory<CompositionDisplay> {
    private static final ResourceLocation BACKGROUND = new ResourceLocation(NethersDelight.MODID, "textures/gui/jei/composition.png");

    @Override
    public CategoryIdentifier<? extends CompositionDisplay> getCategoryIdentifier() {
        return NDCategoryIdentifiers.COMPOSITION;
    }

    @Override
    public Component getTitle() {
        return Component.translatable("nethersdelight.jei.composition");
    }

    @Override
    public Renderer getIcon() {
        return EntryStacks.of(NDItems.SOUL_COMPOST.get());
    }

    @Override
    public int getDisplayHeight() {
        return 102;
    }

    @Override
    public int getDisplayWidth(CompositionDisplay display) {
        return 150;
    }

    @Override
    public List<Widget> setupDisplay(CompositionDisplay display, Rectangle bounds) {
        List<Widget> widgets = new ArrayList<>();

        Point startPoint = new Point(bounds.getCenterX() - 59, bounds.getCenterY() - 40);

        widgets.add(Widgets.createRecipeBase(bounds));
        widgets.add(Widgets.createTexturedWidget(BACKGROUND, startPoint.x, startPoint.y, 0, 0, 118, 80));

        widgets.add(Widgets.createSlot(new Point( startPoint.x + 9, startPoint.y + 26)).entry(EntryStacks.of(NDItems.SOUL_COMPOST.get())));
        widgets.add(Widgets.createSlot(new Point(startPoint.x + 93, startPoint.y + 26)).entry(EntryStacks.of(NDItems.RICH_SOUL_SOIL.get())));
        widgets.add(Widgets.createSlot(new Point(startPoint.x + 64, startPoint.y + 54)).entries(EntryIngredients.ofItemTag(NDTags.SOUL_COMPOST_ACTIVATORS)));
        widgets.add(Widgets.createSlot(new Point(startPoint.x + 38, startPoint.y + 54)).entries(EntryIngredients.ofItemTag(NDTags.SOUL_COMPOST_FLAMES)));

        widgets.add(Widgets.createTooltip(new Rectangle( startPoint.x + 40, startPoint.y + 38, 11, 11), translateKey(".light")));
        widgets.add(Widgets.createTooltip(new Rectangle(startPoint.x + 53, startPoint.y + 38, 11, 11), translateKey(".fluid")));
        widgets.add(Widgets.createTooltip(new Rectangle(startPoint.x + 67, startPoint.y + 38, 11, 11), translateKey(".accelerators")));
        widgets.add(Widgets.createTooltip(new Rectangle(startPoint.x + 49, startPoint.y + 9, 16, 19), translateKey(".nether")));

        return widgets;
    }

    private static MutableComponent translateKey(@NotNull String suffix) {
        return Component.translatable(NethersDelight.MODID + ".jei.composition" + suffix);
    }

    @Override
    public int getFixedDisplaysPerPage() {
        return 1;
    }

}
