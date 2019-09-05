package com.ll.rabbit.publicSubscribe;

import com.ll.rabbit.work.ConnectionUtil;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.QueueingConsumer;

/**
 * @author LL
 * @date 2019/9/4
 * @description 发布订阅消费者1 //看做是搜索系统
 */
public class Recv2 {
    private final static String Queue_NAME = "test_queue_work2";
    private final static String EXCHANGE_NAME = "test_exchange_fanout";
    public static void main(String[] args) throws Exception{
        //获取到连接以及mq通道
        Connection connection = ConnectionUtil.getConnection();
        Channel channel = connection.createChannel();

        //声明队列
        channel.queueDeclare(Queue_NAME,false,false,false,null);

        //绑定队列与交换机
        channel.queueBind(Queue_NAME,EXCHANGE_NAME,"");

        //同一时刻服务器只会发送一条消息给消费者
        channel.basicQos(1);

        //定义队列的消费者
        QueueingConsumer consumer = new QueueingConsumer(channel);
        //监听队列，手动返回完成
        channel.basicConsume(Queue_NAME,false,consumer);

        //获取消息
        while(true){
            QueueingConsumer.Delivery delivery = consumer.nextDelivery();
            String message = new String(delivery.getBody());
            System.out.println(" [Rev] Received ' "  + message + " '");
            Thread.sleep(10);
            channel.basicAck(delivery.getEnvelope().getDeliveryTag(),false);
        }
    }
}
