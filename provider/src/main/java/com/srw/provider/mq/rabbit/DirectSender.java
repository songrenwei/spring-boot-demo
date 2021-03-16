package com.srw.provider.mq.rabbit;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

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

    public void send(int index, String message) {
        if (index % 2 == 0) {
            template.convertAndSend(EXCHANGE_NAME, "11", message);
        } else {
            template.convertAndSend(EXCHANGE_NAME, "20", message);
        }

        log.info(" [direct] Sent '{}'", message);
    }

}
