package com.ll.rabbit.spring;

/**
 * @author LL
 * @date 2019/9/4
 * @description 消费者
 */
public class Foo {
    //具体执行业务的方法
    public void listen(String foo){
        System.out.println("\n消费者： " + foo + "\n");
    }
}
