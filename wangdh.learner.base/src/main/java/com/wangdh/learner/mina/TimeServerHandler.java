package com.wangdh.learner.mina;

import org.apache.mina.core.service.IoHandlerAdapter;
import org.apache.mina.core.session.IdleStatus;
import org.apache.mina.core.session.IoSession;

/**
 * 服务端业务逻辑
 * Created by Administrator on 2018/3/20.
 */
public class TimeServerHandler extends IoHandlerAdapter {
    //连接创建事件
    @Override
    public void sessionCreated(IoSession session) throws Exception {
        //显示客户端ip和端口号
        System.out.println(session.getRemoteAddress().toString());
    }

    @Override
    public void exceptionCaught(IoSession session, Throwable cause)
            throws Exception {
        cause.printStackTrace();
    }

    HttpResponseMessage response = null;

    //消息接收事件
    @Override
    public void messageReceived(IoSession session, Object message)
            throws Exception {
        String strMsg = message.toString();
        if (strMsg.trim().equalsIgnoreCase("quit")) {
            session.close(true);
            return;
        }
        response = new HttpResponseMessage();
        response.appendBody("Hi,client");

        //返回消息字符串
        session.write(response);

        // 打印客户端发送的消息
        System.out.println("server received a message :" + strMsg);
    }

    @Override
    public void sessionIdle(IoSession session, IdleStatus status)
            throws Exception {
        System.out.println("IDLE" + session.getIdleCount(status));
    }
}
