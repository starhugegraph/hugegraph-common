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

import java.util.Map;

import com.google.common.collect.ImmutableMap;

/**
 * Provide Audit related log methods
 * Compulsory items of audit log:
                        "audit_operation": "", //操作分类
                        "audit_action": "", // 详情
                        "audit_datetime": "", //时间
                        "audit_service": "", // 服务
                        "audit_graphspace": "", // 图空间
                        "audit_graph": "", // 图
                        "audit_level": "", // 安全界别
                        "audit_user": "", // 用户
                        "audit_ip": "", // 用户ip
                        "audit_result": "", // 操作结果
 * 
 * @author Scorpiour
 * @since 2021-12-21
 */
public class AuditLogger {

    private final MethodLogger<MethodLogger.LevelInfo> infoLogger;
    private final MethodLogger<MethodLogger.LevelWarn> warnLogger;

    private static final String AUDIT_LOG_APPENDER_NAME = "audit-log-appender";
    private static final String OPERATION_PATTERN = "audit_operation";
    private static final String ACTION_PATTERN = "audit_action";

    public AuditLogger(Class<?> targetType) {

        infoLogger = MethodLoggerFactory
                .getAuditLogger(
                    MethodLogger.LevelInfo.class,
                    targetType,
                    AUDIT_LOG_APPENDER_NAME);

        warnLogger = MethodLoggerFactory
                .getAuditLogger(
                    MethodLogger.LevelWarn.class,
                    targetType,
                    AUDIT_LOG_APPENDER_NAME);
    }

    
    /**** User related logs ****/
    /**
     * Create new user
     * @param userId
     * @param creatorId
     */
    public void logCreateUser(String userId, String creatorId) {
        Map<String, String> dataMap
            = ImmutableMap.of(
                OPERATION_PATTERN, AuditOperationEnum.USER.name(),
                ACTION_PATTERN, LogTemplate.CREATE_USER.name(),
                "userId", userId,
                "audit_user", creatorId);
        infoLogger
        .logDataMap(dataMap);
    }

    /**
     * Update user
     * @param userId
     * @param executorId
     */
    public void logUpdateUser(String userId, String executorId) {
        Map<String, String> dataMap
            = ImmutableMap.of(
                OPERATION_PATTERN, AuditOperationEnum.USER.name(),
                ACTION_PATTERN, LogTemplate.UPDATE_USER.name(),
                "userId", userId,
                "audit_user", executorId);
        infoLogger
        .logDataMap(dataMap);
    }

    /**
     * Delete user
     * @param userId
     * @param executorId
     */
    public void logDeleteUser(String userId, String executorId) {
        Map<String, String> dataMap
        = ImmutableMap.of(
            OPERATION_PATTERN, AuditOperationEnum.USER.name(),
            ACTION_PATTERN, LogTemplate.DELETE_USER.name(),
            "userId", userId,
            "audit_user", executorId);
        infoLogger
        .logDataMap(dataMap);
    }

    /**
     * Create graph
     * @param graphSpace
     * @param graphName
     * @param executorId
     */
    public void logCreateGraph(
        String graphSpace, String graphName, String executorId) {
        Map<String, String> dataMap
        = ImmutableMap.of(
            OPERATION_PATTERN, AuditOperationEnum.GRAPH.name(),
            ACTION_PATTERN, LogTemplate.CREATE_GRAPH.name(),
            "audit_graph_space", graphSpace,
            "audit_graph", graphName,
            "audit_user", executorId);
        infoLogger
        .logDataMap(dataMap);
    }

    /**
     * Manage graph
     * @param graphSpace
     * @param graphName
     * @param executorId
     */
    public void logUpdateGraph(
        String graphSpace, String graphName, String executorId) {
        Map<String, String> dataMap
        = ImmutableMap.of(
            OPERATION_PATTERN, AuditOperationEnum.GRAPH.name(),
            ACTION_PATTERN, LogTemplate.UPDATE_GRAPH.name(),
            "audit_graph_space", graphSpace,
            "audit_graph", graphName,
            "audit_user", executorId);
        infoLogger
        .logDataMap(dataMap);
    }

    /**
     * Manage graph
     * @param graphSpace
     * @param graphName
     * @param executorId
     */
    public void logManageGraph(
        String graphSpace, String graphName, String executorId) {
        Map<String, String> dataMap
        = ImmutableMap.of(
            OPERATION_PATTERN, AuditOperationEnum.GRAPH.name(),
            ACTION_PATTERN, LogTemplate.MANAGE_GRAPH.name(),
            "audit_graph_space", graphSpace,
            "audit_graph", graphName,
            "audit_user", executorId);
        infoLogger
        .logDataMap(dataMap);
    }

    /**
     * Clear graph
     * @param graphSpace
     * @param graphName
     * @param executorId
     */
    public void logClearGraph(
        String graphSpace, String graphName, String executorId) {
        Map<String, String> dataMap
        = ImmutableMap.of(
            OPERATION_PATTERN, AuditOperationEnum.GRAPH.name(),
            ACTION_PATTERN, LogTemplate.CLEAR_GRAPH.name(),
            "audit_graph_space", graphSpace,
            "audit_graph", graphName,
            "audit_user", executorId);
        infoLogger
        .logDataMap(dataMap);
    }

    /**
     * Clear graph
     * @param graphSpace
     * @param graphName
     * @param executorId
     */
    public void logRemoveGraph(
        String graphSpace, String graphName, String executorId) {
        Map<String, String> dataMap
        = ImmutableMap.of(
            OPERATION_PATTERN, AuditOperationEnum.GRAPH.name(),
            ACTION_PATTERN, LogTemplate.REMOVE_GRAPH.name(),
            "audit_graph_space", graphSpace,
            "audit_graph", graphName,
            "audit_user", executorId);
        infoLogger
        .logDataMap(dataMap);
    }

    /**
     * Create new group
     * @param groupId
     * @param creator
     */
    public void logCreateGroup(String groupId, String creatorId) {
        Map<String, String> dataMap
        = ImmutableMap.of(
            OPERATION_PATTERN, AuditOperationEnum.USER.name(),
            ACTION_PATTERN, LogTemplate.CREATE_GROUP.name(),
            "groupId", groupId,
            "audit_user", creatorId);
        infoLogger
        .logDataMap(dataMap);
    }

    /**
     * Update group
     * @param groupId
     * @param executorId
     */
    public void logUpdateGroup(String groupId, String executorId) {
        Map<String, String> dataMap
        = ImmutableMap.of(
            OPERATION_PATTERN, AuditOperationEnum.USER.name(),
            ACTION_PATTERN, LogTemplate.UPDATE_GROUP.name(),
            "groupId", groupId,
            "audit_user", executorId);
        infoLogger
        .logDataMap(dataMap);
    }

    /**
     * Delete group
     * @param groupId
     * @param executorId
     */
    public void logDeleteGroup(String groupId, String executorId) {
        Map<String, String> dataMap
        = ImmutableMap.of(
            OPERATION_PATTERN, AuditOperationEnum.USER.name(),
            ACTION_PATTERN, LogTemplate.DELETE_GROUP.name(),
            "groupId", groupId,
            "audit_user", executorId);
        infoLogger
        .logDataMap(dataMap);
    }

    /**
     * Create new role
     * @param roleId
     * @param executorId
     */
    public void logCreateRole(String roleId, String creatorId) {
        Map<String, String> dataMap
        = ImmutableMap.of(
            OPERATION_PATTERN, AuditOperationEnum.USER.name(),
            ACTION_PATTERN, LogTemplate.CREATE_ROLE.name(),
            "roleId", roleId,
            "audit_user", creatorId);
        infoLogger
        .logDataMap(dataMap);
    }

    /**
     * Update role
     * @param roleId
     * @param executorId
     */
    public void logUpdateRole(String roleId, String executorId) {
        Map<String, String> dataMap
        = ImmutableMap.of(
            OPERATION_PATTERN, AuditOperationEnum.USER.name(),
            ACTION_PATTERN, LogTemplate.UPDATE_ROLE.name(),
            "roleId", roleId,
            "audit_user", executorId);
        infoLogger
        .logDataMap(dataMap);
    }

    /**
     * Delete role
     * @param roleId
     * @param executorId
     */
    public void logDeleteRole(String roleId, String executorId) {
        Map<String, String> dataMap
        = ImmutableMap.of(
            OPERATION_PATTERN, AuditOperationEnum.USER.name(),
            ACTION_PATTERN, LogTemplate.DELETE_ROLE.name(),
            "roleId", roleId,
            "audit_user", executorId);
        infoLogger
        .logDataMap(dataMap);
    }

    /**
     * Create new ref role
     * @param refRoleId
     * @param roleId
     */
    public void logCreateRefRole(String refRoleId, String roleId) {
        Map<String, String> dataMap
        = ImmutableMap.of(
            OPERATION_PATTERN, AuditOperationEnum.USER.name(),
            ACTION_PATTERN, LogTemplate.CREATE_REF_ROLE.name(),
            "refRoleId", refRoleId,
            "roleId", roleId);
        infoLogger
        .logDataMap(dataMap);
    }

    /**
     * Update ref role
     * @param refRoleId
     */
    public void logUpdateRefRole(String refRoleId) {
        Map<String, String> dataMap
        = ImmutableMap.of(
            OPERATION_PATTERN, AuditOperationEnum.USER.name(),
            ACTION_PATTERN, LogTemplate.UPDATE_REF_ROLE.name(),
            "refRoleId", refRoleId);
        infoLogger
        .logDataMap(dataMap);
    }

    /**
     * Delete ref role
     * @param refRoleId
     */
    public void logDeleteRefRole(String refRoleId) {
        Map<String, String> dataMap
        = ImmutableMap.of(
            OPERATION_PATTERN, AuditOperationEnum.USER.name(),
            ACTION_PATTERN, LogTemplate.DELETE_REF_ROLE.name(),
            "refRoleId", refRoleId);
        infoLogger
        .logDataMap(dataMap);
    }

    /**
     * Export role info
     * @param roleId
     * @param executorId
     */
    public void logExportRole(String roleId, String executorId) {
        Map<String, String> dataMap
        = ImmutableMap.of(
            OPERATION_PATTERN, AuditOperationEnum.USER.name(),
            ACTION_PATTERN, LogTemplate.EXPORT_ROLE.name(),
            "roleId", roleId,
            "audit_user", executorId);
        infoLogger
        .logDataMap(dataMap);
    }

    /**
     * User password changed
     * @param userId
     */
    public void logUpdatePassword(String userId) {
        Map<String, String> dataMap
        = ImmutableMap.of(
            OPERATION_PATTERN, AuditOperationEnum.USER.name(),
            ACTION_PATTERN, LogTemplate.UPDATE_PASSWORD.name(),
            "userId", userId);
        infoLogger
        .logDataMap(dataMap);
    }

    /**
     * User password reset
     * @param userId
     */
    public void logResetPassword(String userId) {
        Map<String, String> dataMap
        = ImmutableMap.of(
            OPERATION_PATTERN, AuditOperationEnum.USER.name(),
            ACTION_PATTERN, LogTemplate.RESET_PASSWORD.name(),
            "userId", userId);
        infoLogger
        .logDataMap(dataMap);
    }

    /**
     * User login via device
     * @param userId
     * @param deviceInfo
     */
    public void logUserLogin(String userId, String deviceInfo, String path) {
        Map<String, String> dataMap
        = ImmutableMap.of(
            OPERATION_PATTERN, AuditOperationEnum.USER.name(),
            ACTION_PATTERN, LogTemplate.USER_LOGIN.name(),
            "userId", userId,
            "deviceInfo", deviceInfo,
            "path", path);
        infoLogger
        .logDataMap(dataMap);
    }
    
    /**
     * User logout
     * @param userId
     */
    public void logUserLogout(String userId) {
        Map<String, String> dataMap
        = ImmutableMap.of(
            OPERATION_PATTERN, AuditOperationEnum.USER.name(),
            ACTION_PATTERN, LogTemplate.DELETE_USER.name(),
            "userId", userId);
        infoLogger
        .logDataMap(dataMap);
    }

    /**
     * User is disposed, that the user could not be used anymore
     * @param userId
     * @param executorId
     */
    public void logUserDisposed(String userId, String executorId) {
        Map<String, String> dataMap
        = ImmutableMap.of(
            OPERATION_PATTERN, AuditOperationEnum.USER.name(),
            ACTION_PATTERN, LogTemplate.USER_DISPOSE.name(),
            "userId", userId,
            "audit_user", executorId);
        infoLogger
        .logDataMap(dataMap);
    }

    /**
     * User is locked temporarily, could be unlocked later
     * @param userId
     * @param executorId
     */
    public void logUserLocked(String userId, String executorId) {
        Map<String, String> dataMap
        = ImmutableMap.of(
            OPERATION_PATTERN, AuditOperationEnum.USER.name(),
            ACTION_PATTERN, LogTemplate.USER_LOCK.name(),
            "userId", userId,
            "audit_user", executorId);
        infoLogger
        .logDataMap(dataMap);
    }

    /**
     * User is unlocked
     * @param userId
     * @param executorId
     */
    public void logUserUnlocked(String userId, String executorId) {
        Map<String, String> dataMap
        = ImmutableMap.of(
            OPERATION_PATTERN, AuditOperationEnum.USER.name(),
            ACTION_PATTERN, LogTemplate.USER_UNLOCK.name(),
            "userId", userId,
            "audit_user", executorId);
        infoLogger
        .logDataMap(dataMap);
    }

    /**
     * Use access is denied
     * @param userId
     * @param access
     * @param resourceObject
     */
    public void logUserAccessDenied(
        String userId, String access, Object resourceObject) {
    
        Map<String, String> dataMap
        = ImmutableMap.of(
            OPERATION_PATTERN, AuditOperationEnum.USER.name(),
            ACTION_PATTERN, LogTemplate.USER_ACCESS_DENIED.name(),
            "userId", userId,
            "access", access,
            "resource", resourceObject.toString());
            
        warnLogger
        .logDataMap(dataMap);
    }

    /**
     * User generates a new auth key
     * @param userId
     */
    public void logUserGenerateAuthKey(String userId) {
        Map<String, String> dataMap
        = ImmutableMap.of(
            OPERATION_PATTERN, AuditOperationEnum.USER.name(),
            ACTION_PATTERN, LogTemplate.GENERATE_AUTH_KEY.name(),
            "userId", userId);
        infoLogger
        .logDataMap(dataMap);
    }

    /**
     * Create user group
     * @param groupId
     * @param creatorId
     */
    public void logCreateUserGroup(String groupId, String creatorId) {
        Map<String, String> dataMap
        = ImmutableMap.of(
            OPERATION_PATTERN, AuditOperationEnum.USER.name(),
            ACTION_PATTERN, LogTemplate.CREATE_USER_GROUP.name(),
            "userGroupId", groupId,
            "audit_user", creatorId);
        infoLogger
        .logDataMap(dataMap);
    }

    /**
     * Update user group
     * @param groupId
     * @param executorId
     */
    public void logUpdateUserGroup(String groupId, String executorId) {
        Map<String, String> dataMap
        = ImmutableMap.of(
            OPERATION_PATTERN, AuditOperationEnum.USER.name(),
            ACTION_PATTERN, LogTemplate.UPDATE_USER_GROUP.name(),
            "userGroupId", groupId,
            "audit_user", executorId);
        infoLogger
        .logDataMap(dataMap);
    }

    /**
     * Delete user group
     * @param groupId
     * @param executorId
     */
    public void logDeleteUserGroup(String groupId, String executorId) {
        Map<String, String> dataMap
        = ImmutableMap.of(
            OPERATION_PATTERN, AuditOperationEnum.USER.name(),
            ACTION_PATTERN, LogTemplate.DELETE_USER_GROUP.name(),
            "userGroupId", groupId,
            "audit_user", executorId);
        infoLogger
        .logDataMap(dataMap);
    }

    /**** Tenant related logs ****/

    /**
     * Update tenant config - GraphSpace
     * @param graphSpace
     */
    public void logUpdateTenantConfig(String graphSpace) {
        Map<String, String> dataMap
        = ImmutableMap.of(
            OPERATION_PATTERN, AuditOperationEnum.GRAPH_SPACE.name(),
            ACTION_PATTERN, LogTemplate.UPDATE_TENANT_CONFIG.name(),
            "graphSpace", graphSpace);
        infoLogger
        .logDataMap(dataMap);
    }

    /**
     * Create new tenant
     * @param graphSpace
     * @param creatorId
     */
    public void logCreateTenant(String graphSpace, String creatorId) {
        Map<String, String> dataMap
        = ImmutableMap.of(
            OPERATION_PATTERN, AuditOperationEnum.GRAPH_SPACE.name(),
            ACTION_PATTERN, LogTemplate.CREATE_TENANT.name(),
            "graphSpace", graphSpace,
            "audit_user", creatorId);
        infoLogger
        .logDataMap(dataMap);
    }

    /**
     * Update tenant
     * @param graphSpace
     * @param executorId
     */
    public void logUpdateTenant(String graphSpace, String executorId) {
        Map<String, String> dataMap
        = ImmutableMap.of(
            OPERATION_PATTERN, AuditOperationEnum.GRAPH_SPACE.name(),
            ACTION_PATTERN, LogTemplate.UPDATE_TENANT.name(),
            "graphSpace", graphSpace,
            "audit_user", executorId);
        infoLogger
        .logDataMap(dataMap);
    }

    /**
     * Remove tenant, not delete
     * @param graphSpace
     * @param executorId
     */
    public void logRemoveTenant(String graphSpace, String executorId) {
        Map<String, String> dataMap
        = ImmutableMap.of(
            OPERATION_PATTERN, AuditOperationEnum.GRAPH_SPACE.name(),
            ACTION_PATTERN, LogTemplate.REMOVE_TENANT.name(),
            "graphSpace", graphSpace,
            "audit_user", executorId);
        infoLogger
        .logDataMap(dataMap);
    }

    /**** Cluster related logs ****/
    /**
     * Synchronize cluster config
     * @param executorId
     */
    public void logSyncClusterConfig(String executorId) {
        Map<String, String> dataMap
        = ImmutableMap.of(
            OPERATION_PATTERN, AuditOperationEnum.SYSTEM.name(),
            ACTION_PATTERN, LogTemplate.SYNC_CLUSTER_CONFIG.name(),
            "audit_user", executorId);
        infoLogger
        .logDataMap(dataMap);
    }

    /**
     * Process command synchronized
     * @param cmdKey
     * @param executorId
     */
    public void logProcessSyncCmd(String cmdKey, String executorId) {
        Map<String, String> dataMap
        = ImmutableMap.of(
            OPERATION_PATTERN, AuditOperationEnum.SYSTEM.name(),
            ACTION_PATTERN, LogTemplate.SYNC_OPS_COMMAND .name(),
            "command", cmdKey,
            "audit_user", executorId);
        infoLogger
        .logDataMap(dataMap);
    }

    /**
     * Process command asynchronized
     * @param cmdKey
     * @param executorId
     */
    public void logProcessAsyncCmd(String cmdKey, String executorId) {
        Map<String, String> dataMap
        = ImmutableMap.of(
            OPERATION_PATTERN, AuditOperationEnum.SYSTEM.name(),
            ACTION_PATTERN, LogTemplate.ASYNC_OPS_COMMAND.name(),
            "command", cmdKey,
            "audit_user", executorId);
        infoLogger
        .logDataMap(dataMap);
    }

    /**
     * Import certification license
     * @param licenseType
     * @param executorId
     */
    public void logImportLicense(String licenseType, String executorId) {
        Map<String, String> dataMap
        = ImmutableMap.of(
            OPERATION_PATTERN, AuditOperationEnum.SYSTEM.name(),
            ACTION_PATTERN, LogTemplate.IMPORT_CERT_LICENSE.name(),
            "licenseType", licenseType,
            "audit_user", executorId);
        infoLogger
        .logDataMap(dataMap);
    }

    /**** Service related logs ****/
    /**
     * Add service from system
     * @param serviceId
     * @param instanceId
     */
    public void logAddService(String serviceId, String instanceId) {
        Map<String, String> dataMap
        = ImmutableMap.of(
            OPERATION_PATTERN, AuditOperationEnum.SERVICE.name(),
            ACTION_PATTERN, LogTemplate.ADD_SERVICE.name(),
            "serviceId", serviceId,
            "instanceId", instanceId);
        infoLogger
        .logDataMap(dataMap);
    }

    /**
     * Remove service from system
     * @param serviceId
     * @param instanceId
     */
    public void logRemoveService(String serviceId, String instanceId) {
        Map<String, String> dataMap
        = ImmutableMap.of(
            OPERATION_PATTERN, AuditOperationEnum.SERVICE.name(),
            ACTION_PATTERN, LogTemplate.REMOVE_SERVICE.name(),
            "serviceId", serviceId,
            "instanceId", instanceId);
        infoLogger
        .logDataMap(dataMap);
    }

    /**
     * Service start
     * @param serviceId
     */
    public void logStartService(String serviceId) {
        Map<String, String> dataMap
        = ImmutableMap.of(
            OPERATION_PATTERN, AuditOperationEnum.SERVICE.name(),
            ACTION_PATTERN, LogTemplate.START_SERVICE.name(),
            "serviceId", serviceId);
        infoLogger
        .logDataMap(dataMap);
    }

    /**
     * Service stop, use warn logger
     * @param serviceId
     */
    public void logStopService(String serviceId) {
        Map<String, String> dataMap
        = ImmutableMap.of(
            OPERATION_PATTERN, AuditOperationEnum.SERVICE.name(),
            ACTION_PATTERN, LogTemplate.STOP_SERVICE.name(),
            "serviceId", serviceId);
        warnLogger
        .logDataMap(dataMap);
    }

    /**
     * Service restart, use warn logger
     * @param serviceId
     */
    public void logRestartService(String serviceId) {
        Map<String, String> dataMap
        = ImmutableMap.of(
            OPERATION_PATTERN, AuditOperationEnum.SERVICE.name(),
            ACTION_PATTERN, LogTemplate.RESTART_SERVICE.name(),
            "serviceId", serviceId);
        warnLogger
        .logDataMap(dataMap);
    }

    /**
     * Synchronize service config
     * @param serviceId
     */
    public void logSyncServiceConfig(String serviceId) {
        Map<String, String> dataMap
        = ImmutableMap.of(
            OPERATION_PATTERN, AuditOperationEnum.SERVICE.name(),
            ACTION_PATTERN, LogTemplate.SYNC_SERVICE_CONFIG.name(),
            "serviceId", serviceId);
        infoLogger
        .logDataMap(dataMap);
    }

    /**
     * Export service log
     * @param serviceId
     * @param executorId
     */
    public void logExportServiceLog(String serviceId, String executorId) {
        Map<String, String> dataMap
        = ImmutableMap.of(
            OPERATION_PATTERN, AuditOperationEnum.SERVICE.name(),
            ACTION_PATTERN, LogTemplate.EXPORT_SERVICE_LOG.name(),
            "audit_user", executorId,
            "serviceId", serviceId);
        infoLogger
        .logDataMap(dataMap);
    }

    /**
     * Start health check
     * @param serviceId
     */
    public void logStartHealthCheck(String serviceId) {
        Map<String, String> dataMap
        = ImmutableMap.of(
            OPERATION_PATTERN, AuditOperationEnum.SYSTEM.name(),
            ACTION_PATTERN, LogTemplate.SERVICE_HEALTH_CHECK_START.name(),
            "serviceId", serviceId);
        infoLogger
        .logDataMap(dataMap);
    }

    /**
     * Finalize health check
     * @param serviceId
     */
    public void logFinalizeHealthCheck(String serviceId, String result) {
        Map<String, String> dataMap
        = ImmutableMap.of(
            OPERATION_PATTERN, AuditOperationEnum.SYSTEM.name(),
            ACTION_PATTERN, LogTemplate.SERVICE_HEALTH_CHECK_RESULT.name(),
            "serviceId", serviceId,
            "result", result);
        infoLogger
        .logDataMap(dataMap);
    }

    /**** Instance related logs ****/
    /**
     * Create new instance
     * @param instanceId
     */
    public void logCreateInstance(String instanceId, String executorId) {
        Map<String, String> dataMap
        = ImmutableMap.of(
            OPERATION_PATTERN, AuditOperationEnum.SYSTEM.name(),
            ACTION_PATTERN, LogTemplate.CREATE_INSTANCE.name(),
            "instanceId", instanceId,
            "audit_user", executorId);
        infoLogger
        .logDataMap(dataMap);
    }

    /**
     * Delete instance
     * @param instanceId
     */
    public void logDeleteInstance(String instanceId, String executorId) {
        Map<String, String> dataMap
        = ImmutableMap.of(
            OPERATION_PATTERN, AuditOperationEnum.SYSTEM.name(),
            ACTION_PATTERN, LogTemplate.DELETE_INSTANCE.name(),
            "instanceId", instanceId,
            "audit_user", executorId);
        infoLogger
        .logDataMap(dataMap);
    }

    /**
     * Start instance
     * @param instanceId
     */
    public void logStartInstance(String instanceId, String executorId) {
        Map<String, String> dataMap
        = ImmutableMap.of(
            OPERATION_PATTERN, AuditOperationEnum.SYSTEM.name(),
            ACTION_PATTERN, LogTemplate.START_INSTANCE.name(),
            "instanceId", instanceId,
            "audit_user", executorId);
        infoLogger
        .logDataMap(dataMap);
    }

    /**
     * Stop instance
     * @param instanceId
     */
    public void logStopInstance(String instanceId, String executorId) {
        Map<String, String> dataMap
        = ImmutableMap.of(
            OPERATION_PATTERN, AuditOperationEnum.SYSTEM.name(),
            ACTION_PATTERN, LogTemplate.STOP_INSTANCE.name(),
            "instanceId", instanceId,
            "audit_user", executorId);
        warnLogger
        .logDataMap(dataMap);
    }

    /**
     * Restart instance
     * @param instanceId
     */
    public void logRestartInstance(String instanceId, String executorId) {
        Map<String, String> dataMap
        = ImmutableMap.of(
            OPERATION_PATTERN, AuditOperationEnum.SYSTEM.name(),
            ACTION_PATTERN, LogTemplate.RESTART_INSTANCE.name(),
            "instanceId", instanceId,
            "audit_user", executorId);
        warnLogger
        .logDataMap(dataMap);
    }

    /**
     * Synchronize instance config
     * @param instanceId
     * @param executorId
     */
    public void logSyncInstanceConfig(String instanceId, String executorId) {
        Map<String, String> dataMap
        = ImmutableMap.of(
            OPERATION_PATTERN, AuditOperationEnum.SYSTEM.name(),
            ACTION_PATTERN, LogTemplate.SYNC_INSTANCE_CONFIG.name(),
            "instanceId", instanceId,
            "audit_user", executorId);
        infoLogger
        .logDataMap(dataMap);
    }

    /**
     * Instance begins to provide service
     * @param instanceId
     * @param serviceId
     */
    public void logProvideService(String instanceId, String serviceId) {
        Map<String, String> dataMap
        = ImmutableMap.of(
            OPERATION_PATTERN, AuditOperationEnum.SERVICE.name(),
            ACTION_PATTERN, LogTemplate.INSTANCE_PROVIDE_SERVICE.name(),
            "instanceId", instanceId,
            "serviceId", serviceId);
        infoLogger
        .logDataMap(dataMap);
    }

    /**
     * Instance withdraws service from cluster
     * @param instanceId
     * @param serviceId
     */
    public void logWithdrawService(String instanceId, String serviceId) {
        Map<String, String> dataMap
        = ImmutableMap.of(
            OPERATION_PATTERN, AuditOperationEnum.SERVICE.name(),
            ACTION_PATTERN, LogTemplate.INSTANCE_WITHDRAW_SERVICE.name(),
            "instanceId", instanceId,
            "serviceId", serviceId);
        warnLogger
        .logDataMap(dataMap);
    }

    /**
     * Export instance log
     * @param instanceId
     * @param executorId
     */
    public void logExportInstanceLog(String instanceId, String executorId) {
        Map<String, String> dataMap
        = ImmutableMap.of(
            OPERATION_PATTERN, AuditOperationEnum.SYSTEM.name(),
            ACTION_PATTERN, LogTemplate.EXPORT_INSTANCE_LOG.name(),
            "instanceId", instanceId,
            "audit_user", executorId);
        infoLogger
        .logDataMap(dataMap);
    }

    /**** Host related logs ****/

    /**** Operation logs ****/
    
}
