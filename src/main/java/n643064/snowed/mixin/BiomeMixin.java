package n643064.snowed.mixin;

import net.minecraft.world.biome.Biome;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;


@Mixin(Biome.class)
public abstract class BiomeMixin
{

    @Inject(method = "getPrecipitation", at = @At("HEAD"), cancellable = true)
    private void getPrecipitation(CallbackInfoReturnable<Biome.Precipitation> cir)
    {
        cir.setReturnValue(Biome.Precipitation.SNOW);
    }

    @Inject(method = "getTemperature()F", at = @At("RETURN"), cancellable = true)
    private void getTemperature(CallbackInfoReturnable<Float> cir)
    {
        float temp = cir.getReturnValue();
        cir.setReturnValue(temp > 1.5f ? 0 : temp - 1.5f);
    }

    @Inject(method = "getSkyColor", at = @At("HEAD"), cancellable = true)
    private void getSkyColor(CallbackInfoReturnable<Integer> cir)
    {
        cir.setReturnValue(0xE6EAFF);
    }

    @Inject(method = "getFoliageColor", at = @At("HEAD"), cancellable = true)
    private void getDefaultFoliageColor(CallbackInfoReturnable<Integer> cir)
    {
        cir.setReturnValue(0x57a36d);
    }

    @Inject(method = "getDefaultGrassColor", at = @At("HEAD"), cancellable = true)
    private void getDefaultGrassColor(CallbackInfoReturnable<Integer> cir)
    {
        cir.setReturnValue(0x57a36d);
    }
}