package com.srw.consumer.mq;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @Description: 消息接受者
 * @Author: renwei.song
 * @Date: 2021/3/12 17:05
 */
@Slf4j
@Component
@RabbitListener(queues = "simple.hello")
public class SimpleReceiver {

    @RabbitHandler
    public void receive(String in) {
        log.info(" [Simple] Received '{}'", in);
    }

}
