package com.yb.demo;

/**
 * @author yebin
 */
public class ProduceClient {
    public static void main(String[] args) throws  Exception{
        MqClient.produce("hello world");
    }
}
