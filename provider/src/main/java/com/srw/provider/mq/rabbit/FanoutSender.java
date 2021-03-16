package com.srw.provider.mq.rabbit;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

/**
 * @Description:
 * @Author: renwei.song
 * @Date: 2021/3/15 13:43
 */
@Slf4j
@Component
@RequiredArgsConstructor
public class FanoutSender {

    private final RabbitTemplate template;

    private static final String EXCHANGE_NAME = "exchange.fanout";

    public void send(String message) {
        template.convertAndSend(EXCHANGE_NAME, StringUtils.EMPTY, message);
        log.info(" [Fanout] Sent '{}'", message);
    }

}
