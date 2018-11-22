package com.yb.demo;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.rmi.server.ExportException;

/**
 * @author yebin
 */
public class BrokerServer implements Runnable {

    public static int SERVICE_PORT = 9999;

    private final Socket socket;

    public BrokerServer(Socket socket){
        this.socket=socket;
    }

    @Override
    public void run() {
        try(
                BufferedReader in=new BufferedReader(new InputStreamReader(socket.getInputStream()));
                PrintWriter out = new PrintWriter(socket.getOutputStream())
            ) {
                while (true){
                    String str = in.readLine();
                    if (str == null ){
                        continue;
                    }
                    System.out.println("接受到的原始数据为：" + str);

                    if(str.equals("CONSUME")){
                        String message = Broker.consume();
                        out.println(message);
                        out.flush();
                    }else {
                        Broker.produce(str);
                    }

                }

        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws Exception {
        ServerSocket serverSocket = new ServerSocket(SERVICE_PORT);
        while (true){
            BrokerServer brokerServer = new BrokerServer(serverSocket.accept());
            new Thread(brokerServer).start();
        }
    }
}
