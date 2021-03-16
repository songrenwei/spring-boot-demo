package com.srw.consumer.config;

import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.config.SimpleRabbitListenerContainerFactory;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.listener.RabbitListenerContainerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Description: RabbitMQ五种消息模式
 * @Author: renwei.song
 * @Date: 2021/3/12 16:57
 */
@Configuration
public class RabbitMqConfig {

//    @Bean
//    public CachingConnectionFactory connectionFactory() {
//        CachingConnectionFactory connectionFactory = new CachingConnectionFactory("127.0.0.1", 5672);
//        connectionFactory.setUsername("srw");
//        connectionFactory.setPassword("srw");
//        connectionFactory.setVirtualHost("/srw");
//        return connectionFactory;
//    }
//
//    @Bean
//    public RabbitListenerContainerFactory<?> rabbitListenerContainerFactory(CachingConnectionFactory connectionFactory){
//        SimpleRabbitListenerContainerFactory factory = new SimpleRabbitListenerContainerFactory();
//        factory.setConnectionFactory(connectionFactory);
////        factory.setMessageConverter(new Jackson2JsonMessageConverter());
//        factory.setAcknowledgeMode(AcknowledgeMode.MANUAL);
//        return factory;
//    }

    //*****************************简单模式**************************
    @Bean
    public Queue hello() {
        return new Queue("simple.hello");
    }

    //*****************************工作模式**************************
    @Bean
    public Queue workQueue() {
        return new Queue("work.hello");
    }

    //*****************************发布/订阅模式**************************
    @Bean
    public FanoutExchange fanout() {
        return new FanoutExchange("exchange.fanout");
    }

    @Bean
    public Queue fanoutQueue1() {
        return new Queue("fanout.hello.1");
    }

    @Bean
    public Queue fanoutQueue2() {
        return new Queue("fanout.hello.2");
    }

    @Bean
    public Binding fanoutBinding1() {
        return BindingBuilder.bind(fanoutQueue1()).to(fanout());
    }

    @Bean
    public Binding fanoutBinding2() {
        return BindingBuilder.bind(fanoutQueue2()).to(fanout());
    }

    //*****************************路由模式**************************
    @Bean
    public DirectExchange direct() {
        return new DirectExchange("exchange.direct");
    }

    @Bean
    public Queue directQueue1() {
        return new Queue("direct.hello.1");
    }

    @Bean
    public Queue directQueue2() {
        return new Queue("direct.hello.2");
    }

    @Bean
    public Binding directBinding1a() {
        return BindingBuilder.bind(directQueue1()).to(direct()).with("10");
    }

    @Bean
    public Binding directBinding1b() {
        return BindingBuilder.bind(directQueue1()).to(direct()).with("11");
    }

    @Bean
    public Binding directBinding2() {
        return BindingBuilder.bind(directQueue2()).to(direct()).with("20");
    }

    //*****************************通配符模式**************************

    @Bean
    public TopicExchange topic() {
        return new TopicExchange("exchange.topic");
    }

    @Bean
    public Queue topicQueue1() {
        return new Queue("topic.hello.1");
    }

    @Bean
    public Queue topicQueue2() {
        return new Queue("topic.hello.2");
    }

    @Bean
    public Binding topicBinding1a() {
        return BindingBuilder.bind(topicQueue1()).to(topic()).with("*.orange.*");
    }

    @Bean
    public Binding topicBinding1b() {
        return BindingBuilder.bind(topicQueue1()).to(topic()).with("*.*.rabbit");
    }

    @Bean
    public Binding topicBinding2a() {
        return BindingBuilder.bind(topicQueue2()).to(topic()).with("lazy.#");
    }

}
