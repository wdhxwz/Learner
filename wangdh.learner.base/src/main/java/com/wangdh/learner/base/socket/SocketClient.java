package com.wangdh.learner.base.socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.Socket;

/**
 * @author wangdh
 * @Description
 * @date 2018-02-08
 */
public class SocketClient {
    public static void main(String[] args) throws IOException {
        try(
        Socket socket = new Socket("127.0.0.1",18888);
        InputStream inputStream = socket.getInputStream();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream))) {
            String response = bufferedReader.readLine();
            System.out.println(response);
        }
    }
}
