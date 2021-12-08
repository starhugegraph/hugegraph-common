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
    ACCESS_LOG("ACCESS_LOG",
            "{} /{} Status: {} - user: {} {} - roles: {} in {} ms"),
    START_REST_SERVER("START_REST_SERVER", "restServer has been initialized!"),
    IMPORT_VERTEX("IMPORT_VERTEX", "Import vertex {}");
    ;
    private final String name;
    private final String content;
    private final Integer threshold;

    LogTemplate(String name, String content) {
        this.name = name;
        this.content = content;
        this.threshold = 0;
    }

    LogTemplate(String name, String content, Integer threshold) {
        this.name = name;
        this.content = content;
        this.threshold = threshold;
    }

    private static final Map<String, LogTemplate> TEMPLATE_MAP
            = new HashMap<>();
    static {
        for (LogTemplate template : LogTemplate.values()) {
            TEMPLATE_MAP.computeIfAbsent(template.name, v -> template);
        }
    }

    public static LogTemplate getByName(String name) {
        return TEMPLATE_MAP.getOrDefault(name, LogTemplate.UNKNOWN);
    }

    public String getContent() {
        return this.content;
    }

    public Integer getThreshold() { return this.threshold; }
}
