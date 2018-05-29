package com.example.api.config.mq;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.Map;

/**
 * class $classname
 *
 * @author haijun
 * @date 2018/5/25, 17:16
 */
@Data
@ConfigurationProperties(prefix = "mq.rmq", ignoreUnknownFields = true)
public class RmqProperties {

    private Producer producer;
    private Consumer consumer;

    @Data
    public static class Producer {
        private String namesrvAddr;
        private String producerGroup;
    }

    @Data
    public static class Consumer {
        private Map<String, String> topics;
        private String namesrvAddr;
        private String consumerGroup;
    }
}
