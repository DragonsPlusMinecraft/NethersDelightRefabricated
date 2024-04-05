package umpaz.nethersdelight.integration.jei.category;

import com.google.common.collect.ImmutableList;
import mezz.jei.api.constants.VanillaTypes;
import mezz.jei.api.gui.builder.IRecipeLayoutBuilder;
import mezz.jei.api.gui.drawable.IDrawable;
import mezz.jei.api.gui.ingredient.IRecipeSlotsView;
import mezz.jei.api.helpers.IGuiHelper;
import mezz.jei.api.recipe.IFocusGroup;
import mezz.jei.api.recipe.RecipeIngredientRole;
import mezz.jei.api.recipe.RecipeType;
import mezz.jei.api.recipe.category.IRecipeCategory;
import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.core.HolderSet;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import org.jetbrains.annotations.NotNull;
import umpaz.nethersdelight.NethersDelight;
import umpaz.nethersdelight.common.registry.NDBlocks;
import umpaz.nethersdelight.common.registry.NDItems;
import umpaz.nethersdelight.common.tag.NDTags;
import umpaz.nethersdelight.common.utility.NDTextUtils;
import umpaz.nethersdelight.integration.jei.NDRecipeTypes;
import umpaz.nethersdelight.integration.jei.resource.CompositionDummy;
import vectorwing.farmersdelight.common.utility.ClientRenderUtils;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@MethodsReturnNonnullByDefault
public class CompositionRecipeCategory implements IRecipeCategory<CompositionDummy>
{
    public static final ResourceLocation UID = new ResourceLocation(NethersDelight.MODID, "composition");
    private static final int slotSize = 22;

    private final Component title;
    private final IDrawable background;
    private final IDrawable slotIcon;
    private final IDrawable icon;
    private final ItemStack soulCompost;
    private final ItemStack richSoulSoil;

    public CompositionRecipeCategory(IGuiHelper helper) {
        title = NDTextUtils.getTranslation("jei.composition");
        ResourceLocation backgroundImage = new ResourceLocation(NethersDelight.MODID, "textures/gui/jei/composition.png");
        background = helper.createDrawable(backgroundImage, 0, 0, 118, 80);
        soulCompost = new ItemStack(NDBlocks.SOUL_COMPOST.get());
        richSoulSoil = new ItemStack(NDItems.RICH_SOUL_SOIL.get());
        icon = helper.createDrawableIngredient(VanillaTypes.ITEM_STACK, richSoulSoil);
        slotIcon = helper.createDrawable(backgroundImage, 119, 0, slotSize, slotSize);
    }

    @Override
    public RecipeType<CompositionDummy> getRecipeType() {
        return NDRecipeTypes.COMPOSITION;
    }

    @Override
    public Component getTitle() {
        return this.title;
    }

    @Override
    public IDrawable getBackground() {
        return this.background;
    }

    @Override
    public IDrawable getIcon() {
        return this.icon;
    }

    @Override
    public void setRecipe(IRecipeLayoutBuilder builder, @NotNull CompositionDummy recipe, @NotNull IFocusGroup focusGroup) {
        List<ItemStack> accelerators = BuiltInRegistries.BLOCK.getTag(NDTags.SOUL_COMPOST_ACTIVATORS)
            .stream()
            .flatMap(HolderSet::stream)
            .map(holder -> new ItemStack(holder.value()))
            .collect(Collectors.toList());
        List<ItemStack> flames = BuiltInRegistries.BLOCK.getTag(NDTags.SOUL_COMPOST_FLAMES)
            .stream()
            .flatMap(HolderSet::stream)
            .map(holder -> new ItemStack(holder.value()))
            .collect(Collectors.toList());

        builder.addSlot(RecipeIngredientRole.INPUT, 9, 26).addItemStack(soulCompost);
        builder.addSlot(RecipeIngredientRole.OUTPUT, 93, 26).addItemStack(richSoulSoil);
        builder.addSlot(RecipeIngredientRole.RENDER_ONLY, 64, 54).addItemStacks(accelerators);
        builder.addSlot(RecipeIngredientRole.RENDER_ONLY, 38, 54).addItemStacks(flames);
    }

    @Override
    public void draw(@NotNull CompositionDummy recipe, @NotNull IRecipeSlotsView recipeSlotsView, @NotNull GuiGraphics guiGraphics, double mouseX, double mouseY) {
        this.slotIcon.draw(guiGraphics, 63, 53);
        this.slotIcon.draw(guiGraphics, 37, 53);
    }

    @Override
    public List<Component> getTooltipStrings(@NotNull CompositionDummy recipe, @NotNull IRecipeSlotsView recipeSlotsView, double mouseX, double mouseY) {
        if (ClientRenderUtils.isCursorInsideBounds(40, 38, 11, 11, mouseX, mouseY)) {
            return ImmutableList.of(translateKey(".light"));
        }
        if (ClientRenderUtils.isCursorInsideBounds(53, 38, 11, 11, mouseX, mouseY)) {
            return ImmutableList.of(translateKey(".fluid"));
        }
        if (ClientRenderUtils.isCursorInsideBounds(67, 38, 11, 11, mouseX, mouseY)) {
            return ImmutableList.of(translateKey(".accelerators"));
        }
        if (ClientRenderUtils.isCursorInsideBounds(49, 9, 16, 19, mouseX, mouseY)) {
            return ImmutableList.of(translateKey(".nether"));
        }
        return Collections.emptyList();
    }

    private static MutableComponent translateKey(@NotNull String suffix) {
        return Component.translatable(NethersDelight.MODID + ".jei.composition" + suffix);
    }
}