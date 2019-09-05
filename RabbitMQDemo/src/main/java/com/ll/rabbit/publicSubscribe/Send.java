package com.ll.rabbit.publicSubscribe;

import com.ll.rabbit.work.ConnectionUtil;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;

/**
 * @author LL
 * @date 2019/9/4
 * @description 发布/订阅者模式中的消息生产者
 */
public class Send {
    private final static String EXCHANGE_NAME = "test_exchange_fanout";
    public static void main(String[] args) throws Exception{
        //获取到连接以及mq通道
        Connection connection = ConnectionUtil.getConnection();
        Channel channel = connection.createChannel();

        //声明exchange
        channel.exchangeDeclare(EXCHANGE_NAME,"fanout");

        //消息内容
        String message = "Hello RabbitMQ!";
        //第一个参数表示交换机名称，第二个参数表示队列名称，参数是否为空串表示使用哪种方式发送消息
        for(int i = 0 ; i < 50; i ++) {
            channel.basicPublish(EXCHANGE_NAME, "", null, (message + " " + i).getBytes());
            System.out.println(" [x] Sent ' " + message + " ' ");
        }
        channel.close();
        connection.close();
    }
}
