package net.permutated.flickerfix;

import net.minecraftforge.fml.IExtensionPoint;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.network.NetworkConstants;
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
        ModLoadingContext.get().registerExtensionPoint(IExtensionPoint.DisplayTest.class,
            () -> new IExtensionPoint.DisplayTest(() -> NetworkConstants.IGNORESERVERONLY, (remote, isServer) -> true));
    }
}
