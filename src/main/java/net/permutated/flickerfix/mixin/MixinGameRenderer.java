package net.permutated.flickerfix.mixin;

import net.permutated.flickerfix.FlickerFix;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.entity.LivingEntity;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;

import java.util.Optional;

@Mixin(GameRenderer.class)
public abstract class MixinGameRenderer {

    @Overwrite
    public static float getNightVisionBrightness(LivingEntity livingEntityIn, float entitylivingbaseIn) {
        int i = Optional.ofNullable(livingEntityIn.getActivePotionEffect(Effects.NIGHT_VISION))
            .map(EffectInstance::getDuration).orElse(0);
        return i > FlickerFix.fadeTicks ? FlickerFix.brightness : i * FlickerFix.fadeRate;
    }
}
