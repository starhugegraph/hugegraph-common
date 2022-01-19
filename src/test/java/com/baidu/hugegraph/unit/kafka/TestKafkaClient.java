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

package com.baidu.hugegraph.unit.kafka;

import com.baidu.hugegraph.kafka.ProducerBuilder;
import com.baidu.hugegraph.kafka.ProducerClient;
import com.baidu.hugegraph.kafka.StandardProducerBuilder;
import com.fasterxml.jackson.databind.JsonSerializer;

import org.junit.Test;

public class TestKafkaClient {

    @Test
    public void TestStandardProduce() {
        ProducerClient<String, String> client = new StandardProducerBuilder()
            .setKafkaHost("127.0.0.1")
            .build();
        client.produce("hello", "{ \"key\": \"hello\", \"value\": \"world, this is standardProducer\"}");
    }
    
    @Test
    public void TestRawProducer() {
        ProducerClient<String, String> client = new ProducerBuilder<String, String>()
            .setKafkaHost("127.0.0.1")
            .setValueSerializerClass(JsonSerializer.class)
            .build();

        client.produce("hello", "{ \"key\": \"hello\", \"value\": \"world, this is rawProducer\"}");
    }

}
