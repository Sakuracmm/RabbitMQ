package com.ll.rabbit.config;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author LL
 * @date 2019/9/4
 * @description Rabbit队列设置
 */
@Configuration
public class RabbitConfig {

    @Bean
    public Queue queue1(){
        return new Queue("hello");
    }

    @Bean
    public Queue queue2(){
        return new Queue("obj_queue");
    }
}
