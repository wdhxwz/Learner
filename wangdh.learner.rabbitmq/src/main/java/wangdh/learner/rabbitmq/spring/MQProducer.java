package wangdh.learner.rabbitmq.spring;

/**
 * @author wangdh
 * @Description
 * @date 2017-12-13
 */
public interface MQProducer {
    /**
     * 发送消息到指定队列
     * @param queueKey
     * @param object
     */
    public void sendDataToQueue(String queueKey, Object object);
}
