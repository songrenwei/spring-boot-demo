package com.srw.provider.mq;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

/**
 * @Description: 消息发送者
 * @Author: renwei.song
 * @Date: 2021/3/12 17:04
 */
@Slf4j
@Component
@RequiredArgsConstructor
public class SimpleSender {

    private final RabbitTemplate template;

    private static final String QUEUE_NAME = "simple.hello";

    public void send(String message) {
        template.convertAndSend(QUEUE_NAME, message);
        log.info(" [Simple] Sent '{}'", message);
    }

}
