package com.srw.consumer.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Description: mp配置
 * @Author: songrenwei
 * @Date: 2020/11/9/13:56
 */
@Configuration
public class DirectRabbitConfig {

    @Bean
    public Queue DirectQueue() {
        return new Queue("DirectQueue",true);
    }

    @Bean
    DirectExchange DirectExchange() {
        return new DirectExchange("DirectExchange",true,false);
    }

    @Bean
    Binding bindingDirect() {
        return BindingBuilder.bind(DirectQueue()).to(DirectExchange()).with("DirectRouting");
    }

}
