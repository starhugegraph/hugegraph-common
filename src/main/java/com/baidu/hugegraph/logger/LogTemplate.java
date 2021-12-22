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

    /* General logs */
    UNKNOWN("UNKNOWN", ""),
    START_REST_SERVER(
        "START_REST_SERVER",
        "restServer has been initialized!"),
    SERVER_DOWN("SERVER_DOWN", "Hugegraph Server Down!"),
    CRITICAL_ERROR(
        "CRITICAL_ERROR",
        "Critical error captured! {}, addition info {}"),
    DEBUG_LOG(
        "DEBUG_LOG",
        "General Debug Log: executor: {}, info: {}, context {}"),


    /**** User related logs ****/

    /* User Management */
    CREATE_USER("CREATE_USER", "New user {} has been created by {}"),
    UPDATE_USER("UPDATE_USER", "User {} has been updated by {}"),
    DELETE_USER("DELETE_USER", "User {} has been deleted by {}"),

    /* Group Management */
    CREATE_GROUP("CREATE_GROUP", "New group {} has been created by {}"),
    UPDATE_GROUP("UPDATE_GROUP", "Group {} has been updated by {}"),
    DELETE_GROUP("DELETE_GROUP", "Group {} has been deleted by {}"),

    /* Role Management */
    CREATE_ROLE("CREATE_ROLE", "New role {} has been created by {}"),
    UPDATE_ROLE("UPDATE_ROLE", "Role {} has been updated {}"),
    DELETE_ROLE("DELETE_ROLE", "Role {} has been deleted {}"),
    CREATE_REF_ROLE(
        "CREATE_REF_ROLE", "Ref role {} has been created, link to {}"),
    UPDATE_REF_ROLE("UPDATE_REF_ROLE", "Ref role {} has been updated"),
    DELETE_REF_ROLE("DELETE_REF_ROLE", "Ref role {} has been deleted"),
    EXPORT_ROLE("EXPORT_ROLE", "Role {} info has been exported by {}"),

    /* Password Management */
    UPDATE_PASSWORD("UPDATE_PASSWORD", "User {} has changed password"),
    RESET_PASSWORD("RESET_PASSWORD", "User {} has reset password"),

    /* Authorization Management */
    USER_LOGIN("USER_LOGIN", "User {} has been logged in via {}"),
    USER_LOGOUT("USER_LOGOUT", "User {} has been logged out"),
    USER_DISPOSE("USER_DISPOSE", "User {} has been disposed by {}"),
    USER_LOCK("USER_LOCK", "User {} has been locked by {}"),
    USER_UNLOCK("USER_UNLOCK", "User {} has been unlocked by {}"),
    GENERATE_AUTH_KEY(
        "GENERATE_AUTH_KEY", "User {} has generated a new auth key"),

    /* User Group Management */
    CREATE_USER_GROUP(
        "CREATE_USER_GROUP", "New user group {} has been created by {}"),
    UPDATE_USER_GROUP(
        "UPDATE_USER_GROUP", "User group {} has been updated by {}"),
    DELETE_USER_GROUP(
        "DELETE_USER_GROUP", "User group {} has been deleted by {}"),

    /**** Tenant related logs ****/
    /* Tenant management */
    UPDATE_TENANT_CONFIG(
        "UPDATE_TENANT_CONFIG",
        "Tenant {} config has been updated"),
    CREATE_TENANT(
        "CREATE_TENANT", "Tenant {} has been created by {}"),
    UPDATE_TENANT(
        "UPDATE_TENANT", "Tenant {} has been updated by {}"),
    REMOVE_TENANT(
        "REMOVE_TENANT", "Tenant {} has been removed by {}"),

    /**** Cluster related logs ****/
    SYNC_CLUSTER_CONFIG(
        "SYNC_CLUSTER_CONFIG", "Cluster {} config sync"),
    SYNC_OPS_COMMAND(
        "SYNC_OPS_COMMAND", "Process synchronize ops command {} by {}"),
    ASYNC_OPS_COMMAND(
        "ASYNC_OPS_COMMAND", "Process a-synchronize ops command {} by {}"),
    IMPORT_CERT_LICENSE(
        "IMPORT_CERT_LICENSE", "Import cert license {} by {}"),

    /**** Service related logs ****/
    ADD_SERVICE(
        "ADD_SERVICE", "Service {} has been added on instance {}"),
    REMOVE_SERVICE(
        "REMOVE_SERVICE", "Service {} has been removed on instance {}"),
    START_SERVICE(
        "START_SERVICE", "Service {} has been started"),
    STOP_SERVICE(
        "STOP_SERVICE", "Service {} has been stopped"),
    RESTART_SERVICE(
        "RESTART_SERVICE", "Service {} has been restarted"),
    SYNC_SERVICE_CONFIG(
        "SYNC_SERVICE_CONFIG", "Service {} config has been synchronized"),
    EXPORT_SERVICE_LOG(
        "EXPORT_SERVICE_LOG",
        "Service {} log has been exported by {}"),
    SERVICE_HEALTH_CHECK_START(
        "SERVICE_HEALTH_CHECK_START",
        "Service {} health check start..."),
    SERVICE_HEALTH_CHECK_RESULT(
        "SERVICE_HEALTH_CHECK_RESULT",
        "Service {} health check done, result is {}"),

    /**** Instance related logs ****/
    CREATE_INSTANCE("CREATE_INSTANCE", "Instance {} is created by {}"),
    DELETE_INSTANCE("DELETE_INSTANCE", "Instance {} is deleted by {}"),
    START_INSTANCE("START_INSTANCE", "Instance {} is started {}"),
    STOP_INSTANCE("STOP_INSTANCE", "Instance {} is stopped {}"),
    RESTART_INSTANCE("RESTART_INSTANCE", "Instance {} is restarted by {}"),
    SYNC_INSTANCE_CONFIG(
        "SYNC_INSTANCE_CONFIG",
        "Instance {} config has been synchronized by {}"),
    INSTANCE_PROVIDE_SERVICE(
        "INSTANCE_PROVIDE_SERVICE",
        "Instance {} starts to provide service {}"),
    INSTANCE_WITHDRAW_SERVICE(
        "INSTANCE_WITHDRAW_SERVICE",
        "Instance {} withdraws service {}"),
    EXPORT_INSTANCE_LOG(
        "EXPORT_INSTANCE_LOG",
        "Instance {} log has been exported"),

    /**** Host related logs ****/

    /**** Operation logs ****/
    
    /**** Hugegraph data logs ****/
    IMPORT_VERTEX("IMPORT_VERTEX", "Import vertex {} to database {}"),
    IMPORT_EDGE("IMPORT_EDGE", "Import edge {} to database {}"),

    /**** Hugegraph compute logs ****/

    /**** Hugegraph common logs ****/
    PAUSABLE_THREAD_PAUSED(
        "PAUSABLE_THREAD_PAUSED",
        "PausableScheduledThreadPool was paused"),
    PAUSABLE_THREAD_RESUMED(
        "PAUSABLE_THREAD_RESUMED",
        "PausableScheduledThreadPool was resumed"),
    PAUSABLE_THREAD_INTERRUPTED(
        "PAUSABLE_THREAD_INTERRUPTED",
        "PausableScheduledThreadPool was interrupted"),
    WASTE_TIME_COST(
        "WASTE_TIME_COST",
        "Wasted time test: cost={}ms, base_cost={}, {}={}ns"),
    REDUNDANT_CONFIG_OPTION(
        "REDUNDANT_CONFIG_OPTION",
        "The config option '{}' is redundant, " +
        "please ensure it has been registered"),
    NO_STATIC_METHOD(
        "NO_STATIC_METHOD",
        "Class {} does not has static method {}."),
    CANNOT_CALL_METHOD(
        "CANNOT_CALL_METHOD",
        "Can't call static method {} from class {}."),
    ILLEGAL_ACCESS(
        "ILLEGAL_ACCESS",
        "Illegal access while calling method {} from class {}."),
    ALREADY_REGISTERED(
        "ALREADY_REGISTERED",
        "Already registered option holder: {} ({})"),
    

    /**** Restful API access logs ****/
    RESTFUL_ACCESS_LOG("ACCESS_LOG",
    "{} /{} Status: {} - user: {} - roles: {} in {} ms"),

    /**** Accumulation Logs ****/
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

    public Integer getThreshold() {
        return this.threshold;
    }
}
