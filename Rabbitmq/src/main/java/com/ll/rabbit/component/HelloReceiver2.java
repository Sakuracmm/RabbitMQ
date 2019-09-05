package com.ll.rabbit.component;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @author LL
 * @date 2019/9/4
 * @description 接收者
 */
@Component
@RabbitListener(queues = "hello")
public class HelloReceiver2 {

    @RabbitHandler
    public void process1(String hello){
        System.out.println("Receiver2: " + hello);
    }
}
