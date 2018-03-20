package com.wangdh.learner.mina;

import org.apache.mina.filter.codec.demux.DemuxingProtocolCodecFactory;

/**
 * 消息过滤器工厂
 * Created by Administrator on 2018/3/20.
 */
public class HttpServerProtocolCodecFactory extends DemuxingProtocolCodecFactory {
    public HttpServerProtocolCodecFactory() {
        super.addMessageDecoder(HttpRequestDecoder.class);
        super.addMessageEncoder(HttpResponseMessage.class,
                HttpResponseEncoder.class);
    }
}