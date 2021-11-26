package com.baidu.hugegraph.logger;

import java.util.Map;
import java.util.HashMap;

import javax.inject.Singleton;

@Singleton
public class HugeGraphLoggerFactory {
    private static final Map<String, HugeGraphLogger> loggerMap = new HashMap<>();

    public HugeGraphLoggerFactory() {}

    public static HugeGraphLogger getLogger(String name) {
        return loggerMap.computeIfAbsent(name, v -> new HugeGraphLogger(name));
    }

    public static HugeGraphLogger getLogger(Class<?> clazz) {
        return loggerMap.computeIfAbsent(clazz.getName(), v -> new HugeGraphLogger(clazz.getName()));
    }
}
