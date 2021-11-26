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

import java.util.HashMap;
import java.util.Map;

/**
 * LogTemplate is used to generate preset logs
 * @since 2021-11-25
 */
public enum LogTemplate {
    UNKNOWN("UNKNOWN", ""),
    ACCESS_LOG("ACCESS_LOG", "{} {}"),
    START_REST_SERVER("START_REST_SERVER", "restServer has been initialized!"),
    ;
    private String name;
    private String content;

    LogTemplate(String name, String content) {
        this.name = name;
        this.content = content;
    }

    private static final Map<String, LogTemplate> templateMap = new HashMap<>();
    static {
        for (LogTemplate template : LogTemplate.values()) {
            templateMap.computeIfAbsent(template.name, v -> template);
        }
    }

    public static LogTemplate getByName(String name) {
        return templateMap.getOrDefault(name, LogTemplate.UNKNOWN);
    }

    public String getContent() {
        return this.content;
    }
}
