package com.ll.rabbit.route;

import com.ll.rabbit.work.ConnectionUtil;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;

/**
 * @author LL
 * @date 2019/9/4
 * @description 路由模式下的生产者
 */
public class Send {
    private final static String EXCHANGE_NAME = "test_exchange_direct";

    public static void main(String[] args) throws Exception{
        //获取到连接以及mq通道
        Connection connection = ConnectionUtil.getConnection();
        Channel channel = connection.createChannel();

        //声明exchange，参数2是交换机类型
        channel.exchangeDeclare(EXCHANGE_NAME,"direct",false);
        //消息内容
        String message = "查询商品";
        //第二个参数是消息的key
        channel.basicPublish(EXCHANGE_NAME,"delete", null, message.getBytes());
        System.out.println(" [x] sent ' " + message + " '");

        channel.close();
        connection.close();
    }
}
