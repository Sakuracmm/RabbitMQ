package com.ll.rabbit.component;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @author LL
 * @date 2019/9/5
 * @description topic 下的消息接受者
 */
@Component
@RabbitListener(queues = "topic.messages")
public class TopicReceiver2 {

    @RabbitHandler
    public void handler(String s){
        System.out.println("TopicReceiver2: " + s);
    }


}
