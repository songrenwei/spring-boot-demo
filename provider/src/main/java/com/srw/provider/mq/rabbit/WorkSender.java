package com.srw.provider.mq.rabbit;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

/**
 * @Description:
 * @Author: renwei.song
 * @Date: 2021/3/12 17:24
 */
@Slf4j
@Component
@RequiredArgsConstructor
public class WorkSender {

    private final RabbitTemplate template;
    private static final String QUEUE_NAME = "work.hello";

    public void send(String message) {
        template.convertAndSend(QUEUE_NAME, message);
        log.info(" [work] Sent '{}'", message);
    }

}
