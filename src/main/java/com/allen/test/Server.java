package com.allen.test;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

/**
 * @author Allen
 * @date 2021/6/15 16:07
 */
public class Server {

    public static volatile boolean isExit = false;

    public static void main(String[] args) {
        ServerSocket ss = null;
        try {
            ss = new ServerSocket(8888);
            System.out.println("启动服务器!");
        } catch (IOException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }

        try {
            Socket s = ss.accept();
            System.out.println("客户端:"+s.getInetAddress().getLocalHost()+"已连接到服务器");
            BufferedReader br = new BufferedReader(new InputStreamReader(s.getInputStream()));
            //读取客户端发送来的消息
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(s.getOutputStream()));
            bw.write("你已和服务器建立通信，现在进入你的请求处理线程"+"\n");
            bw.flush();
            Scanner sc  = new Scanner(System.in);

            //服务器端读线程
            Thread readThread = new Thread(){
                public void run(){
                    while(!isExit){

                        try {
                            String msg = br.readLine();
                            if(msg.equals("终止服务")){
                                isExit = true;
                            }
                            System.out.println(msg);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }

                    }
                }
            };

            //服务器端写线程
            Thread writeThread = new Thread(){
                public void run(){
                    while(!isExit){
                        try {
                            bw.write(sc.next()+"\n");
                            bw.flush();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }
            };

            readThread.start();
            writeThread.start();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
