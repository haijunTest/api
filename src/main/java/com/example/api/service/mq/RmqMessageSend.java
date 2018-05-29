package com.example.api.service.mq;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.client.consumer.DefaultMQPushConsumer;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.client.producer.SendStatus;
import org.apache.rocketmq.common.message.Message;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * class $classname
 *
 * @author haijun
 * @date 2018/5/25, 18:00
 */
@Slf4j
@Component
public class RmqMessageSend {

    @Resource(name = "defaultMQProducer")
    private DefaultMQProducer defaultMQProducer;
    @Resource(name = "defaultMQPushConsumer")
    private DefaultMQPushConsumer defaultMQPushConsumer;

    private void send(Message msg) {
        try {
            SendResult sendResult = this.defaultMQProducer.send(msg);
            SendStatus sendStatus = sendResult.getSendStatus();
            if (!SendStatus.SEND_OK.equals(sendStatus)) {
                log.error("send message {} failed, SendStatus {}, SendResult {}", sendStatus, sendResult);
            }
        } catch (Throwable e) {
            log.error("send message:{} error, error is:{}", msg, e.getLocalizedMessage());
            if (log.isDebugEnabled()) {
                e.printStackTrace();
            }
        }
    }

    public void sendMq(String str) {
        Message msg = new Message("my-topic", null, null, JSON.toJSONBytes(str, SerializerFeature.QuoteFieldNames));
        this.send(msg);
    }
}
