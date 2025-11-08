# Chunk Optimizer Mod for Minecraft 1.20.1 Forge

## 概述
这是一个专门优化Minecraft 1.20.1 Forge版本区块加载性能的模组，解决区块加载慢和卡顿问题。

## 特性
- **异步区块加载**: 将区块加载操作移到后台线程，减少主线程卡顿
- **可控并发加载**: 限制同时加载的区块数量，防止资源竞争
- **邻居区块预加载**: 自动预加载相邻区块，防止级联加载导致的卡顿
- **队列处理系统**: 使用队列控制加载节奏，避免瞬时高负载
- **完全可配置**: 所有参数都可通过配置文件调整

## 安装方法
1. 构建模组：
   ```bash
   cd ChunkOptimizerMod
   ./gradlew build
   ```
   生成的JAR文件在 `build/libs/` 目录中

2. 安装使用：
   - 将生成的JAR文件放入Minecraft的 `mods` 文件夹
   - 启动Minecraft 1.20.1 Forge版本

## 配置选项
游戏启动后会在 `config/chunkoptimizer-common.toml` 生成配置文件，可调整以下参数：

- `maxConcurrentLoads`: 最大并发加载数量 (1-8，默认2)
- `queueSizeLimit`: 队列大小限制 (10-100，默认20)
- `processInterval`: 处理间隔毫秒 (10-500，默认50)
- `preloadNeighbors`: 是否预加载邻居区块 (默认true)
- `enableDataCaching`: 启用数据缓存 (默认true)
- `enableDebugLogging`: 启用调试日志 (默认false)

## 技术实现
- 使用Java并发库实现线程安全
- 基于Forge事件系统监听区块加载和游戏刻
- 支持动态配置重载
- 完整的日志记录和错误处理

## 故障排除
如果遇到问题：
1. 检查Minecraft日志中的错误信息
2. 尝试降低 `maxConcurrentLoads` 值
3. 启用调试日志查看详细运行信息
4. 确保使用兼容的Forge版本 (47.1.0+)

## 许可证
MIT License
