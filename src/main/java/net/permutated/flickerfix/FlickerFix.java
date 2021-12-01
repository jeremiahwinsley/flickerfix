package net.permutated.flickerfix;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.ExtensionPoint;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.network.FMLNetworkConstants;
import org.apache.commons.lang3.tuple.Pair;
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

    public FlickerFix() {
        // Register ourselves for server and other game events we are interested in
        MinecraftForge.EVENT_BUS.register(this);

        ModLoadingContext.get().registerExtensionPoint(ExtensionPoint.DISPLAYTEST,
            () -> Pair.of(() -> FMLNetworkConstants.IGNORESERVERONLY, (a, b) -> true));
    }
}
