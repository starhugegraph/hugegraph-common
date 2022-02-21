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

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import java.util.function.Function;

import com.google.common.collect.Maps;

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
    private final SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");

    private final Logger logger;

    /**
     * Initialize logger by Type;
     * @param type type of MethodLogger
     * @param clazz caller's clazz
     */
    public MethodLogger(Class<T> type, Class<?> clazz) {
        // Invoke slf4j logger
        this.logger = LoggerFactory.getLogger(clazz);

        // Recognize actual type of current logger instance
        if (type.equals(LevelInfo.class)) {
            processor = (String s) -> ((Object... args) -> {
                this.logger.info(s, args);
                return null;
            });
        } else if (type.equals(LevelDebug.class)) {
            processor = (String s) -> ((Object... args) -> {
                this.logger.debug(s, args);
                return null;
            });
        } else if (type.equals(LevelError.class)) {
            processor = (String s) -> ((Object... args) -> {
                this.logger.error(s, args);
                return null;
            });
        } else if (type.equals(LevelWarn.class)) {
            processor = (String s) -> ((Object... args) -> {
                this.logger.warn(s, args);
                return null;
            });
        } else if (type.equals(LevelTrace.class)) {
            processor = (String s) -> ((Object... args) -> {
                this.logger.trace(s, args);
                return null;
            });
        } else {
            this.logger.info(
                    "Fall into default type, actual type: {}, type of info: {}",
                    type,
                    LevelInfo.class
            );
            processor = (String s) -> ((Object... args) -> {
                this.logger.info(s, args);
                return null;
            });
        }
    }

    /**
     * Use custom appender name to make logger
     * @param type level of logger
     * @param targetClazz target class, will be logged in message
     * @param appenderName appender name for log4j2 appender inspect
     * @param serializer serializer use to serialize map to string
     */
    @SuppressWarnings("unchecked")
    public MethodLogger(Class<T> type,
                        Class<?> targetClazz,
                        String appenderName,
                        Function<Map<String, String>, String> serializer) {
        this.logger = LoggerFactory.getLogger(appenderName);
        // Recognize actual type of current logger instance
        if (type.equals(LevelInfo.class)) {
            processor = (String s) -> ((Object... args) -> {
                Map<String, String> data = (Map<String, String>)(args[0]);
                Map<String, String> appended = Maps.newHashMap(data);
                appended.putIfAbsent("audit_target", targetClazz.getName());
                appended.putIfAbsent("audit_datetime", formatter.format(new Date()));
                appended.putIfAbsent("audit_level", "INFO");
                String text = serializer.apply(appended);
                this.logger.info(text);
                return null;
            });
        } else if (type.equals(LevelDebug.class)) {
            processor = (String s) -> ((Object... args) -> {
                Map<String, String> data = (Map<String, String>)(args[0]);
                Map<String, String> appended = Maps.newHashMap(data);
                appended.putIfAbsent("audit_target", targetClazz.getName());
                appended.putIfAbsent("audit_datetime", formatter.format(new Date()));
                appended.putIfAbsent("audit_level", "INFO");
                String text = serializer.apply(appended);
                this.logger.debug(text);
                return null;
            });
        } else if (type.equals(LevelError.class)) {
            processor = (String s) -> ((Object... args) -> {
                Map<String, String> data = (Map<String, String>)(args[0]);
                Map<String, String> appended = Maps.newHashMap(data);
                appended.putIfAbsent("audit_target", targetClazz.getName());
                appended.putIfAbsent("audit_datetime", formatter.format(new Date()));
                appended.putIfAbsent("audit_level", "INFO");
                String text = serializer.apply(appended);
                this.logger.error(text);
                return null;
            });
        } else if (type.equals(LevelWarn.class)) {
            processor = (String s) -> ((Object... args) -> {
                Map<String, String> data = (Map<String, String>)(args[0]);
                Map<String, String> appended = Maps.newHashMap(data);
                appended.putIfAbsent("audit_target", targetClazz.getName());
                appended.putIfAbsent("audit_datetime", formatter.format(new Date()));
                appended.putIfAbsent("audit level", "INFO");
                String text = serializer.apply(appended);
                this.logger.warn(text);
                return null;
            });
        } else if (type.equals(LevelTrace.class)) {
            processor = (String s) -> ((Object... args) -> {
                Map<String, String> data = (Map<String, String>)(args[0]);
                Map<String, String> appended = Maps.newHashMap(data);
                appended.putIfAbsent("audit_target", targetClazz.getName());
                appended.putIfAbsent("audit_datetime", formatter.format(new Date()));
                appended.putIfAbsent("audit_level", "INFO");
                String text = serializer.apply(appended);
                this.logger.trace(text);
                return null;
            });
        } else {
            this.logger.info(
                    "Fall into default type, actual type: {}, type of info: {}",
                    type,
                    LevelInfo.class
            );
            processor = (String s) -> ((Object... args) -> {
                Map<String, String> data = (Map<String, String>)(args[0]);
                Map<String, String> appended = Maps.newHashMap(data);
                appended.putIfAbsent("audit_target", targetClazz.getName());
                appended.putIfAbsent("audit_datetime", formatter.format(new Date()));
                appended.putIfAbsent("audit_level", "INFO");
                String text = serializer.apply(appended);
                this.logger.info(text);
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

    private void innerLogDataMap(Object ...args) {
        processor.apply("").apply(args);
    }

    public void logDataMap(Map<String, String> dataMap) {
        this.innerLogDataMap(dataMap);
    }

    public void customLogMessage(String template, Object ...args) {
        processor.apply(template).apply(args);
    }

    public boolean isDebugEnabled() {
        return logger.isDebugEnabled();
    }
}
