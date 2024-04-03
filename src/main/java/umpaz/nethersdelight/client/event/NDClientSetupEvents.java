package umpaz.nethersdelight.client.event;

import net.minecraft.client.renderer.blockentity.BlockEntityRenderers;
import umpaz.nethersdelight.client.renderer.StoveRenderer;
import umpaz.nethersdelight.common.block.entity.BlackstoneStoveBlockEntity;
import umpaz.nethersdelight.common.registry.NDBlockEntityTypes;

public class NDClientSetupEvents {

    public static void init() {
        onRegisterRenderers();
    }

    public static void onRegisterRenderers() {
        BlockEntityRenderers.register(NDBlockEntityTypes.BLACKSTONE_STOVE.get(), StoveRenderer<BlackstoneStoveBlockEntity>::new);
    }
}
