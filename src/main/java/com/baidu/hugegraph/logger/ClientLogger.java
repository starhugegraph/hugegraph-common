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
 * Provide client general log methods
 * @author Scorpiour
 * @since 2021-12-27
 */
public class ClientLogger {
    
    private final MethodLogger<MethodLogger.LevelDebug> debugLogger;
    private final MethodLogger<MethodLogger.LevelInfo> infoLogger;

    public ClientLogger(Class<?> clazz) {
        debugLogger = MethodLoggerFactory
        .getMethodLogger(MethodLogger.LevelDebug.class, clazz);

        infoLogger = MethodLoggerFactory
                .getMethodLogger(MethodLogger.LevelInfo.class, clazz);
    }

    void logRestClientAccess(Object ...args) {
        infoLogger
        .generalLogMessage(LogTemplate.REST_CLIENT_ACCESS, args);
    }

    void logClientDebug(String template, Object ...args) {
        debugLogger
        .customLogMessage(template, args);
    }
}
