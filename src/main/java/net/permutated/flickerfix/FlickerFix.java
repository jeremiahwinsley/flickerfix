package net.permutated.flickerfix;

import net.neoforged.fml.common.Mod;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod(FlickerFix.MOD_ID)
public class FlickerFix {
    public static final String MOD_ID = "flickerfix";

    // Directly reference a log4j logger.
    public static final Logger LOGGER = LogManager.getLogger(FlickerFix.class);

    //TODO move to config file
    public static final int fadeTicks = 20;
    public static final float brightness = 1.0F;
    public static final float fadeRate = brightness / fadeTicks;

    @SuppressWarnings("java:S1118")
    public FlickerFix() {
        // nothing to do
    }
}
