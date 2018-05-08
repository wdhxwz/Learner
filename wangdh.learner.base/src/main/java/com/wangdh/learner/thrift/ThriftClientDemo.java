package com.wangdh.learner.thrift;

import org.apache.thrift.TException;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.protocol.TCompactProtocol;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.transport.TFramedTransport;
import org.apache.thrift.transport.TSocket;
import org.apache.thrift.transport.TTransport;
import org.apache.thrift.transport.TTransportException;

/**
 * 同步客户端
 * <br/> https://segmentfault.com/a/1190000010938841
 * <br/> http://www.cnblogs.com/cyfonly/p/6059374.html
 */
public class ThriftClientDemo {
    public static final String SERVER_IP = "127.0.0.1";
    public static final int SERVER_PORT = 9081;
    public static final int TIMEOUT = 30000;

    /**
     *
     * @param userName
     */
    public void startClient(String userName) {
        TTransport transport = null;
        try {
            // transport = new TSocket(SERVER_IP, SERVER_PORT, TIMEOUT);

            // 对应的是THsHaServer服务模型或TNonblockingServer 服务模型
            transport = new TFramedTransport(new TSocket(SERVER_IP, SERVER_PORT, TIMEOUT));

            // 协议要和服务端一致
            // TProtocol protocol = new TBinaryProtocol(transport);

            // 对应的是THsHaServer服务模型TNonblockingServer 服务模型
            TProtocol protocol = new TCompactProtocol(transport);

            // TProtocol protocol = new TJSONProtocol(transport);
            Hello.Client client = new Hello.Client(protocol);
            transport.open();
            String result = client.sayHello(userName);
            System.out.println("Thrify client result =: " + result);
        } catch (TTransportException e) {
            e.printStackTrace();
        } catch (TException e) {
            e.printStackTrace();
        } finally {
            if (null != transport) {
                transport.close();
            }
        }
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        ThriftClientDemo client = new ThriftClientDemo();
        client.startClient("wdh");
    }
}