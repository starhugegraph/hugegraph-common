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
 * Encapsulation class of typed method loggers and corresponding templates
 * @author Scorpiour
 * @since 2021-12-21
 */
public class HugeGraphLogger {

    private final Class<?> targetType;

    private final MethodLogger<MethodLogger.LevelDebug> debugLogger;
    private final MethodLogger<MethodLogger.LevelInfo> infoLogger;
    private final MethodLogger<MethodLogger.LevelWarn> warnLogger;
    private final MethodLogger<MethodLogger.LevelError> errorLogger;

    private final AuditLogger auditLogger;
    private final CommonLogger commonLogger;
    private final ServerLogger serverLogger;
    private final ClientLogger clientLogger;

    /**
     * Initialize logger with given type
     * @param clazz type of caller class
     */
    public HugeGraphLogger(Class<?> clazz) {

        // which class the logger bind to
        this.targetType = clazz;

        debugLogger = MethodLoggerFactory
                .getMethodLogger(MethodLogger.LevelDebug.class, clazz);

        infoLogger = MethodLoggerFactory
                .getMethodLogger(MethodLogger.LevelInfo.class, clazz);

        warnLogger = MethodLoggerFactory
                .getMethodLogger(MethodLogger.LevelWarn.class, clazz);

        errorLogger = MethodLoggerFactory
                .getMethodLogger(MethodLogger.LevelError.class, clazz);

        // Loggers for corresponding modules
        auditLogger = new AuditLogger(targetType);
        commonLogger = new CommonLogger(targetType);
        serverLogger = new ServerLogger(targetType);
        clientLogger = new ClientLogger(targetType);
    }

    public boolean isDebugEnabled() {
        return this.debugLogger.isDebugEnabled();
    }

    /**
     * Allow alternate level
     * @param level customized level
     * @param template LogTemplate
     * @param args Corresponding args
     * @param <T> Level Type
     */
    public <T extends GraphLogLevel>
        void log(Class<T> level, LogTemplate template, Object ...args) {
        MethodLoggerFactory
                .getMethodLogger(level, this.targetType)
                .generalLogMessage(template, args);
    }

    /**** General logs ****/
    /**
     * Server restart
     */
    public void logRestServerStart() {
        infoLogger.generalLogMessage(LogTemplate.START_REST_SERVER);
    }

    /**
     * Server shutdown
     */
    public void logServerShutdown() {
        warnLogger.generalLogMessage(
                LogTemplate.SERVER_DOWN);
    }

    /**
     * Used to log general critical errors, shall be used in catch block
     * @param exception Exception that we caught
     * @param additionalInfo Infos that we want to know other than exception
     */
    public void logCriticalError(Exception exception, Object additionalInfo) {
        errorLogger
        .generalLogMessage(
            LogTemplate.CRITICAL_ERROR, exception, additionalInfo);
    }

    /**
     * Used to log general debug info, caller must identify him/her self.
     * For example:
     *     String executor 
     *         = "Scorpiour";
     *     String message
     *         = "Start record data import";
     *     String context
     *         = this.getClass().toString()
     *         + " - for debug data import procedure";
     *     logDebugInfo(executor, message, context);
     * @param executor
     * @param message
     * @param context
     */
    public void logDebug(String executor, String message, String context) {
        debugLogger
        .generalLogMessage(LogTemplate.DEBUG_LOG, executor, message, context);
    }

    /**
     * Used to log debug by customized template
     * for example
     *     String template = "Inspect V:{} generated",
     *     String executor = "Scorpiour",
     *     Vertex vertex = new Vertex(1, 2, 3);
     *     logCustomDebug(template, executor, vertex);
     * @param template
     * @param executor
     * @param args
     */
    public void logCustomDebug(
        String template, String executor, Object ...args) {
        // Format DEBUG label & executor name at the beginning
        String formatted = "DEBUG [{}] " + template;
        debugLogger.customLogMessage(formatted, executor, args);
    }


    /**** Hugegraph data logs ****/
    public void logImportVertex(Object vertex, String dbName) {
        infoLogger
        .generalLogMessage(LogTemplate.IMPORT_VERTEX, vertex, dbName);
    }

    public void logImportEdge(Object edge, String dbName) {
        infoLogger
        .generalLogMessage(LogTemplate.IMPORT_EDGE, edge, dbName);
    }

    /**** Hugegraph compute logs ****/


    /**** Restful API access logs ****/
    /**
     * Restful API Access
     * @param method
     * @param url
     * @param statusCode Response Code
     * @param userId
     * @param roleId
     * @param requestTime
     */
    public void logApiAccess(
        String method, String url, Integer statusCode,
        String userId, String roleId, Long requestTime) {
        infoLogger.generalLogMessage(
                LogTemplate.RESTFUL_ACCESS_LOG,
                method, url, statusCode,
                userId, roleId, requestTime);
    }

    /**** Accumulation Logs ****/
    /**
     * Accumulate how many vertices has been imported
     * @param args
     */
    public void accumulateVerticesImport(Object ...args) {
        AccumulationLogger
        .accumulateAccess(this.targetType, LogTemplate.IMPORT_VERTEX, args);
    }

    public AuditLogger getAuditLogger() {
        return this.auditLogger;
    }

    public CommonLogger getCommonLogger() {
        return this.commonLogger;
    }

    public ServerLogger getServerLogger() {
        return this.serverLogger;
    }

    public ClientLogger getClientLogger() {
        return this.clientLogger;
    }
}
