package com.ll.rabbit.topic;

import com.ll.rabbit.work.ConnectionUtil;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;

/**
 * @author LL
 * @date 2019/9/4
 * @description 主题（通配符模式）下的消息发送者
 */
public class Send {

    private final static String EXCHANGE_NAME = "test_exchange_topic";
    public static void main(String[] args) throws Exception{
        //获取到连接以及mq通道
        Connection connection = ConnectionUtil.getConnection();
        Channel channel = connection.createChannel();

        //声明exchange
        channel.exchangeDeclare(EXCHANGE_NAME,"topic",true);

        //消息内容
        String message = "Hello RabbitMQ!";
        channel.basicPublish(EXCHANGE_NAME,"xsada.aaa.1",null,message.getBytes());
        System.out.println(" [x] sent ' " + message + " '");

        channel.close();
        connection.close();
    }
}
