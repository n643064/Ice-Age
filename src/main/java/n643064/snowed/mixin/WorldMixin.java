package n643064.snowed.mixin;

import net.minecraft.util.registry.RegistryEntry;
import net.minecraft.util.registry.RegistryKey;
import net.minecraft.world.MutableWorldProperties;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.awt.*;
import java.util.function.Supplier;

@Mixin(World.class)
public abstract class WorldMixin
{
    @Inject(method = "<init>", at = @At("TAIL"))
    private void init(MutableWorldProperties properties, RegistryKey registryRef, RegistryEntry dimension, Supplier profiler, boolean isClient, boolean debugWorld, long seed, int maxChainedNeighborUpdates, CallbackInfo ci)
    {
        properties.setRaining(true);
    }
}
