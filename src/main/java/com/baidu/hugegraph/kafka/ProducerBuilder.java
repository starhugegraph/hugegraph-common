package com.baidu.hugegraph.kafka;

import java.util.Properties;

import com.google.common.base.Strings;

import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;

public class ProducerBuilder {


    private String kafkaHost = "";
    private String kafkaPort = "9092";
    private Class<?> keySerializer = StringSerializer.class;
    private Class<?> valueSerializer = StringSerializer.class;

    private void validateOptions() throws IllegalArgumentException {
        if (Strings.isNullOrEmpty(kafkaHost)) {
            throw new IllegalArgumentException("Missing kafka host");
        }
        if (Strings.isNullOrEmpty(kafkaPort)) {
            throw new IllegalArgumentException("Missing kafka port");
        }
    }

    public ProducerBuilder setKafkaHost(String host) {
        if (!Strings.isNullOrEmpty(host)) {
            this.kafkaHost = host;
        }
        return this;
    }

    public ProducerBuilder setKafkaPort(String port) {
        if (!Strings.isNullOrEmpty(port)) {
            this.kafkaPort = port;
        }
        return this;
    }

    public ProducerBuilder setKeySerializerClass(Class<?> clazz) {

        return this;
    }

    public ProducerBuilder setValueSerializerClass(Class<?> clazz) {

        return this;
    }

    public ProducerClient build() throws IllegalArgumentException {

        this.validateOptions();

        Properties props = new Properties();

        String bootStrapServer = this.kafkaHost + ":" + this.kafkaPort;

        props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, bootStrapServer);
        props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, this.valueSerializer.getName());
        props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, this.keySerializer.getName());

        ProducerClient client = new ProducerClient(props);

        return client;
    }
    
}
