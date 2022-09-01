package n643064.snowed;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.biome.v1.BiomeModificationContext;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.ModificationPhase;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.util.Identifier;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.SpawnSettings;

import static net.minecraft.world.dimension.DimensionOptions.OVERWORLD;

public class Snowed implements ModInitializer
{
    @Override
    public void onInitialize()
    {
        BiomeModifications.create(new Identifier("snowed:freeze_world")).add(ModificationPhase.REPLACEMENTS, ctx -> ctx.canGenerateIn(OVERWORLD), ctx ->
        {
            final BiomeModificationContext.WeatherContext weather = ctx.getWeather();
            final BiomeModificationContext.SpawnSettingsContext spawnSettings = ctx.getSpawnSettings();
            final BiomeModificationContext.EffectsContext effects = ctx.getEffects();

            weather.setPrecipitation(Biome.Precipitation.SNOW);
            weather.setTemperatureModifier(Biome.TemperatureModifier.NONE);

            effects.setSkyColor(0xE6EAFF);
            effects.setFoliageColor(0x57a36d);
            effects.setGrassColor(0x57a36d);

            spawnSettings.addSpawn(SpawnGroup.CREATURE, new SpawnSettings.SpawnEntry(EntityType.FOX, 50, 1, 3));
            spawnSettings.addSpawn(SpawnGroup.CREATURE, new SpawnSettings.SpawnEntry(EntityType.POLAR_BEAR, 40, 1, 3));
            spawnSettings.addSpawn(SpawnGroup.CREATURE, new SpawnSettings.SpawnEntry(EntityType.SNOW_GOLEM, 10, 3, 6));
            spawnSettings.addSpawn(SpawnGroup.MONSTER, new SpawnSettings.SpawnEntry(EntityType.STRAY, 65, 1, 3));

        });

    }
}
