package com.srw.consumer.mq.rabbit;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * @Description: 消息接收者
 * @Author: songrenwei
 * @Date: 2020/11/9/14:00
 */

@Component
@RabbitListener(queues = "DirectQueue")//监听的队列名称 DirectQueue
public class DirectReceiver3 {

    @RabbitHandler
    public void process(Map testMessage) {
        System.out.println("DirectReceiver3消费者收到消息  : " + testMessage.toString());
    }

}
