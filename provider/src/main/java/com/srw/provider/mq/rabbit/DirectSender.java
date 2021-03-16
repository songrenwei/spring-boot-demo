package com.srw.provider.mq.rabbit;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

import static java.lang.Math.random;

/**
 * @Description:
 * @Author: renwei.song
 * @Date: 2021/3/15 18:05
 */
@Slf4j
@Component
@RequiredArgsConstructor
public class DirectSender {

    private final RabbitTemplate template;
    private static final String EXCHANGE_NAME = "exchange.direct";
    private final String[] keys = {"dog", "cat", "pig"};

    public void send(String message) {
        int random = (int)(random()*3);
        template.convertAndSend(EXCHANGE_NAME, keys[random], message+"-"+keys[random]);
        log.info(" [Direct] Sent '{}'", message);
    }

}
