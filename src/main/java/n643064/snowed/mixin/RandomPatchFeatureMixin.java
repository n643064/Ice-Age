package n643064.snowed.mixin;

import net.minecraft.world.gen.feature.RandomPatchFeature;
import net.minecraft.world.gen.feature.RandomPatchFeatureConfig;
import net.minecraft.world.gen.feature.util.FeatureContext;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(RandomPatchFeature.class)
public class RandomPatchFeatureMixin {
    @Inject(method = "generate", at = @At("HEAD"), cancellable = true)
    private void injected(FeatureContext<RandomPatchFeatureConfig> context, CallbackInfoReturnable<Boolean> cir) {
        cir.setReturnValue(false);
    }
}