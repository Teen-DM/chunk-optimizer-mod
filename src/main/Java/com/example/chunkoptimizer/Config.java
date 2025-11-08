package com.example.chunkoptimizer;

import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber
public class Config {
    public static final ForgeConfigSpec.Builder BUILDER = new ForgeConfigSpec.Builder();
    public static final ForgeConfigSpec SPEC;

    public static final ForgeConfigSpec.IntValue MAX_CONCURRENT_LOADS;
    public static final ForgeConfigSpec.IntValue QUEUE_SIZE_LIMIT;
    public static final ForgeConfigSpec.LongValue PROCESS_INTERVAL;
    public static final ForgeConfigSpec.BooleanValue PRELOAD_NEIGHBORS;
    public static final ForgeConfigSpec.BooleanValue ENABLE_DATA_CACHING;
    public static final ForgeConfigSpec.BooleanValue ENABLE_DEBUG_LOGGING;

    static {
        BUILDER.push("Chunk Load Optimization Settings");

        MAX_CONCURRENT_LOADS = BUILDER
            .comment("Maximum number of chunks to load concurrently (default: 2, range: 1-8)")
            .defineInRange("maxConcurrentLoads", 2, 1, 8);

        QUEUE_SIZE_LIMIT = BUILDER
            .comment("Maximum size of the chunk load queue (default: 20, range: 10-100)")
            .defineInRange("queueSizeLimit", 20, 10, 100);

        PROCESS_INTERVAL = BUILDER
            .comment("Interval between processing chunks in milliseconds (default: 50, range: 10-500)")
            .defineInRange("processInterval", 50L, 10L, 500L);

        PRELOAD_NEIGHBORS = BUILDER
            .comment("Whether to pre-load neighboring chunks (default: true)")
            .define("preloadNeighbors", true);

        ENABLE_DATA_CACHING = BUILDER
            .comment("Enable chunk data caching for faster access (default: true)")
            .define("enableDataCaching", true);

        ENABLE_DEBUG_LOGGING = BUILDER
            .comment("Enable debug logging for troubleshooting (default: false)")
            .define("enableDebugLogging", false);

        BUILDER.pop();
        SPEC = BUILDER.build();
    }
}
