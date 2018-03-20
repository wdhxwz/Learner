package com.wangdh.learner.mina;

import org.apache.mina.core.service.IoHandlerAdapter;
import org.apache.mina.core.session.IoSession;

/**
 * 编写自己的业务逻辑类
 * Created by Administrator on 2018/3/20.
 */
public class TimeClientHandler extends IoHandlerAdapter {
    //接收消息
    @Override
    public void messageReceived(IoSession session, Object message)
            throws Exception {
        String content=message.toString();
        System.out.println("client received a message :"+content);
    }
    //发送消息
    @Override
    public void messageSent(IoSession session, Object message) throws Exception {
        System.out.println("sending message ->:"+message);
    }
}
