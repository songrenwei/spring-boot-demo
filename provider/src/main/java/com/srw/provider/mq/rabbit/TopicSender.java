package com.srw.provider.mq.rabbit;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

/**
 * @Description:
 * @Author: renwei.song
 * @Date: 2021/3/16 11:16
 */
@Slf4j
@Component
@RequiredArgsConstructor
public class TopicSender {

    private final RabbitTemplate template;
    private static final String EXCHANGE_NAME = "exchange.topic";
    private final String[] keys =
            {"quick.orange.rabbit", "lazy.orange.elephant", "quick.orange.fox",
            "lazy.brown.fox", "lazy.pink.rabbit", "quick.brown.fox", "1.orange.1", "1.1.rabbit", "lazy.123.123", "lazy."};

    public void send(int index, String message) {
        template.convertAndSend(EXCHANGE_NAME, keys[index], message+"-"+keys[index]);

        log.info(" [topic] Sent '{}'", message);
    }

}
