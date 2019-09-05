package com.ll.rabbit.component;

import java.util.Date;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author LL
 * @date 2019/9/4
 * @description rabbitTemplate是SpringBoot提供的默认实现
 */
@Component
public class HelloSender2 {
    @Autowired
    private AmqpTemplate rabbitTemplate;

    public void send(int i){
        String context = "hello" + new Date();
        System.out.println("Sender2: " + context + " " + i);
        //参数1是队列名，参数2是消息内容
        this.rabbitTemplate.convertAndSend("hello",context + i);
    }
}
