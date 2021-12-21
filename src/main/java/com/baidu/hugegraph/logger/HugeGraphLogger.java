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

/**
 * Encapsulation class of typed method loggers and corresponding templates
 */
public class HugeGraphLogger {

    private final Class<?> targetType;

    private final MethodLogger<MethodLogger.LevelTrace> traceLogger;
    private final MethodLogger<MethodLogger.LevelDebug> debugLogger;
    private final MethodLogger<MethodLogger.LevelInfo> infoLogger;
    private final MethodLogger<MethodLogger.LevelWarn> warnLogger;
    private final MethodLogger<MethodLogger.LevelError> errorLogger;

    /**
     * Initialize logger with given type
     * @param clazz type of caller class
     */
    public HugeGraphLogger(Class<?> clazz) {

        // which class the logger bind to
        this.targetType = clazz;

        traceLogger = MethodLoggerFactory
                .getMethodLogger(MethodLogger.LevelTrace.class, clazz);

        debugLogger = MethodLoggerFactory
                .getMethodLogger(MethodLogger.LevelDebug.class, clazz);

        infoLogger = MethodLoggerFactory
                .getMethodLogger(MethodLogger.LevelInfo.class, clazz);

        warnLogger = MethodLoggerFactory
                .getMethodLogger(MethodLogger.LevelWarn.class, clazz);

        errorLogger = MethodLoggerFactory
                .getMethodLogger(MethodLogger.LevelError.class, clazz);
    }

    /**
     * Allow alternate level
     * @param level customized level
     * @param template LogTemplate
     * @param args Corresponding args
     * @param <T> Level Type
     */
    public <T extends GraphLogLevel>
        void log(Class<T> level, LogTemplate template, Object ...args) {
        MethodLoggerFactory
                .getMethodLogger(level, this.targetType)
                .generalLogMessage(template, args);
    }

    public void logApiAccess(String method, String url, Long requestTime) {
        infoLogger.generalLogMessage(
                LogTemplate.ACCESS_LOG, method, url, requestTime);
    }

    public void logRestServerStart() {
        infoLogger.generalLogMessage(LogTemplate.START_REST_SERVER);
    }

    public void logServerShutdown() {
        warnLogger.generalLogMessage(
                LogTemplate.SERVER_DOWN);
    }

    public void accumulateVerticesImport(Object ...args) {
        AccumulationLogger.accumulateAccess(this.targetType, LogTemplate.IMPORT_VERTEX, args);
    }

}
