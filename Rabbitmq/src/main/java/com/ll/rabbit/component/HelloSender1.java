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
public class HelloSender1 {
    @Autowired
    private AmqpTemplate rabbitTemplate;

    public void send(int i){
        String context = "hello" + new Date();
        System.out.println("Sender1: " + context + " " + i);
        //参数1是队列名，参数2是消息内容
        this.rabbitTemplate.convertAndSend("hello",context + i);
    }

    public void send1(){
        String context = "hi , i am messages1";
        System.out.println("Sender: " + context);
        //如果指定了参数2（也就是route key,那么参数1不再表示队列名而是表示topic名，再根据交换机对应的规则将消息发送到对应的队列上去）
        this.rabbitTemplate.convertAndSend("exchange","topic.message",context);
    }
    public void send2(){
        String context = "hi , i am messages2";
        System.out.println("Sender: " + context);
        this.rabbitTemplate.convertAndSend("exchange","topic.hellorabbitmq",context);
    }

    public void send3(){
        String context = "hi, fanout msg";
        System.out.println("Semder1.send3() : " + context);
        //注意必须写上第二个参数，虽然在Fanout交换机上，无论指定什么样的route_key都会被忽略，
        //但是如果不指定参数2，那么参数1就会被当做队列名处理
        this.rabbitTemplate.convertAndSend("fanoutExchange","",context);
    }
}