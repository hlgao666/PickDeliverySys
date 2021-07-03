package com.allen.test;

import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

/**
 * @author Allen
 * @date 2021/6/15 16:07
 */
public class Client {

    public static void main(String[] args) {
        try {
            Socket s = new Socket("127.0.0.1",8888);

            //构建IO
            InputStream is = s.getInputStream();
            OutputStream os = s.getOutputStream();
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(os));
            BufferedReader br = new BufferedReader(new InputStreamReader(is));
            Scanner sc = new Scanner(System.in);

            //客户端读线程
            Thread readThread = new Thread(){
                public void run(){
                    while(true){
                        String msg = null;
                        try {
                            msg = br.readLine();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        System.out.println(msg);
                    }
                }
            };

            //客户端写线程
            Thread writeThread = new Thread(){
                public void run(){
                    while(true){
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
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
