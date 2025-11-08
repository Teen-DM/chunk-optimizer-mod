package com.example.chunkoptimizer;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod("chunkoptimizer")
public class ChunkOptimizerMod {
    public static final String MOD_ID = "chunkoptimizer";
    private static final Logger LOGGER = LogManager.getLogger();

    public ChunkOptimizerMod() {
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
        
        // Register configuration
        ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, Config.SPEC, "chunkoptimizer-common.toml");
        
        // Register ourselves for server and other game events we are interested in
        MinecraftForge.EVENT_BUS.register(this);
        MinecraftForge.EVENT_BUS.register(ChunkLoadOptimizer.class);
    }

    private void setup(final FMLCommonSetupEvent event) {
        LOGGER.info("Initializing Chunk Optimizer Mod");
        ChunkLoadOptimizer.initialize();
        
        event.enqueueWork(() -> {
            LOGGER.info("Chunk Optimizer Mod setup complete");
        });
    }
}
