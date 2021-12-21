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

    /* General Log Templates */
    UNKNOWN("UNKNOWN", ""),
    ACCESS_LOG("ACCESS_LOG",
            "{} /{} Status: {} - user: {} {} - roles: {} in {} ms"),
    START_REST_SERVER("START_REST_SERVER", "restServer has been initialized!"),
    SERVER_DOWN("SERVER_DOWN", "Hugegraph Server Down!"),
    IMPORT_VERTEX("IMPORT_VERTEX", "Import vertex {}"),

    /**** User related logs ****/

    /* User Management */
    CREATE_USER("CREATE_USER", "New user has been created"),
    UPDATE_USER("UPDATE_USER", "User has been updated {}"),
    DELETE_USER("DELETE_USER", "User has been deleted {}"),

    /* Group Management */
    CREATE_GROUP("CREATE_GROUP", "New group has been created"),
    UPDATE_GROUP("UPDATE_GROUP", "Group has been updated {}"),
    DELETE_GROUP("DELETE_GROUP", "Group has been deleted {}"),

    /* Role Management */
    CREATE_ROLE("CREATE_ROLE", "New role has been created"),
    UPDATE_ROLE("UPDATE_ROLE", "Role has been updated {}"),
    DELETE_ROLE("DELETE_ROLE", "Role has been deleted {}"),
    CREATE_REF_ROLE("CREATE_REF_ROLE", "R"),
    UPDATE_REF_ROLE("UPDATE_REF_ROLE", ""),
    DELETE_REF_ROLE("DELETE_REF_ROLE", ""),
    EXPORT_ROLE("EXPORT_ROLE", ""),

    /* Password Management */
    UPDATE_PASSWORD("UPDATE_PASSWORD", "User {} has changed password"),
    RESET_PASSWORD("RESET_PASSWORD", "User {} has reset password"),

    /* Authorization Management */
    USER_LOGIN("USER_LOGIN", "User {} has been logged in via {}"),
    USER_LOGOUT("USER_LOGOUT", "User {} has been logged out"),
    USER_DISPOSE("USER_DISPOSE", "User {} has been disposed"),
    USER_LOCK("USER_LOCK", "User {} has been locked"),
    USER_UNLOCK("USER_UNLOCK", "User {} has been unlocked"),
    GENERATE_AUTH_KEY("GENERATE_AUTH_KEY", "User {} has generated new auth key"),

    /* User Group Management */
    CREATE_USER_GROUP("CREATE_USER_GROUP", "New user group has been created"),
    UPDATE_USER_GROUP("UPDATE_USER_GROUP", "User group has been updated {}"),
    DELETE_USER_GROUP("DELETE_USER_GROUP", "User group has been deleted {}"),

    /**** Tenant related logs ****/
    /* Tenant management */
    UPDATE_TENANT_CONFIG("UPDATE_TENANT_CONFIG", "Tenant {} config has been updated"),
    CREATE_TENANT("CREATE_TENANT", "Tenant {} has been created"),
    UPDATE_TENANT("UPDATE_TENANT", "Tenant {} has been updated"),
    REMOVE_TENANT("REMOVE_TENANT", "Tenant {} has been removed"),

    /**** Cluster related logs ****/
    SYNC_CLUSTER_CONFIG("SYNC_CLUSTER_CONFIG", "Cluster {} config sync"),
    SYNC_OPS_COMMAND("SYNC_OPS_COMMAND", "Process synchronize ops command "),
    ASYNC_OPS_COMMAND("ASYNC_OPS_COMMAND", "Process asynchronize ops command"),
    IMPORT_CERT_LICENCE("IMPORT_CERT_LICENCE", "Import cert licence"),

    /**** Service related logs ****/
    ADD_SERVICE("ADD_SERVICE", "Service {} has been added from instance"),
    REMOVE_SERVICE("REMOVE_SERVICE", "Service {} has been removed from instance"),
    START_SERVICE("START_SERVICE", "Service {} has been started"),
    STOP_SERVICE("STOP_SERVICE", "Service {} has been stopped"),
    RESTART_SERVICE("RESTART_SERVICE", "Service {} has been restarted"),
    SYNC_SERVICE_CONFIG("SYNC_SERVICE_CONFIG", "Service {} config has been synchronized"),


    /**** Instance related logs ****/

    /**** Host related logs ****/

    /**** Operation logs ****/


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
