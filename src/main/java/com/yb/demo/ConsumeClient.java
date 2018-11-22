package com.yb.demo;

/**
 * @author yebin
 */
public class ConsumeClient {
    public static void main(String[] args) throws Exception {
       String message = MqClient.consume();
       System.out.println("获取到的消息为：" + message);
    }
}
