package com.ll.rabbit.component;

import java.util.Date;

import com.ll.rabbit.entries.User;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author LL
 * @date 2019/9/4
 * @description rabbitTemplate是SpringBoot提供的默认实现
 */
@Component
public class SendObj {
    @Autowired
    private AmqpTemplate rabbitTemplate;

    public void send(){
        User user = new User();
        user.setAge(11);
        user.setUsername("Alice");
        String context = "User" + user;
        System.out.println("Sender2: " + user);
        //参数1是队列名，参数2是消息内容
        this.rabbitTemplate.convertAndSend("obj_queue",context);
    }
}
