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

/**
 * Provide server general log methods
 * @author Scorpiour
 * @since 2021-12-22
 */
public class ServerLogger {

    private final MethodLogger<MethodLogger.LevelDebug> debugLogger;
    private final MethodLogger<MethodLogger.LevelInfo> infoLogger;
    private final MethodLogger<MethodLogger.LevelWarn> warnLogger;
    private final MethodLogger<MethodLogger.LevelError> errorLogger;

    public ServerLogger(Class<?> targetType) {
       
        debugLogger = MethodLoggerFactory
                .getMethodLogger(MethodLogger.LevelDebug.class, targetType);

        infoLogger = MethodLoggerFactory
                .getMethodLogger(MethodLogger.LevelInfo.class, targetType);
    
        warnLogger = MethodLoggerFactory
                .getMethodLogger(MethodLogger.LevelWarn.class, targetType);

        errorLogger = MethodLoggerFactory
                .getMethodLogger(MethodLogger.LevelError.class, targetType);
    }

    /**
     * Transaction commit failed
     * @param e
     */
    public void logCommitFailed(Throwable e) {
        errorLogger
        .generalLogMessage(LogTemplate.COMMIT_FAILED, e);
    }

    /**
     * Transaction rollback failed
     * @param e
     */
    public void logRollbackFailed(Throwable e) {
        errorLogger
        .generalLogMessage(LogTemplate.ROLLBACK_FAILED, e);
    }

    /**
     * Instantiate AuthManageProxy
     * @param name
     * @param rateLimit
     */
    public void logInitAuthProxy(String name, Double rateLimit) {
        infoLogger
        .generalLogMessage(LogTemplate.AUTH_PROXY_INIT, name, rateLimit);
    }

    /**
     * Verify Resource Object Permission
     * @param action Action
     * @param ro Resource Object
     * @param userName
     * @param role Role
     */
    public void logVerifyResPermission(
        String username, String status, String action, Object ro) {

        infoLogger
        .generalLogMessage(
            LogTemplate.VERIFY_RES_PERM,
            username, status, action ,ro);
    }

    /**
     * Validate user failed
     * @param username
     */
    public void logValidateUserFailed(String username, Exception e) {
        infoLogger
        .generalLogMessage(
            LogTemplate.VALIDATE_USER_FAILED, username, e);
    }

    /**
     * Validate token failed
     * @param token
     */
    public void logValidateTokenFailed(Exception e) {
        infoLogger
        .generalLogMessage(
            LogTemplate.VALIDATE_TOKEN_FAILED, e);
    }

    /**
     * Create graph
     * @param name
     * @param config
     */
    public void logCreateGraph(String name, String config) {
        infoLogger
        .generalLogMessage(LogTemplate.CREATE_GRAPH, name, config);
    }

    /**
     * Remove graph
     * @param name
     */
    public void logRemoveGraph(String name) {
        infoLogger
        .generalLogMessage(LogTemplate.REMOVE_GRAPH, name);
    }

    /**
     * Clear graph
     * @param name
     */
    public void logClearGraph(String name) {
        infoLogger
        .generalLogMessage(LogTemplate.CLEAR_GRAPH, name);
    }

    /**
     * Manage graph
     * @param actionMap
     */
    public void logManageGraph(Map<String, String> actionMap) {
        infoLogger
        .generalLogMessage(LogTemplate.MANAGE_GRAPH, actionMap);
    }

    /**
     * Create snapshot
     * @param graph
     */
    public void logCreateSnapshot(String graph) {
        infoLogger
        .generalLogMessage(LogTemplate.CREATE_SNAPSHOT, graph);
    }

    /**
     * Resume snapshot
     * @param graph
     */
    public void logResumeSnapshot(String graph) {
        infoLogger
        .generalLogMessage(LogTemplate.RESUME_SNAPSHOT, graph);
    }

    /**
     * Compact graph
     * @param graph
     */
    public void logCompactGraph(String graph) {
        infoLogger
        .generalLogMessage(LogTemplate.COMPACT_GRAPH, graph);
    }

    /**
     * Flush graph
     * @param graph
     */
    public void logFlushGraph(String graph) {
        infoLogger
        .generalLogMessage(LogTemplate.FLUSH_GRAPH, graph);
    }

    /**
     * Create access
     * @param graph
     * @param jsonAccess
     */
    public void logCreateAccess(String graph, Object jsonAccess) {
        infoLogger
        .generalLogMessage(LogTemplate.CREATE_ACCESS, graph, jsonAccess);
    }

    /**
     * Update access
     * @param graph
     * @param jsonAccess
     */
    public void logUpdateAccess(String graph, Object jsonAccess) {
        infoLogger
        .generalLogMessage(LogTemplate.UPDATE_ACCESS, graph, jsonAccess);
    }

    /**
     * Delete access
     * @param graph
     * @param accessId
     */
    public void logDeleteAccess(String graph, String accessId) {
        infoLogger
        .generalLogMessage(LogTemplate.DELETE_ACCESS, graph, accessId);
    }

    /**
     * Create belong
     * @param graph
     * @param jsonBelong
     */
    public void logCreateBelong(String graph, Object jsonBelong) {
        infoLogger
        .generalLogMessage(LogTemplate.CREATE_BELONG, graph, jsonBelong);
    }

    /**
     * Update belong
     * @param graph
     * @param jsonBelong
     */
    public void logUpdateBelong(String graph, Object jsonBelong) {
        infoLogger
        .generalLogMessage(LogTemplate.UPDATE_BELONG, graph, jsonBelong);
    }

    /**
     * Delete belong
     * @param graph
     * @param belongId
     */
    public void logDeleteBelong(String graph, String belongId) {
        infoLogger
        .generalLogMessage(LogTemplate.DELETE_BELONG, graph, belongId);
    }

    /**
     * Create project
     * @param graph
     * @param jsonProject
     */
    public void logCreateProject(String graph, Object jsonProject) {
        infoLogger
        .generalLogMessage(LogTemplate.CREATE_PROJECT, graph, jsonProject);
    }

    /**
     * Update project
     * @param graph
     * @param jsonProject
     */
    public void logUpdateProject(String graph, Object jsonProject) {
        infoLogger
        .generalLogMessage(LogTemplate.UPDATE_PROJECT, graph, jsonProject);
    }

    /**
     * Delete project
     * @param graph
     * @param projectId
     */
    public void logDeleteProject(String graph, String projectId) {
        infoLogger
        .generalLogMessage(LogTemplate.DELETE_PROJECT, graph, projectId);
    }

    /**
     * Create target
     * @param graph
     * @param jsonTarget
     */
    public void logCreateTarget(String graph, Object jsonTarget) {
        infoLogger
        .generalLogMessage(LogTemplate.CREATE_TARGET, graph, jsonTarget);
    }

    /**
     * Update target
     * @param graph
     * @param jsonTarget
     */
    public void logUpdateTarget(String graph, Object jsonTarget) {
        infoLogger
        .generalLogMessage(LogTemplate.UPDATE_TARGET, graph, jsonTarget);
    }

    /**
     * Delete target
     * @param graph
     * @param targetId
     */
    public void logDeleteTarget(String graph, String targetId) {
        infoLogger
        .generalLogMessage(LogTemplate.DELETE_TARGET, graph, targetId);
    }
    
    /**
     * Create task
     * @param graph
     * @param jsonTask
     */
    public void logCreateTask(String graph, Object jsonTask) {
        infoLogger
        .generalLogMessage(LogTemplate.CREATE_TASK, graph, jsonTask);
    }

    /**
     * Update task
     * @param graph
     * @param jsonTask
     */
    public void logUpdateTask(String graph, Object jsonTask) {
        infoLogger
        .generalLogMessage(LogTemplate.UPDATE_TASK, graph, jsonTask);
    }

    /**
     * Cancel task
     * @param graph
     * @param taskId
     */
    public void logCancelTask(String graph, String taskId) {
        infoLogger
        .generalLogMessage(LogTemplate.CANCEL_TASK, graph, taskId);
    }

    /**
     * Delete task
     * @param graph
     * @param taskId
     */
    public void logDeleteTask(String graph, String taskId) {
        infoLogger
        .generalLogMessage(LogTemplate.DELETE_TASK, graph, taskId);
    }

    /**
     * Create property
     * @param graph
     * @param jsonPropKey
     */
    public void logCreateProperty(String graph, Object jsonPropKey) {
        infoLogger
        .generalLogMessage(LogTemplate.CREATE_PROPERTY, graph, jsonPropKey);
    }

    /**
     * Update property
     * @param graph
     * @param jsonPropKey
     */
    public void logUpdateProperty(
            String graph, String action, Object jsonPropKey) {
        
        infoLogger
        .generalLogMessage(
            LogTemplate.UPDATE_PROPERTY, graph, action, jsonPropKey);
    }

    /**
     * Delete property
     * @param graph
     * @param key
     */
    public void logDeleteProperty(String graph, String key) {
        infoLogger
        .generalLogMessage(LogTemplate.DELETE_PROPERTY, graph, key);
    }
}
