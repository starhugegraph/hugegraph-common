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

    CRITICAL_ERROR(
        "CRITICAL_ERROR",
        "Critical error captured! {}, addition info {}"),
    DEBUG_LOG(
        "DEBUG_LOG",
        "General Debug Log: executor: {}, info: {}, context {}"),
    
    /**** Hugegraph server logs ****/
    SERVER_DOWN(
        "SERVER_DOWN",
        "[SERVER] Hugegraph Server Down!"),
    START_REST_SERVER(
        "START_REST_SERVER",
        "[SERVER] restServer has been initialized!"),
    COMMIT_FAILED(
        "COMMIT_FAILED", "[SERVER] Failed to commit"),
    ROLLBACK_FAILED(
        "ROLLBACK_FAILED", "[SERVER] Failed to rollback"),  
    AUTH_PROXY_INIT(
        "AUTH_PROXY_INIT",
        "[SERVER] Wrap graph '{}' with HugeGraphAuthProxy" +
        " with log rate limit {}"),
    VERIFY_RES_PERM(
        "VERIFY_RES_PERM",
        "[SERVER] User '{}' is {} to {} {}"),
    VALIDATE_USER_FAILED(
        "VALIDATE_USER_FAILED",
        "[SERVER] Failed to validate user {} with error: "),
    VALIDATE_TOKEN_FAILED(
        "VALIDATE_TOKEN_FAILED",
        "[SERVER] Failed to validate token with error: "),

    /**** HugeGraph core related logs ****/
    CREATE_GRAPH(
        "CREATE_GRAPH",
        "[SERVER] Create graph [{}] with config option '{}'"),
    REMOVE_GRAPH(
        "REMOVE_Graph",
        "[SERVER] Remove graph by name {}"),
    CLEAR_GRAPH(
        "CLEAR_GRAPH",
        "[SERVER] Clear graph by name {}"),
    MANAGE_GRAPH(
        "MANAGE_GRAPH",
        "[SERVER] Manage graphs with {}"),
    
    CREATE_SNAPSHOT(
        "CREATE_SNAPSHOT",
        "[SERVER] Create snapshot for graph {}"),
    RESUME_SNAPSHOT(
        "RESUME_SNAPSHOT",
        "[SERVER] Resume snapshot for graph {}"),
    
    COMPACT_GRAPH(
        "COMPACT_GRAPH",
        "[SERVER] Manually compact graph {}"),
    FLUSH_GRAPH(
        "FLUSH_GRAPH",
        "[SERVER] Manually flush graph {}"),

    CREATE_ACCESS(
        "CREATE_ACCESS",
        "[SERVER] Graph [{}] create access: {}"),
    UPDATE_ACCESS(
        "UPDATE_ACCESS",
        "[SERVER] Graph [{}] update access: {}"),
    DELETE_ACCESS(
        "DELETE_ACCESS",
        "[SERVER] Graph [{}] delete access: {}"),

    CREATE_BELONG(
        "CREATE_BELONG",
        "[SERVER] Graph [{}] create belong: {}"),
    UPDATE_BELONG(
        "UPDATE_BELONG",
        "[SERVER] Graph [{}] update belong: {}"),
    DELETE_BELONG(
        "DELETE_BELONG",
        "[SERVER] Graph [{}] delete belong: {}"),


    CREATE_PROJECT(
        "CREATE_PROJECT",
        "[SERVER] Graph [{}] create project: {}"),
    UPDATE_PROJECT(
        "UPDATE_PROJECT",
        "[SERVER] Graph [{}] update project: {}"),
    DELETE_PROJECT(
        "DELETE_PROJECT",
        "[SERVER] Graph [{}] delete project: {}"),

    CREATE_TARGET(
        "CREATE_TARGET",
        "[SERVER] Graph [{}] create target: {}"),
    UPDATE_TARGET(
        "UPDATE_TARGET",
        "[SERVER] Graph [{}] update target: {}"),
    DELETE_TARGET(
        "DELETE_TARGET",
        "[SERVER] Graph [{}] delete target: {}"),

    CREATE_TASK(
        "CREATE_TASK",
        "[SERVER] Graph [{}] create Task: {}"),
    UPDATE_TASK(
        "UPDATE_TASK",
        "[SERVER] Graph [{}] update task: {}"),
    CANCEL_TASK(
        "CANCEL_TASK",
        "[SERVER] Graph [{}] cancel task: {}"),
    DELETE_TASK(
        "DELETE_TASK",
        "[SERVER] Graph [{}] delete task: {}"),

    CREATE_PROPERTY(
        "CREATE_PROPERTY",
        "[SERVER] Graph [{}] create property key: {}"),
    UPDATE_PROPERTY(
        "UPDATE_PROPERTY",
        "[SERVER] Graph [{}] {} update property key: {}"),
    DELETE_PROPERTY(
        "DELETE_PROPERTY",
        "[SERVER] Graph [{}] delete property key: {}"),


    /**** Client related logs　 ****/
    REST_CLIENT_ACCESS(
        "REST_CLIENT_ACCESS",
        ""),

    /**** User related logs ****/

    /* User Management */
    CREATE_USER("CREATE_USER", "[AUDIT] New user {} has been created by {}"),
    UPDATE_USER("UPDATE_USER", "[AUDIT] User {} has been updated by {}"),
    DELETE_USER("DELETE_USER", "[AUDIT] User {} has been deleted by {}"),

    /* Group Management */
    CREATE_GROUP(
        "CREATE_GROUP",
        "[AUDIT] New group {} has been created by {}"),
    UPDATE_GROUP(
        "UPDATE_GROUP",
        "[AUDIT] Group {} has been updated by {}"),
    DELETE_GROUP(
        "DELETE_GROUP",
        "[AUDIT] Group {} has been deleted by {}"),

    /* Role Management */
    CREATE_ROLE("CREATE_ROLE", "[AUDIT] New role {} has been created by {}"),
    UPDATE_ROLE("UPDATE_ROLE", "[AUDIT] Role {} has been updated {}"),
    DELETE_ROLE("DELETE_ROLE", "[AUDIT] Role {} has been deleted {}"),
    CREATE_REF_ROLE(
        "CREATE_REF_ROLE", "[AUDIT] Ref role {} has been created, link to {}"),
    UPDATE_REF_ROLE("UPDATE_REF_ROLE", "[AUDIT] Ref role {} has been updated"),
    DELETE_REF_ROLE("DELETE_REF_ROLE", "[AUDIT] Ref role {} has been deleted"),
    EXPORT_ROLE("EXPORT_ROLE", "[AUDIT] Role {} info has been exported by {}"),

    /* Password Management */
    UPDATE_PASSWORD("UPDATE_PASSWORD", "[AUDIT] User {} has changed password"),
    RESET_PASSWORD("RESET_PASSWORD", "[AUDIT] User {} has reset password"),

    /* Authorization Management */
    USER_LOGIN(
        "USER_LOGIN",
        "[AUDIT] User {} has been logged in via {} with path {}"),
    USER_LOGOUT("USER_LOGOUT", "[AUDIT] User {} has been logged out"),
    USER_DISPOSE("USER_DISPOSE", "[AUDIT] User {} has been disposed by {}"),
    USER_LOCK("USER_LOCK", "[AUDIT] User {} has been locked by {}"),
    USER_UNLOCK("USER_UNLOCK", "[AUDIT] User {} has been unlocked by {}"),
    USER_ACCESS_DENIED(
        "USER_ACCESS_DENIED",
        "[AUDIT] User {} access {} to {} has been denied"),
    GENERATE_AUTH_KEY(
        "GENERATE_AUTH_KEY",
        "[AUDIT] User {} has generated a new auth key"),

    /* User Group Management */
    CREATE_USER_GROUP(
        "CREATE_USER_GROUP",
        "[AUDIT] New user group {} has been created by {}"),
    UPDATE_USER_GROUP(
        "UPDATE_USER_GROUP",
        "[AUDIT] User group {} has been updated by {}"),
    DELETE_USER_GROUP(
        "DELETE_USER_GROUP",
        "[AUDIT] User group {} has been deleted by {}"),

    /**** Tenant related logs ****/
    /* Tenant management */
    UPDATE_TENANT_CONFIG(
        "UPDATE_TENANT_CONFIG",
        "[AUDIT] Tenant {} config has been updated"),
    CREATE_TENANT(
        "CREATE_TENANT",
        "[AUDIT] Tenant {} has been created by {}"),
    UPDATE_TENANT(
        "UPDATE_TENANT",
        "[AUDIT] Tenant {} has been updated by {}"),
    REMOVE_TENANT(
        "REMOVE_TENANT",
        "[AUDIT] Tenant {} has been removed by {}"),

    /**** Cluster related logs ****/
    SYNC_CLUSTER_CONFIG(
        "SYNC_CLUSTER_CONFIG",
        "[AUDIT] Cluster {} config sync"),
    SYNC_OPS_COMMAND(
        "SYNC_OPS_COMMAND",
        "[AUDIT] Process synchronize ops command {} by {}"),
    ASYNC_OPS_COMMAND(
        "ASYNC_OPS_COMMAND",
        "[AUDIT] Process a-synchronize ops command {} by {}"),
    IMPORT_CERT_LICENSE(
        "IMPORT_CERT_LICENSE",
        "[AUDIT] Import certification license {} by {}"),

    /**** Service related logs ****/
    ADD_SERVICE(
        "ADD_SERVICE",
        "[AUDIT] Service {} has been added on instance {}"),
    REMOVE_SERVICE(
        "REMOVE_SERVICE",
        "[AUDIT] Service {} has been removed on instance {}"),
    START_SERVICE(
        "START_SERVICE",
        "[AUDIT] Service {} has been started"),
    STOP_SERVICE(
        "STOP_SERVICE",
        "[AUDIT] Service {} has been stopped"),
    RESTART_SERVICE(
        "RESTART_SERVICE",
        "[AUDIT] Service {} has been restarted"),
    SYNC_SERVICE_CONFIG(
        "SYNC_SERVICE_CONFIG",
        "[AUDIT] Service {} config has been synchronized"),
    EXPORT_SERVICE_LOG(
        "EXPORT_SERVICE_LOG",
        "[AUDIT] Service {} log has been exported by {}"),
    SERVICE_HEALTH_CHECK_START(
        "SERVICE_HEALTH_CHECK_START",
        "[AUDIT] Service {} health check start..."),
    SERVICE_HEALTH_CHECK_RESULT(
        "SERVICE_HEALTH_CHECK_RESULT",
        "[AUDIT] Service {} health check done, result is {}"),

    /**** Instance related logs ****/
    CREATE_INSTANCE("CREATE_INSTANCE", "[AUDIT] Instance {} is created by {}"),
    DELETE_INSTANCE("DELETE_INSTANCE", "[AUDIT] Instance {} is deleted by {}"),
    START_INSTANCE("START_INSTANCE", "[AUDIT] Instance {} is started {}"),
    STOP_INSTANCE("STOP_INSTANCE", "[AUDIT] Instance {} is stopped {}"),
    RESTART_INSTANCE(
        "RESTART_INSTANCE",
        "[AUDIT] Instance {} is restarted by {}"),
    SYNC_INSTANCE_CONFIG(
        "SYNC_INSTANCE_CONFIG",
        "[AUDIT] Instance {} config has been synchronized by {}"),
    INSTANCE_PROVIDE_SERVICE(
        "INSTANCE_PROVIDE_SERVICE",
        "[AUDIT] Instance {} starts to provide service {}"),
    INSTANCE_WITHDRAW_SERVICE(
        "INSTANCE_WITHDRAW_SERVICE",
        "[AUDIT] Instance {} withdraws service {}"),
    EXPORT_INSTANCE_LOG(
        "EXPORT_INSTANCE_LOG",
        "[AUDIT] Instance {} log has been exported"),

    /**** Host related logs ****/

    /**** Operation logs ****/
    
    /**** Hugegraph data logs ****/
    IMPORT_VERTEX(
        "IMPORT_VERTEX", "[AUDIT] Import vertex {} to database {}"),
    IMPORT_EDGE(
        "IMPORT_EDGE", "[AUDIT] Import edge {} to database {}"),

    /**** Hugegraph compute logs ****/

    /**** Hugegraph common logs ****/
    PAUSABLE_THREAD_PAUSED(
        "PAUSABLE_THREAD_PAUSED",
        "[COMMON] PausableScheduledThreadPool was paused"),
    PAUSABLE_THREAD_RESUMED(
        "PAUSABLE_THREAD_RESUMED",
        "[COMMON] PausableScheduledThreadPool was resumed"),
    PAUSABLE_THREAD_INTERRUPTED(
        "PAUSABLE_THREAD_INTERRUPTED",
        "[COMMON] PausableScheduledThreadPool was interrupted"),
    WASTE_TIME_COST(
        "WASTE_TIME_COST",
        "[COMMON] Wasted time test: cost={}ms, base_cost={}, {}={}ns"),
    REDUNDANT_CONFIG_OPTION(
        "REDUNDANT_CONFIG_OPTION",
        "[COMMON] The config option '{}' is redundant, " +
        "please ensure it has been registered"),
    NO_STATIC_METHOD(
        "NO_STATIC_METHOD",
        "[COMMON] Class {} does not has static method {}."),
    CANNOT_CALL_METHOD(
        "CANNOT_CALL_METHOD",
        "[COMMON] Can't call static method {} from class {}."),
    ILLEGAL_ACCESS(
        "ILLEGAL_ACCESS",
        "[COMMON] Illegal access while calling method {} from class {}."),
    ALREADY_REGISTERED(
        "ALREADY_REGISTERED",
        "[COMMON] Already registered option holder: {} ({})"),
    REGISTER_OPTION_FAILED(
        "REGISTER_OPTION_FAILED",
        "[COMMON] Failed to register option: {}"),
    INVALID_OPTION_TYPE(
        "INVALID_OPTION_TYPE",
        "[COMMON] Invalid type of value '{}' for option '{}'"),
    HANDLE_EVENT_FAILED(
        "HANDLE_EVENT_FAILED",
        "[COMMON] Failed to handle event {}"),
    CLOSE_STREAM_FAILED(
        "CLOSE_STREAM_FAILED",
        "[COMMON] Failed to close stream"),

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
