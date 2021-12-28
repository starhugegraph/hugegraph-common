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
 * Provide Audit related log methods
 * @author Scorpiour
 * @since 2021-12-21
 */
public class AuditLogger {

    private final MethodLogger<MethodLogger.LevelInfo> infoLogger;
    private final MethodLogger<MethodLogger.LevelWarn> warnLogger;

    public AuditLogger(Class<?> targetType) {

        infoLogger = MethodLoggerFactory
                .getMethodLogger(MethodLogger.LevelInfo.class, targetType);

        warnLogger = MethodLoggerFactory
                .getMethodLogger(MethodLogger.LevelWarn.class, targetType);
    }

    
    /**** User related logs ****/
    /**
     * Create new user
     * @param userId
     * @param creatorId
     */
    public void logCreateUser(String userId, String creatorId) {
        infoLogger
        .generalLogMessage(LogTemplate.CREATE_USER, userId, creatorId);
    }

    /**
     * Update user
     * @param userId
     * @param executorId
     */
    public void logUpdateUser(String userId, String executorId) {
        infoLogger
        .generalLogMessage(LogTemplate.UPDATE_USER, userId, executorId);
    }

    /**
     * Delete user
     * @param userId
     * @param executorId
     */
    public void logDeleteUser(String userId, String executorId) {
        infoLogger
        .generalLogMessage(LogTemplate.DELETE_USER, userId, executorId);
    }

    /**
     * Create new group
     * @param groupId
     * @param creator
     */
    public void logCreateGroup(String groupId, String creatorId) {
        infoLogger
        .generalLogMessage(LogTemplate.CREATE_GROUP, groupId, creatorId);
    }

    /**
     * Update group
     * @param groupId
     * @param executorId
     */
    public void logUpdateGroup(String groupId, String executorId) {
        infoLogger
        .generalLogMessage(LogTemplate.UPDATE_GROUP, groupId, executorId);
    }

    /**
     * Delete group
     * @param groupId
     * @param executorId
     */
    public void logDeleteGroup(String groupId, String executorId) {
        infoLogger
        .generalLogMessage(LogTemplate.DELETE_GROUP, groupId, executorId);
    }

    /**
     * Create new role
     * @param roleId
     * @param executorId
     */
    public void logCreateRole(String roleId, String creatorId) {
        infoLogger
        .generalLogMessage(LogTemplate.CREATE_ROLE, roleId, creatorId);
    }

    /**
     * Update role
     * @param roleId
     * @param executorId
     */
    public void logUpdateRole(String roleId, String executorId) {
        infoLogger
        .generalLogMessage(LogTemplate.UPDATE_ROLE, roleId, executorId);
    }

    /**
     * Delete role
     * @param roleId
     * @param executorId
     */
    public void logDeleteRole(String roleId, String executorId) {
        infoLogger
        .generalLogMessage(LogTemplate.DELETE_ROLE, roleId, executorId);
    }

    /**
     * Create new ref role
     * @param refRoleId
     * @param roleId
     */
    public void logCreateRefRole(String refRoleId, String roleId) {
        infoLogger
        .generalLogMessage(LogTemplate.CREATE_REF_ROLE, refRoleId, roleId);
    }

    /**
     * Update ref role
     * @param refRoleId
     */
    public void logUpdateRefRole(String refRoleId) {
        infoLogger
        .generalLogMessage(LogTemplate.UPDATE_REF_ROLE, refRoleId);
    }

    /**
     * Delete ref role
     * @param refRoleId
     */
    public void logDeleteRefRole(String refRoleId) {
        infoLogger
        .generalLogMessage(LogTemplate.DELETE_REF_ROLE, refRoleId);
    }

    /**
     * Export role info
     * @param roleId
     * @param executorId
     */
    public void logExportRole(String roleId, String executorId) {
        infoLogger
        .generalLogMessage(LogTemplate.EXPORT_ROLE, roleId, executorId);
    }

    /**
     * User password changed
     * @param userId
     */
    public void logUpdatePassword(String userId) {
        infoLogger
        .generalLogMessage(LogTemplate.UPDATE_PASSWORD, userId);
    }

    /**
     * User password reset
     * @param userId
     */
    public void logResetPassword(String userId) {
        infoLogger
        .generalLogMessage(LogTemplate.RESET_PASSWORD, userId);
    }

    /**
     * User login via device
     * @param userId
     * @param deviceInfo
     */
    public void logUserLogin(String userId, String deviceInfo, String path) {
        infoLogger
        .generalLogMessage(LogTemplate.USER_LOGIN, userId, deviceInfo, path);
    }
    
    /**
     * User logout
     * @param userId
     */
    public void logUserLogout(String userId) {
        infoLogger
        .generalLogMessage(LogTemplate.USER_LOGOUT, userId);
    }

    /**
     * User is disposed, that the user could not be used anymore
     * @param userId
     * @param executorId
     */
    public void logUserDisposed(String userId, String executorId) {
        infoLogger
        .generalLogMessage(LogTemplate.USER_DISPOSE, userId, executorId);
    }

    /**
     * User is locked temporarily, could be unlocked later
     * @param userId
     * @param executorId
     */
    public void logUserLocked(String userId, String executorId) {
        infoLogger
        .generalLogMessage(LogTemplate.USER_LOCK, userId, executorId);
    }

    /**
     * User is unlocked
     * @param userId
     * @param executorId
     */
    public void logUserUnlocked(String userId, String executorId) {
        infoLogger
        .generalLogMessage(LogTemplate.USER_UNLOCK, userId, executorId);
    }

    /**
     * Use access is denied
     * @param userId
     * @param access
     * @param resourceObject
     */
    public void logUserAccessDenied(
        String userId, String access, Object resourceObject) {
        warnLogger
        .generalLogMessage(
            LogTemplate.USER_ACCESS_DENIED,
            userId, access, resourceObject);
    }

    /**
     * User generates a new auth key
     * @param userId
     */
    public void logUserGenerateAuthKey(String userId) {
        infoLogger
        .generalLogMessage(LogTemplate.GENERATE_AUTH_KEY, userId);
    }

    /**
     * Create user group
     * @param groupId
     * @param creatorId
     */
    public void logCreateUserGroup(String groupId, String creatorId) {
        infoLogger
        .generalLogMessage(LogTemplate.CREATE_USER_GROUP, groupId, creatorId);
    }

    /**
     * Update user group
     * @param groupId
     * @param executorId
     */
    public void logUpdateUserGroup(String groupId, String executorId) {
        infoLogger
        .generalLogMessage(LogTemplate.UPDATE_USER_GROUP, groupId, executorId);
    }

    /**
     * Delete user group
     * @param groupId
     * @param executorId
     */
    public void logDeleteUserGroup(String groupId, String executorId) {
        infoLogger
        .generalLogMessage(LogTemplate.DELETE_USER_GROUP, groupId, executorId);
    }

    /**** Tenant related logs ****/

    /**
     * Update tenant config
     * @param tenantId
     */
    public void logUpdateTenantConfig(String tenantId) {
        infoLogger
        .generalLogMessage(LogTemplate.UPDATE_TENANT_CONFIG, tenantId);
    }

    /**
     * Create new tenant
     * @param tenantId
     * @param creatorId
     */
    public void logCreateTenant(String tenantId, String creatorId) {
        infoLogger
        .generalLogMessage(LogTemplate.CREATE_TENANT, tenantId, creatorId);
    }

    /**
     * Update tenant
     * @param tenantId
     * @param executorId
     */
    public void logUpdateTenant(String tenantId, String executorId) {
        infoLogger
        .generalLogMessage(LogTemplate.UPDATE_TENANT, tenantId, executorId);
    }

    /**
     * Remove tenant, not delete
     * @param tenantId
     * @param executorId
     */
    public void logRemoveTenant(String tenantId, String executorId) {
        infoLogger
        .generalLogMessage(LogTemplate.REMOVE_TENANT, tenantId, executorId);
    }

    /**** Cluster related logs ****/
    /**
     * Synchronize cluster config
     * @param executorId
     */
    public void logSyncClusterConfig(String executorId) {
        infoLogger
        .generalLogMessage(LogTemplate.SYNC_CLUSTER_CONFIG, executorId);
    }

    /**
     * Process command synchronized
     * @param cmdKey
     * @param executorId
     */
    public void logProcessSyncCmd(String cmdKey, String executorId) {
        infoLogger
        .generalLogMessage(LogTemplate.SYNC_OPS_COMMAND, cmdKey, executorId);
    }

    /**
     * Process command asynchronized
     * @param cmdKey
     * @param executorId
     */
    public void logProcessAsyncCmd(String cmdKey, String executorId) {
        infoLogger
        .generalLogMessage(LogTemplate.ASYNC_OPS_COMMAND, cmdKey, executorId);
    }

    /**
     * Import certification license
     * @param licenseType
     * @param executorId
     */
    public void logImportLicense(String licenseType, String executorId) {
        infoLogger
        .generalLogMessage(
            LogTemplate.IMPORT_CERT_LICENSE,
            licenseType,
            executorId);
    }

    /**** Service related logs ****/
    /**
     * Add service from system
     * @param serviceId
     * @param instanceId
     */
    public void logAddService(String serviceId, String instanceId) {
        infoLogger
        .generalLogMessage(LogTemplate.ADD_SERVICE, serviceId, instanceId);
    }

    /**
     * Remove service from system
     * @param serviceId
     * @param instanceId
     */
    public void logRemoveService(String serviceId, String instanceId) {
        infoLogger
        .generalLogMessage(LogTemplate.REMOVE_SERVICE, serviceId, instanceId);
    }

    /**
     * Service start
     * @param serviceId
     */
    public void logStartService(String serviceId) {
        infoLogger
        .generalLogMessage(LogTemplate.START_SERVICE, serviceId);
    }

    /**
     * Service stop, use warn logger
     * @param serviceId
     */
    public void logStopService(String serviceId) {
        warnLogger
        .generalLogMessage(LogTemplate.STOP_SERVICE, serviceId);
    }

    /**
     * Service restart, use warn logger
     * @param serviceId
     */
    public void logRestartService(String serviceId) {
        warnLogger
        .generalLogMessage(LogTemplate.RESTART_SERVICE, serviceId);
    }

    /**
     * Synchronize service config
     * @param serviceId
     */
    public void logSyncServiceConfig(String serviceId) {
        infoLogger
        .generalLogMessage(LogTemplate.SYNC_SERVICE_CONFIG, serviceId);
    }

    /**
     * Export service log
     * @param serviceId
     * @param executorId
     */
    public void logExportServiceLog(String serviceId, String executorId) {
        infoLogger
        .generalLogMessage(
            LogTemplate.EXPORT_SERVICE_LOG, serviceId, executorId);
    }

    /**
     * Start health check
     * @param serviceId
     */
    public void logStartHealthCheck(String serviceId) {
        infoLogger
        .generalLogMessage(LogTemplate.SERVICE_HEALTH_CHECK_START, serviceId);
    }

    /**
     * Finalize health check
     * @param serviceId
     */
    public void logFinalizeHealthCheck(String serviceId) {
        infoLogger
        .generalLogMessage(LogTemplate.SERVICE_HEALTH_CHECK_RESULT, serviceId);
    }

    /**** Instance related logs ****/
    /**
     * Create new instance
     * @param instanceId
     */
    public void logCreateInstance(String instanceId, String executorId) {
        infoLogger
        .generalLogMessage(LogTemplate.CREATE_INSTANCE, instanceId);
    }

    /**
     * Delete instance
     * @param instanceId
     */
    public void logDeleteInstance(String instanceId, String executorId) {
        infoLogger
        .generalLogMessage(
            LogTemplate.DELETE_INSTANCE, instanceId, executorId);
    }

    /**
     * Start instance
     * @param instanceId
     */
    public void logStartInstance(String instanceId, String executorId) {
        infoLogger
        .generalLogMessage(
            LogTemplate.START_INSTANCE, instanceId, executorId);
    }

    /**
     * Stop instance
     * @param instanceId
     */
    public void logStopInstance(String instanceId, String executorId) {
        warnLogger
        .generalLogMessage(
            LogTemplate.STOP_INSTANCE, instanceId, executorId);
    }

    /**
     * Restart instance
     * @param instanceId
     */
    public void logRestartInstance(String instanceId, String executorId) {
        warnLogger
        .generalLogMessage(
            LogTemplate.RESTART_INSTANCE, instanceId, executorId);
    }

    /**
     * Synchronize instance config
     * @param instanceId
     * @param executorId
     */
    public void logSyncInstanceConfig(String instanceId, String executorId) {
        infoLogger
        .generalLogMessage(
            LogTemplate.SYNC_INSTANCE_CONFIG, instanceId, executorId);
    }

    /**
     * Instance begins to provide service
     * @param instanceId
     * @param serviceId
     */
    public void logProvideService(String instanceId, String serviceId) {
        infoLogger
        .generalLogMessage(
            LogTemplate.INSTANCE_PROVIDE_SERVICE,
            instanceId,
            serviceId);
    }

    /**
     * Instance withdraws service from cluster
     * @param instanceId
     * @param serviceId
     */
    public void logWithdrawService(String instanceId, String serviceId) {
        warnLogger
        .generalLogMessage(
            LogTemplate.INSTANCE_WITHDRAW_SERVICE,
            instanceId,
            serviceId);
    }

    /**
     * Export instance log
     * @param instanceId
     * @param executorId
     */
    public void logExportInstanceLog(String instanceId, String executorId) {
        infoLogger
        .generalLogMessage(LogTemplate.EXPORT_INSTANCE_LOG, executorId);
    }

    /**** Host related logs ****/

    /**** Operation logs ****/
    
}
