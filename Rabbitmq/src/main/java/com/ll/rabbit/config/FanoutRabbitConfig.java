package com.ll.rabbit.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author LL
 * @date 2019/9/5
 * @description Fanout就是熟悉的广播模式或者订阅者模式，给Fanout交换机发送消息，那么绑定了这个交换机的所有队列都会收到消息
 */
@Configuration
public class FanoutRabbitConfig {
    @Bean
    public Queue AMessage(){
        return new Queue("fanout.A");
    }
    @Bean
    public Queue BMessage(){
        return new Queue("fanout.B");
    }
    @Bean
    public Queue CMessage(){
        return new Queue("fanout.C");
    }

    @Bean
    FanoutExchange fanoutExchange(){
        return new FanoutExchange("fanoutExchange");
    }

    @Bean
    Binding bindingExchangeA(Queue AMessage,FanoutExchange fanoutExchange){
        return BindingBuilder.bind(AMessage).to(fanoutExchange);
    }

    @Bean
    Binding bindingExchangeB(Queue BMessage,FanoutExchange fanoutExchange){
        return BindingBuilder.bind(BMessage).to(fanoutExchange);
    }

    @Bean
    Binding bindingExchangeC(Queue CMessage,FanoutExchange fanoutExchange){
        return BindingBuilder.bind(CMessage).to(fanoutExchange);
    }
}
