package com.wangdh.learner.bio;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * @Auther: dw_wanghonghong
 * @Date: 2018/8/17 16:34
 * @Description:
 */
public class BioSocketClient {
    private static int port = 8090;
    public static void main(String[] args){
        int times = 0 ;

        while (true) {
            Socket socket = null;
            try {
                socket = new Socket("127.0.0.1", port);
                try (BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()))) {
                    try (PrintWriter out = new PrintWriter(socket.getOutputStream(), true)) {
                        out.println("QUERY TIME ORDER");
                        String respo = in.readLine();
                        System.out.println(respo);
                    }
                }
            } catch (Exception ex) {

            } finally {
                if (socket != null) {
                    try {
                        socket.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    socket = null;
                }
            }
            times ++;
            if(times > 10000){
                System.out.println("end...");
                break;
            }
        }
    }
}
