/*
 * Copyright 2017 HugeGraph Authors
 *
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements. See the NOTICE file distributed with this
 * work for additional information regarding copyright ownership. The ASF
 * licenses this file to You under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations
 * under the License.
 */
package com.baidu.hugegraph.logger;

import javax.inject.Singleton;
import java.util.HashMap;
import java.util.Map;

/**
 * MethodLoggerFactory to manage all the Method Logger instances
 * @since 2021-11-26
 */
@Singleton
public class MethodLoggerFactory {

    private static final Map<String,
            MethodLogger<? extends GraphLogLevel>> TRACE_LOGGER_MAP
            = new HashMap<>();

    private static final Map<String,
            MethodLogger<? extends GraphLogLevel>> DEBUG_LOGGER_MAP
            = new HashMap<>();

    private static final Map<String,
            MethodLogger<? extends GraphLogLevel>> INFO_LOGGER_MAP
            = new HashMap<>();

    private static final Map<String,
            MethodLogger<? extends GraphLogLevel>> WARN_LOGGER_MAP
            = new HashMap<>();

    private static final Map<String,
            MethodLogger<? extends GraphLogLevel>> ERROR_LOGGER_MAP
            = new HashMap<>();


    /**
     * Method level template logger.
     * For example:
     * class MyClass {
     *      private static final MethodLogger<?> LOGGER
     *      = MethodLoggerFactory
     *          .getMethodLogger(MyClass.class, MethodLogger.LevelInfo.class);
     *
     *      // usage
     *      public void foo() {
     *          LogTemplate template = LogTemplate.ACCESS_LOG;
     *          // assume we have various args here
     *          LOGGER.generalLogMessage(template, arg1, arg2, arg3);
     *      }
     * }
     * In HugeGraph, there is a HugeGraphLogger that invoke the MethodLogger
     * by selecting proper level
     * @param level logger level
     * @param clazz Caller class type
     * @param <T> Logger's level type
     * @return Typed Method logger
     */
    @SuppressWarnings("unchecked")
    public static <T extends GraphLogLevel> MethodLogger<T>
        getMethodLogger(Class<T> level, Class<?> clazz) {
        // select proper logger
        MethodLogger<T> tMethodLogger = null;
        if (level.equals(MethodLogger.LevelInfo.class)) {
            tMethodLogger = (MethodLogger<T>) INFO_LOGGER_MAP
                    .computeIfAbsent(
                            clazz.getName(),
                            v -> new MethodLogger<T>(
                                    level, clazz));
        } else if (level.equals(MethodLogger.LevelDebug.class)) {
            tMethodLogger = (MethodLogger<T>) DEBUG_LOGGER_MAP
                    .computeIfAbsent(
                            clazz.getName(),
                            v -> new MethodLogger<T>(
                                    level, clazz));
        } else if (level.equals(MethodLogger.LevelError.class)) {
            tMethodLogger = (MethodLogger<T>) ERROR_LOGGER_MAP
                    .computeIfAbsent(
                            clazz.getName(),
                            v -> new MethodLogger<T>(
                                    level, clazz));
        } else if (level.equals(MethodLogger.LevelWarn.class)) {
            tMethodLogger = (MethodLogger<T>) WARN_LOGGER_MAP
                    .computeIfAbsent(
                            clazz.getName(),
                            v -> new MethodLogger<T>(
                                    level, clazz));
        } else if (level.equals(MethodLogger.LevelTrace.class)) {
            tMethodLogger = (MethodLogger<T>) TRACE_LOGGER_MAP
                    .computeIfAbsent(
                            clazz.getName(),
                            v -> new MethodLogger<T>(
                                    level, clazz));
        } else {
            tMethodLogger = (MethodLogger<T>) INFO_LOGGER_MAP
                    .computeIfAbsent(
                            clazz.getName(),
                            v -> new MethodLogger<T>(
                                    (Class<T>)(MethodLogger.LevelInfo.class),
                                    clazz));
        }
        return tMethodLogger;
    }
}
