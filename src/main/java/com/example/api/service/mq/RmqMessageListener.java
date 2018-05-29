package com.example.api.service.mq;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.parser.Feature;
import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyContext;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyStatus;
import org.apache.rocketmq.client.consumer.listener.MessageListenerConcurrently;
import org.apache.rocketmq.common.message.MessageExt;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * class $classname
 *
 * @author haijun
 * @date 2018/5/25, 17:31
 */
@Slf4j
@Component
public class RmqMessageListener implements MessageListenerConcurrently {

    @Override
    public ConsumeConcurrentlyStatus consumeMessage(List<MessageExt> msgs, ConsumeConcurrentlyContext context) {
        MessageExt message = msgs.get(0);
        if ("my-topic".equals(message.getTopic())) {
            Object o = JSON.parseObject(message.getBody(), String.class, Feature.AutoCloseSource);
            log.info("haijun's mq is consume success="+ o.toString());
            return ConsumeConcurrentlyStatus.CONSUME_SUCCESS;
        }
        return ConsumeConcurrentlyStatus.RECONSUME_LATER;
    }

}
