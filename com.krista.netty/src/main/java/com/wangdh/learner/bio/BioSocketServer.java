package com.wangdh.learner.bio;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

/**
 * @Auther: dw_wanghonghong
 * @Date: 2018/8/17 16:33
 * @Description:
 */
public class BioSocketServer {
    private static int port = 8090;

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = null;
        try{
            serverSocket = new ServerSocket(port);
            System.out.println("listen " + port);
            Socket socket = null;
            while (true){
                socket = serverSocket.accept();
                new Thread(new TimeServerHandler(socket)).start();
            }
        }finally {
            if(serverSocket != null){
                serverSocket.close();
                serverSocket = null;
            }
        }
    }

    public static class TimeServerHandler implements Runnable{
        private Socket socket;
        public TimeServerHandler(Socket socket){
            this.socket = socket;
        }

        @Override
        public void run() {
            try(BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()))){
                try(PrintWriter out = new PrintWriter(socket.getOutputStream(),true)){
                    String currentTime = "";
                    String body = "";
                    while (true){
                        body = in.readLine();
                        if(body == null){
                            break;
                        }
                        currentTime = "QUERY TIME ORDER".equalsIgnoreCase(body) ? new Date().toString() : "BAD ORDER";
                        out.println(currentTime);
                    }
                }
            }catch (IOException e){

            }finally {
                if(socket != null){
                    try {
                        socket.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    socket = null;
                }
            }
        }
    }
}
