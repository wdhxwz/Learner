package wangdh.learner.rabbitmq.spring;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageListener;
import org.springframework.stereotype.Component;

/**
 * @author wangdh
 * @Description
 * @date 2017-12-13
 */
@Component
public class QueueListenter implements MessageListener {
    @Override
    public void onMessage(Message msg) {
        try{
            System.out.println(msg.toString());
            System.out.println(new String(msg.getBody(), "UTF-8"));
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
