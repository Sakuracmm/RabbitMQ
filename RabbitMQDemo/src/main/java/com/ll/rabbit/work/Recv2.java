package com.ll.rabbit.work;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.QueueingConsumer;

/**
 * @author LL
 * @date 2019/9/4
 * @description 第二个消费者
 */
public class Recv2 {
    private final static String QUEUE_NAME="q_test_02";
    public static void main(String[] argv) throws Exception{
        //获取到连接以及mq通道
        Connection connection = ConnectionUtil.getConnection();
        Channel channel = connection.createChannel();
        //声明队列
        channel.queueDeclare(QUEUE_NAME,false,false,false,null);
        //同一时刻服务器只会发出一条消息给消费者   //开启表示在未收到确认消息的情况下不会像该消费者再消费数据
        channel.basicQos(1);
        //定义队列的消费者
        QueueingConsumer consumer = new QueueingConsumer(channel);

        //监听队列，false表示手动返回完成状态，true表示自动返回
//        channel.basicConsume(QUEUE_NAME,true,consumer);
        channel.basicConsume(QUEUE_NAME,false,consumer);

        //获取消息
        while(true){
            QueueingConsumer.Delivery delivery = consumer.nextDelivery();
            String message = new String(delivery.getBody());
            System.out.println(" [y] Received ' " + message + " ' ");
            //休眠
            Thread.sleep(10);
            //返回确认状态。注释表示使用自动确认模式 “能者多劳”模式下徐要改为手动确认
            channel.basicAck(delivery.getEnvelope().getDeliveryTag(),false);
        }

    }
}
