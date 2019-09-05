package com.ll.rabbit;

import com.ll.rabbit.component.HelloSender1;
import com.ll.rabbit.component.HelloSender2;
import com.ll.rabbit.component.SendObj;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RabbitmqApplicationTests {

    @Autowired
    private HelloSender1 helloSender1;

    @Autowired
    private HelloSender2 helloSender2;

    @Test
    public void contextLoads() {
        for(int i = 0; i < 100 ;i ++) {
            helloSender2.send(i);
            helloSender1.send(i);
        }
    }

    @Autowired
    private SendObj sendObj;

    @Test
    public void testSendObj(){
        sendObj.send();
    }

    @Test
    public void testTopicSend(){
        helloSender1.send1();
        helloSender1.send2();
    }

    @Test
    public void testFanoutSend(){
        helloSender1.send3();
    }

}
