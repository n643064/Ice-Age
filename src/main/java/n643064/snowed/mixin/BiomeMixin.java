package n643064.snowed.mixin;

import net.minecraft.world.biome.Biome;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;


@Mixin(Biome.class)
public abstract class BiomeMixin
{
    @Inject(method = "getTemperature()F", at = @At("RETURN"), cancellable = true)
    private void getTemperature(CallbackInfoReturnable<Float> cir)
    {
        float temp = cir.getReturnValue();
        cir.setReturnValue(temp > 1.5f ? 0 : temp - 1.6f);
    }
}