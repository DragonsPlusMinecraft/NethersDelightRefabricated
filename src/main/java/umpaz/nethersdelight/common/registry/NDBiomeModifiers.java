package umpaz.nethersdelight.common.registry;

import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.biome.Biomes;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import umpaz.nethersdelight.NethersDelight;

public class NDBiomeModifiers {

    private static final ResourceKey<PlacedFeature> PROPELPLANT_PATCH = ResourceKey.create(Registries.PLACED_FEATURE,
        new ResourceLocation(NethersDelight.MODID, "propelplant_patch"));

    public static void init() {
        BiomeModifications.addFeature(context ->
            context.getBiomeKey() == Biomes.CRIMSON_FOREST,
            GenerationStep.Decoration.VEGETAL_DECORATION,
            PROPELPLANT_PATCH);
    }

}
