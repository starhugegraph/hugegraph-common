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

/**
 * HugeGraphLogger is used to extend slf4j logger using formatted templates
 * @since 2021-11-26
 */
public class HugeGraphLogger  {

    /**
     * slf4j logger with same name
     */
    private final Logger logger;

    private HugeGraphLogger() {
        this.logger = LoggerFactory.getLogger(this.getClass());
    }

    public HugeGraphLogger(String name) {
        this.logger = LoggerFactory.getLogger(name);
    }

    public void trace(LogTemplate template, Object ...args) {
        logger.trace(template.getContent(), args);
    }

    public void debug(LogTemplate template, Object ...args) {
        logger.debug(template.getContent(), args);
    }

    public void info(LogTemplate template, Object ...args) {
        logger.info(template.getContent(), args);
    }

    public void warn(LogTemplate template, Object ...args) {
        logger.warn(template.getContent(), args);
    }

    public void error(LogTemplate template, Object ...args) {
        logger.error(template.getContent(), args);
    }
}
