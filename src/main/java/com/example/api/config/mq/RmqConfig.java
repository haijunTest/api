package com.example.api.config.mq;

import com.example.api.service.mq.RmqMessageListener;
import org.apache.rocketmq.client.consumer.DefaultMQPushConsumer;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * class $classname
 *
 * @author haijun
 * @date 2018/5/25, 17:26
 */
@Configuration
@EnableConfigurationProperties(value = RmqProperties.class)
public class RmqConfig {

    private RmqProperties rmqProperties;

    @Autowired
    public RmqConfig(RmqProperties rmqProperties) {
        this.rmqProperties = rmqProperties;
    }

    @Bean
    public RmqMessageListener rmqMessageListener() {
        return new RmqMessageListener();
    }

    @Bean
    public DefaultMQProducer defaultMQProducer() throws Exception {
        DefaultMQProducer defaultMQProducer = new DefaultMQProducer();
        defaultMQProducer.setNamesrvAddr(rmqProperties.getProducer().getNamesrvAddr());
        defaultMQProducer.setProducerGroup(rmqProperties.getProducer().getProducerGroup());
        defaultMQProducer.start();
        return defaultMQProducer;
    }

    @Bean
    public DefaultMQPushConsumer defaultMQPushConsumer() throws Exception {
        String[] myTopics = rmqProperties.getConsumer().getTopics().get("my-listening-topic").split(",");
        Map<String, String> topic = new HashMap<>();
        Arrays.stream(myTopics).forEach(data -> topic.put(data, ""));

        DefaultMQPushConsumer defaultMQPushConsumer = new DefaultMQPushConsumer();
        defaultMQPushConsumer.setNamesrvAddr(rmqProperties.getConsumer().getNamesrvAddr());
        defaultMQPushConsumer.setConsumerGroup(rmqProperties.getConsumer().getConsumerGroup());
        defaultMQPushConsumer.setSubscription(topic);
        defaultMQPushConsumer.registerMessageListener(rmqMessageListener());
        defaultMQPushConsumer.start();
        return defaultMQPushConsumer;
    }
}
