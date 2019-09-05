package com.ll.rabbit.component;

import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @author LL
 * @date 2019/9/5
 * @description 队列queue1的接收者
 */
@Component
@RabbitListener(queues = "fanout.A")
public class QueueARecv {
    @RabbitHandler
    public void handler(String s){
        System.out.println("QueueAListener: " + s);
    }
}
