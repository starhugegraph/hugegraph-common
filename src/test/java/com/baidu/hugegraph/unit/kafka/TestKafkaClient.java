package com.baidu.hugegraph.unit.kafka;

import com.baidu.hugegraph.kafka.ProducerBuilder;
import com.baidu.hugegraph.kafka.ProducerClient;
import com.fasterxml.jackson.databind.JsonSerializer;

import org.junit.Test;

public class TestKafkaClient {

    @Test
    public void TestBasicProduce() {
        ProducerClient client = new ProducerBuilder()
            .setKafkaHost("127.0.0.1")
            .build();
        client.produce("hello", "{ \"key\": \"hello\", \"value\": \"world\"}");
    }
    
    @Test
    public void TestJsonSerializer() {
        ProducerClient client = new ProducerBuilder()
            .setKafkaHost("127.0.0.1")
            .setValueSerializerClass(JsonSerializer.class)
            .build();

        client.produce("hello", "{ \"key\": \"hello\", \"value\": \"world\"}");
    }

}
