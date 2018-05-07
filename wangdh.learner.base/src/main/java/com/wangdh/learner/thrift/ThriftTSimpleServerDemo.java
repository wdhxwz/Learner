package com.wangdh.learner.thrift;

import org.apache.thrift.TProcessor;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.server.TServer;
import org.apache.thrift.server.TServer.Args;
import org.apache.thrift.server.TSimpleServer;
import org.apache.thrift.transport.TServerSocket;

/**
 * 单线程服务模型，一般用于测试  TSimpleServer服务端
 */
public class ThriftTSimpleServerDemo {
    public static final int SERVER_PORT = 9898;

    public void startServer() {
        try {
            System.out.println("HelloWorld THsHaServer start ....");

            TProcessor tprocessor = new Hello.Processor<Hello.Iface>(
                    new HelloWorldImpl());

            // 简单的单线程服务模型，一般用于测试
            TServerSocket serverTransport = new TServerSocket(SERVER_PORT);
            Args tArgs = new Args(serverTransport);
            tArgs.processor(tprocessor);
            tArgs.protocolFactory(new TBinaryProtocol.Factory());
            TServer server = new TSimpleServer(tArgs);
            server.serve();

        } catch (Exception e) {
            System.out.println("Server start error!!!");
            e.printStackTrace();
        }
    }

    public static void main(String[] args){
        ThriftTSimpleServerDemo thriftServerDemo = new ThriftTSimpleServerDemo();
        thriftServerDemo.startServer();
    }
}
