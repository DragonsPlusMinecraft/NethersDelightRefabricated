package umpaz.nethersdelight;

import com.mojang.logging.LogUtils;
import net.fabricmc.api.ModInitializer;
import org.slf4j.Logger;
import umpaz.nethersdelight.common.NDCommonSetup;
import umpaz.nethersdelight.common.registry.*;

public class NethersDelight implements ModInitializer {
	public static final String MODID = "nethersdelight";
	public static final Logger LOGGER = LogUtils.getLogger();

	@Override
	public void onInitialize() {
		NDBlocks.BLOCKS.register();
		NDItems.ITEMS.register();
		NDBlockEntityTypes.BLOCK_ENTITY_TYPES.register();
		NDFeatures.FEATURES.register();
		NDCreativeTab.TABS.register();
		NDCommonSetup.init();
	}

}
