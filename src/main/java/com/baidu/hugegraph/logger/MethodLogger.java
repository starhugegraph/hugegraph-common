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

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.function.Function;

/**
 * MethodLogger is to apply log on method level for each scenario
 * @param <T>
 */
public class MethodLogger<T extends GraphLogLevel> {

    public static class LevelTrace implements GraphLogLevel { }
    public static class LevelDebug implements GraphLogLevel { }
    public static class LevelInfo implements GraphLogLevel { }
    public static class LevelWarn implements GraphLogLevel { }
    public static class LevelError implements GraphLogLevel { }

    private final Function<String, Function<Object[], Void>> processor;

    /**
     * Initialize logger by Type;
     * @param type type of MethodLogger
     * @param clazz caller's clazz
     */
    public MethodLogger(Class<T> type, Class<?> clazz) {
        // Invoke slf4j logger
        Logger logger = LoggerFactory.getLogger(clazz);

        // Recognize actual type of current logger instance
        if (type.equals(LevelInfo.class)) {
            processor = (String s) -> ((Object... args) -> {
                logger.info(s, args);
                return null;
            });
        } else if (type.equals(LevelDebug.class)) {
            processor = (String s) -> ((Object... args) -> {
                logger.debug(s, args);
                return null;
            });
        } else if (type.equals(LevelError.class)) {
            processor = (String s) -> ((Object... args) -> {
                logger.error(s, args);
                return null;
            });
        } else if (type.equals(LevelWarn.class)) {
            processor = (String s) -> ((Object... args) -> {
                logger.warn(s, args);
                return null;
            });
        } else if (type.equals(LevelTrace.class)) {
            processor = (String s) -> ((Object... args) -> {
                logger.trace(s, args);
                return null;
            });
        } else {
            logger.info(
                    "Fall into default type, actual type: {}, type of info: {}",
                    type,
                    LevelInfo.class
            );
            processor = (String s) -> ((Object... args) -> {
                logger.info(s, args);
                return null;
            });
        }
    }

    /**
     * Generalized log entry
     * @param template Instance of LogTemplate
     * @param args Corresponding objects that the template applied
     */
    public void generalLogMessage(LogTemplate template, Object ...args) {
        processor.apply(template.getContent()).apply(args);
    }
}
