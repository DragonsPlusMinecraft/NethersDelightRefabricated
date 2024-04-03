package umpaz.nethersdelight;

import net.fabricmc.api.ClientModInitializer;
import umpaz.nethersdelight.client.event.NDClientSetupEvents;

public class NethersDelightClient implements ClientModInitializer {

    @Override
    public void onInitializeClient() {
        NDClientSetupEvents.init();
    }

}
