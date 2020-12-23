package net.permutated;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod(FlickerFix.MOD_ID)
public class FlickerFix {
    public static final String MOD_ID = "flickerfix";

    // Directly reference a log4j logger.
    private static final Logger LOGGER = LogManager.getLogger();

    //TODO move to config file
    public static final int fadeTicks = 20;
    public static final float brightness = 1.0F;
    public static final float fadeRate = brightness / fadeTicks;

    public FlickerFix() {
        // Register ourselves for server and other game events we are interested in
        MinecraftForge.EVENT_BUS.register(this);
    }
}
