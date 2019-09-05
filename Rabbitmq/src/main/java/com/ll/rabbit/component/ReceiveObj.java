package com.ll.rabbit.component;

import com.ll.rabbit.entries.User;
import org.omg.CORBA.StringHolder;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @author LL
 * @date 2019/9/4
 * @description 接收者
 */
@Component
@RabbitListener(queues = "obj_queue")
public class ReceiveObj {

    @RabbitHandler
    public void process(String user){
        System.out.println("ReceiveObj: " + user);
    }
}
