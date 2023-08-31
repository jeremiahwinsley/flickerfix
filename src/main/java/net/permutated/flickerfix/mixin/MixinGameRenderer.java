package net.permutated.flickerfix.mixin;

import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.permutated.flickerfix.FlickerFix;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@SuppressWarnings("java:S1118")
@Mixin(GameRenderer.class)
public abstract class MixinGameRenderer {

    @Inject(method = "getNightVisionScale", at = @At("HEAD"), cancellable = true)
    private static void getNightVisionScale(LivingEntity livingEntityIn, float entitylivingbaseIn, CallbackInfoReturnable<Float> cir) {
        MobEffectInstance instance = livingEntityIn.getEffect(MobEffects.NIGHT_VISION);
        if (instance != null && !instance.isInfiniteDuration()) {
            int i = instance.getDuration();
            cir.setReturnValue(i > FlickerFix.fadeTicks ? FlickerFix.brightness : i * FlickerFix.fadeRate);
        }
    }
}
