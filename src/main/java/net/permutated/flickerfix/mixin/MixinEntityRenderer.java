package net.permutated.flickerfix.mixin;

import java.util.Optional;

import net.minecraft.client.renderer.EntityRenderer;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@SuppressWarnings({ "java:S1118", "java:S1610" })
@Mixin(EntityRenderer.class)
public abstract class MixinEntityRenderer {

    private static final int FADE_TICKS = 20;
    private static final float BRIGHTNESS = 1.0F;
    private static final float FADE_RATE = BRIGHTNESS / FADE_TICKS;

    @Inject(method = "getNightVisionBrightness", at = @At("HEAD"), cancellable = true)
    private void getNightVisionBrightness(EntityPlayer player, float tickDelta, CallbackInfoReturnable<Float> cir) {
        int i = Optional.ofNullable(player.getActivePotionEffect(Potion.nightVision))
            .map(PotionEffect::getDuration)
            .orElse(0);

        cir.setReturnValue(i > FADE_TICKS ? BRIGHTNESS : i * FADE_RATE);
    }
}
