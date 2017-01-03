/**
 * 
 */
package wangdh.learner.rabbitmq.topic;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import wangdh.learner.rabbitmq.common.ExchangeType;
import wangdh.learner.rabbitmq.common.RabbitMQConfig;

/**
 * @author wdhcxx
 *
 */
public class TopicSend {
	private static final String EXCHANGE_NAME = "topic_logs";

	/**
	 * @param args
	 * @throws TimeoutException
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException, TimeoutException {
		// 创建连接工厂
		ConnectionFactory factory = new ConnectionFactory();
		factory.setHost(RabbitMQConfig.host);
		factory.setVirtualHost(RabbitMQConfig.virtualHost);
		factory.setUsername(RabbitMQConfig.userName);
		factory.setPassword(RabbitMQConfig.password);
		factory.setPort(RabbitMQConfig.port);

		// 创建连接
		Connection connection = factory.newConnection();

		// 创建信道
		Channel channel = connection.createChannel();

		// 声明交换器
		channel.exchangeDeclare(EXCHANGE_NAME, ExchangeType.topic.getCode(), true);

		// 待发送的消息
		String[] routingKeys = new String[] { "", "quick.orange.rabbit", "lazy.orange.elephant", "quick.orange.fox",
				"lazy.brown.fox", "quick.brown.fox", "quick.orange.male.rabbit", "lazy.orange.male.rabbit" };
		// 发送消息
		for (String severity : routingKeys) {
			String message = "From " + severity + " routingKey' s message!";
			channel.basicPublish(EXCHANGE_NAME, severity, null, message.getBytes());
			System.out.println("TopicSend [x] Sent '" + severity + "':'" + message + "'");
		}

		channel.close();
		connection.close();
	}
}