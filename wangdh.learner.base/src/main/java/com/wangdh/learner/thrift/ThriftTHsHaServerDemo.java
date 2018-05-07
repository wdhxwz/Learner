package com.wangdh.learner.thrift;

import org.apache.thrift.TProcessor;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.server.THsHaServer;
import org.apache.thrift.server.THsHaServer.Args;
import org.apache.thrift.server.TServer;
import org.apache.thrift.transport.TFramedTransport;
import org.apache.thrift.transport.TNonblockingServerSocket;

/**
 * 半同步半异步的服务端模型，需要指定为： TFramedTransport 数据传输的方式  THsHaServer服务模型
 */
public class ThriftTHsHaServerDemo {
    public static final int SERVER_PORT = 8090;
    public void startServer() {
        try {
            System.out.println("HelloWorld THsHaServer start ....");

            TProcessor tprocessor = new Hello.Processor<Hello.Iface>(
                    new HelloWorldImpl());
            TNonblockingServerSocket tnbSocketTransport = new TNonblockingServerSocket(SERVER_PORT);
            Args args = new Args(tnbSocketTransport);
            args.processor(tprocessor);
            args.transportFactory(new TFramedTransport.Factory());
            args.protocolFactory(new TBinaryProtocol.Factory());
            TServer server = new THsHaServer(args);
            server.serve();

        } catch (Exception e) {
            System.out.println("Server start error!!!");
            e.printStackTrace();
        }
        System.out.println("exist");
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        ThriftTHsHaServerDemo server = new ThriftTHsHaServerDemo();
        server.startServer();
    }
}
