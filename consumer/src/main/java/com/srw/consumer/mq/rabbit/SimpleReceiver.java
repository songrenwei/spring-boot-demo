package com.srw.consumer.mq.rabbit;

import com.rabbitmq.client.Channel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

import static java.lang.Math.random;

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
    public void receive(String in, Channel channel, Message message) throws Exception {
        try {
            TimeUnit.SECONDS.sleep(1);
            // 确认收到消息
            channel.basicAck(message.getMessageProperties().getDeliveryTag(), false);
            log.info(" [Simple] Received '{}'", in);
        } catch (Exception e) {
            //消费者告诉队列信息消费失败
            /**
             * 拒绝确认消息:
             * channel.basicNack(long deliveryTag, boolean multiple, boolean requeue) ;
             * deliveryTag:该消息的index
             * multiple：是否批量true:将一次性拒绝所有小于deliveryTag的消息
             * requeue：被拒绝的是否重新入队列
             */
            channel.basicNack(message.getMessageProperties().getDeliveryTag(), false, true);
        }
    }

}
