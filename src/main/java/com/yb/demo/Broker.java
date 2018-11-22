package com.yb.demo;

import java.util.concurrent.ArrayBlockingQueue;

/**
 * @author yebin
 */
public class Broker {

    /**
     *  消息存储消息的最大数量
     */
    private final static int MAX_SIZE=3;
    /**
     *  保存消息数据的容器
     */
    private  static ArrayBlockingQueue<String> messagesQueue = new ArrayBlockingQueue<String>(MAX_SIZE);

    public static void produce(String msg){
        if(messagesQueue.offer(msg)){
            System.out.println("成功向消息中心投递消息：" + msg + ",当前暂存的消息的数量是：" + messagesQueue.size());
        }else {
            System.out.println("消息处理中心内暂存的消息达到最大负荷，不能继续放入消息！");
        }
        System.out.println("======================================================");
    }

    public static String consume(){
        String msg = messagesQueue.poll();

        if(msg != null){
            System.out.println("已经消费消息：" + msg + ",当前暂存的消息数量为：" + messagesQueue.size());
        }else {
            System.out.println("消息处理中心内没有消息可供消费");
        }

        System.out.println("======================================================");
        return msg;

    }

}
