package net.permutated.flickerfix.mixin;

import net.permutated.flickerfix.FlickerFix;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;

import java.util.Optional;

@SuppressWarnings({"java:S1118", "java:S1610"})
@Mixin(GameRenderer.class)
public abstract class MixinGameRenderer {

    @Overwrite
    public static float getNightVisionScale(LivingEntity livingEntityIn, float entitylivingbaseIn) {
        int i = Optional.ofNullable(livingEntityIn.getEffect(MobEffects.NIGHT_VISION))
            .map(MobEffectInstance::getDuration).orElse(0);
        return i > FlickerFix.fadeTicks ? FlickerFix.brightness : i * FlickerFix.fadeRate;
    }
}
