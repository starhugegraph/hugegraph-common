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

package com.baidu.hugegraph.kafka;

import java.util.Properties;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;
/**
 * Kafka client
 * @author Scorpiour
 * @since 2022-01-18
 */
public class ProducerClient {

    private final KafkaProducer<String, String> producer;
    public final static String TOPIC = "hugegraph-nospace-default";

    protected ProducerClient(Properties props) {
        
        producer = new KafkaProducer<>(props);
    }

    public void produce(String key, String value) {
        try {
            ProducerRecord<String, String> record = new ProducerRecord<>(TOPIC, 0, key, value);
            RecordMetadata meta = this.producer.send(record).get();
            System.out.println(meta);
        } catch (Exception e) {

        }
        producer.flush();
    }
    
}
