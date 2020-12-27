# flickerfix
FlickerFix for Forge 1.16.4 - disable nightvision flickering

By default, when the night vision effect goes below 10 seconds, the screen starts flickering.
This mod replaces that behavior with a fast fade-out at 1 second remaining duration.

_This mod is likely to be incompatible with any other mod that provides a Mixin for_ `GameRenderer.getNightVisionBrightness(LivingEntity, float)`.
