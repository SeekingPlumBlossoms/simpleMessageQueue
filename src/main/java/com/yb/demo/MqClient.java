package com.yb.demo;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;

/**
 * @author yebin
 */
public class MqClient {

    public static void produce(String message) throws Exception {
        Socket socket = new Socket(InetAddress.getLocalHost(),BrokerServer.SERVICE_PORT);
        try(
                PrintWriter out = new PrintWriter(socket.getOutputStream());
                ) {
                out.println(message);
                out.flush();
        }
    }

    public static String consume() throws Exception{
        Socket socket = new Socket(InetAddress.getLocalHost(),BrokerServer.SERVICE_PORT);
        try (
                BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                PrintWriter out = new PrintWriter(socket.getOutputStream())
                ){
                out.println("CONSUME");
                out.flush();
                String message = in.readLine();

                return  message;
        }
    }
}
