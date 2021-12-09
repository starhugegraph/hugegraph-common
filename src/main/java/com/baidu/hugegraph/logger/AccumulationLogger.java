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
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Accumulation Logger is used accumulate the access count of certain template
 * and then flush them to log one time
 */
@Singleton
public class AccumulationLogger {

    private static final Map<String, Integer> logMap = new ConcurrentHashMap<>();

    /**
     * Internal thread pool
     */
    private static final ExecutorService THREAD_POOL
            = Executors.newFixedThreadPool(1);

    public static void accumulateAccess(Class<?> clazz, LogTemplate template, Object ... args) {
        THREAD_POOL.submit(() -> {
            String key = clazz.toString() + template.toString();
            logMap.computeIfAbsent(key, k -> 0);
            Integer current =
                    Optional
                            .ofNullable(logMap.computeIfPresent(key, (k, v) -> v + 1))
                            .orElse(0);
            if (current >= template.getThreshold()) {
                MethodLogger<MethodLogger.LevelInfo> logger
                        = MethodLoggerFactory.getMethodLogger(MethodLogger.LevelInfo.class, clazz);
                logger.generalLogMessage(template, args);
                logMap.remove(key);
            }
        });
    }
}
