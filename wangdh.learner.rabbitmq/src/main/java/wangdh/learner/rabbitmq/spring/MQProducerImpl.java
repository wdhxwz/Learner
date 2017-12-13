package wangdh.learner.rabbitmq.spring;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author wangdh
 * @Description
 * @date 2017-12-13
 */
@Service
public class MQProducerImpl implements MQProducer {
    @Autowired
    private AmqpTemplate amqpTemplate;

    private final static Logger LOGGER = LoggerFactory.getLogger(MQProducerImpl.class);

    @Override
    public void sendDataToQueue(String queueKey, Object object) {
        try {
            amqpTemplate.convertAndSend(queueKey, object);
        } catch (Exception e) {
            LOGGER.error(e.getMessage(),e);
        }
    }
}