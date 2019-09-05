package com.ll.rabbit.work;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;

/**
 * @author LL
 * @date 2019/9/4
 * @description 生产者发送消息到消息队列
 */
public class Send {
    private final static String QUEUE_NAME = "q_test_02";

    public static void main(String[] args) throws Exception {
        //获取到连接以及mq通道
        Connection connection = ConnectionUtil.getConnection();
        //从连接中创建通道
        Channel channel = connection.createChannel();
        //声明/创建队列
        channel.queueDeclare(QUEUE_NAME, false, false, false, null);
        //消息内容
        String message = "Hello Alice!";
        for (int i = 0; i < 10; i++) {
            channel.basicPublish("", QUEUE_NAME, null, (message + " " + i).getBytes());
            System.out.println(" [x] Sent ' " + message + " '");
        }
        //关闭通道和连接
        channel.close();
        connection.close();
    }
}
