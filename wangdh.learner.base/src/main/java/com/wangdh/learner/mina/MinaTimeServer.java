package com.wangdh.learner.mina;


import org.apache.mina.core.service.IoAcceptor;
import org.apache.mina.core.session.IdleStatus;
import org.apache.mina.filter.codec.ProtocolCodecFilter;
import org.apache.mina.filter.codec.textline.TextLineCodecFactory;
import org.apache.mina.filter.logging.LoggingFilter;
import org.apache.mina.transport.socket.nio.NioSocketAcceptor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.charset.Charset;

/**
 * Apache Mina 框架
 * Created by Administrator on 2018/3/20.
 */
public class MinaTimeServer {
    private static final int PORT = 6488;

    private static  final Logger logger = LoggerFactory.getLogger(MinaTimeServer.class);

    public static void main(String[] args) throws IOException {
        // 创建服务端监控线程,使用了 Socket 通讯方式作为服务的接入
        IoAcceptor ioAcceptor = new NioSocketAcceptor();

        // IoSessionConfig表示会话的配置信息，主要包括：读缓冲区大小，会话数据吞吐量，计算吞吐量的时间间隔，指定会话段的空闲时间，写请求操作超时时间等
        ioAcceptor.getSessionConfig().setReadBufferSize(2048);
        ioAcceptor.getSessionConfig().setIdleTime(IdleStatus.BOTH_IDLE,10);

        // 设置日志记录器
        ioAcceptor.getFilterChain().addLast("logger", new LoggingFilter());

        // 设置编码过滤器
        // ioAcceptor.getFilterChain().addLast("code", new ProtocolCodecFilter(new TextLineCodecFactory(Charset.forName("UTF-8"))));
        ioAcceptor.getFilterChain().addLast("code", new ProtocolCodecFilter(new HttpServerProtocolCodecFactory()));

        // 设置业务逻辑处理器
        ioAcceptor.setHandler(new TimeServerHandler());

        // 设置端口号
        ioAcceptor.bind(new InetSocketAddress(PORT));

        logger.info("服务的启动中......");
    }
}
