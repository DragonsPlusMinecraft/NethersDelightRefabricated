package umpaz.nethersdelight.client.event;

import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderers;
import umpaz.nethersdelight.client.renderer.StoveRenderer;
import umpaz.nethersdelight.common.block.entity.BlackstoneStoveBlockEntity;
import umpaz.nethersdelight.common.registry.NDBlockEntityTypes;
import umpaz.nethersdelight.common.registry.NDBlocks;

public class NDClientSetupEvents {

    public static void init() {
        onRegisterRenderers();
        onRegisterRenderTypes();
    }

    public static void onRegisterRenderers() {
        BlockEntityRenderers.register(NDBlockEntityTypes.BLACKSTONE_STOVE.get(), StoveRenderer<BlackstoneStoveBlockEntity>::new);
    }

    public static void onRegisterRenderTypes() {
        BlockRenderLayerMap.INSTANCE.putBlocks(RenderType.cutout(),
            NDBlocks.MIMICARNATION.get(),
            NDBlocks.PROPELPLANT_CANE.get(),
            NDBlocks.PROPELPLANT_TORCH.get(),
            NDBlocks.PROPELPLANT_WALL_TORCH.get(),
            NDBlocks.CRIMSON_FUNGUS_COLONY.get(),
            NDBlocks.WARPED_FUNGUS_COLONY.get(),
            NDBlocks.STUFFED_HOGLIN.get());
    }
}
