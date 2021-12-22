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

import java.lang.reflect.Field;
import java.lang.reflect.Method;

import com.baidu.hugegraph.event.Event;

/**
 * Provide HugeGraph-Common log methods
 * @author Scorpiour
 * @since 2021-12-21
 */
public class CommonLogger {

    private final MethodLogger<MethodLogger.LevelInfo> infoLogger;
    private final MethodLogger<MethodLogger.LevelWarn> warnLogger;
    private final MethodLogger<MethodLogger.LevelError> errorLogger;

    public CommonLogger(Class<?> targetType) {

        infoLogger = MethodLoggerFactory
                .getMethodLogger(MethodLogger.LevelInfo.class, targetType);

        warnLogger = MethodLoggerFactory
                .getMethodLogger(MethodLogger.LevelWarn.class, targetType);

        errorLogger = MethodLoggerFactory
                .getMethodLogger(MethodLogger.LevelError.class, targetType);
    }

    /**** Hugegraph common logs ****/
    /**
     * PausableScheduledThreadPool paused
     */
    public void logThreadPaused() {
        infoLogger
        .generalLogMessage(LogTemplate.PAUSABLE_THREAD_PAUSED);
    }

    /**
     * PausableScheduledThreadPool resumed
     */
    public void logThreadResumed() {
        infoLogger
        .generalLogMessage(LogTemplate.PAUSABLE_THREAD_RESUMED);
    }

    /**
     * PausableScheduledThreadPool interrupted
     */
    public void logThreadInterrupted() {
        warnLogger
        .generalLogMessage(LogTemplate.PAUSABLE_THREAD_INTERRUPTED);
    }

    /**
     * Waste time costs
     * @param cost
     * @param baseCost
     * @param name
     * @param eachCost
     */
    public void logWasteTimeCost(
        Double cost, Double baseCost, String name, Long eachCost) {
        infoLogger
        .generalLogMessage(
            LogTemplate.WASTE_TIME_COST,
            cost, baseCost, name, eachCost);
    }

    /**
     * Redundant option of config
     * @param key
     */
    public void logRedundantOption(String key) {
        warnLogger
        .generalLogMessage(LogTemplate.REDUNDANT_CONFIG_OPTION, key);
    }

    /**
     * No static method in specified class
     * @param holder
     * @param methodName
     */
    public void logNoStaticMethod(String holder, String methodName) {
        warnLogger
        .generalLogMessage(LogTemplate.NO_STATIC_METHOD, holder, methodName);
    }

    /**
     * Target method cannot be called in specified class
     * @param holder
     * @param methodName
     */
    public void logCannotCallMethod(String holder, String methodName) {
        warnLogger
        .generalLogMessage(
            LogTemplate.CANNOT_CALL_METHOD, methodName, holder);
    }

    /**
     * No access permission of target method
     * @param holder
     * @param methodName
     */
    public void logIllegalAccess(String holder, String methodName) {
        warnLogger
        .generalLogMessage(LogTemplate.ILLEGAL_ACCESS, methodName, holder);
    }

    /**
     * Option has been registered
     * @param moduleName
     * @param module
     */
    public void logAlreadyRegistered(String moduleName, Class<?> module) {
        warnLogger
        .generalLogMessage(
            LogTemplate.ALREADY_REGISTERED, moduleName, module);
    }

    /**
     * Option registered failed
     * @param exc
     * @param field
     */
    public void logRegisterOptionFailed(Exception e, Field field) {
        errorLogger
        .generalLogMessage(LogTemplate.REGISTER_OPTION_FAILED, field, e);
    }

    /**
     * Invalid option that the type is not matching
     * @param value
     * @param name
     * @param e
     */
    public void logInvalidOptionType(String value, String name, Exception e) {
        errorLogger
        .generalLogMessage(
            LogTemplate.INVALID_OPTION_TYPE,
            value, name, e);
    }

    /**
     * Failed to handle event
     * @param event
     * @param ignored
     */
    public void logHandleEventFailed(Event event, Throwable ignored) {
        warnLogger
        .generalLogMessage(
            LogTemplate.HANDLE_EVENT_FAILED, event, ignored);
    }

    public void logCloseStreamFailed(Exception e) {
        warnLogger
        .generalLogMessage(LogTemplate.CLOSE_STREAM_FAILED, e);
    }
}
