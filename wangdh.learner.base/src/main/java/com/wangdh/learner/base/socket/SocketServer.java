package com.wangdh.learner.base.socket;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author wangdh
 * @Description
 * @date 2018-02-08
 */
public class SocketServer {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(18888);

        System.out.println("server start");

        while(true){
            try(Socket socket = serverSocket.accept();
            OutputStream outputStream = socket.getOutputStream();
            PrintStream printStream = new PrintStream(outputStream)) {
                printStream.print("您好，您收到了来自服务端的春节祝福");
            }
        }
    }
}
