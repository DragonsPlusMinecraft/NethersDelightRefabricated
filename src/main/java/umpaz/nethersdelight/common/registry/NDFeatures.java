package umpaz.nethersdelight.common.registry;

import io.github.fabricators_of_create.porting_lib.util.LazyRegistrar;
import io.github.fabricators_of_create.porting_lib.util.RegistryObject;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;
import umpaz.nethersdelight.NethersDelight;
import umpaz.nethersdelight.common.world.level.levelgen.feature.PropelplantFeature;

public class NDFeatures {
    public static final LazyRegistrar<Feature<?>> FEATURES = LazyRegistrar.create(BuiltInRegistries.FEATURE, NethersDelight.MODID);

    public static final RegistryObject<Feature<NoneFeatureConfiguration>> PROPELPLANT = FEATURES.register("propelplant", () -> new PropelplantFeature(NoneFeatureConfiguration.CODEC));
}