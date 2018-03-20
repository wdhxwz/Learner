package com.wangdh.learner.mina;

import org.apache.mina.core.future.ConnectFuture;
import org.apache.mina.filter.codec.ProtocolCodecFilter;
import org.apache.mina.filter.codec.textline.TextLineCodecFactory;
import org.apache.mina.filter.logging.LoggingFilter;
import org.apache.mina.transport.socket.nio.NioSocketConnector;

import java.net.InetSocketAddress;
import java.nio.charset.Charset;

/**
 * Created by Administrator on 2018/3/20.
 */
public class MinaTimeClient {
    public static void main(String[] args) {
        // 创建客户端连接器
        NioSocketConnector connector = new NioSocketConnector();
        connector.getFilterChain().addLast("logger", new LoggingFilter());
        connector.getFilterChain().addLast("code", new ProtocolCodecFilter(new TextLineCodecFactory(Charset.forName("Utf-8"))));

        // 设置超时检查时间
        connector.setConnectTimeoutCheckInterval(30);

        // 设置业务逻辑处理器
        connector.setHandler(new TimeClientHandler());

        // 建立连接
        ConnectFuture connectFuture = connector.connect(new InetSocketAddress("127.0.0.1", 6488));

        // 等待连接创建完成
        connectFuture.awaitUninterruptibly();

        connectFuture.getSession().write("Hi Server");
        connectFuture.getSession().write("quit");

        // 等待连接断开
        connectFuture.getSession().getCloseFuture().awaitUninterruptibly();

        // 释放连接
        connector.dispose();
    }
}
