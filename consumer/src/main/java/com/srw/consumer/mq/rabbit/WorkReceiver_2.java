package com.srw.consumer.mq.rabbit;

import com.rabbitmq.client.Channel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

/**
 * Created by macro on 2020/5/19.
 */
@Slf4j
@Component
@RabbitListener(queues = "work.hello")
public class WorkReceiver_2 {

    @RabbitHandler
    public void receive(String in, Channel channel, Message message) throws IOException, InterruptedException {
        TimeUnit.SECONDS.sleep(2);// 睡2秒
        try {
            // 确认收到一条消息
            channel.basicAck(message.getMessageProperties().getDeliveryTag(), false);
            log.info(" [work2] Received '{}'", in);
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
