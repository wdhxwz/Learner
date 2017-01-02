/**
 * 
 */
package wangdh.learner.rabbitmq.publish;

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
public class EmitLog {
	/**
	 * 交换器名称
	 */
	private final static String EXCHANGE_NAME = "Logs";

	public static void main(String[] args) throws IOException, TimeoutException, InterruptedException {
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

		// 创建交换器
		channel.exchangeDeclare(EXCHANGE_NAME, ExchangeType.fanout.getCode());

		// 分发消息
		for (int i = 0; i < 5; i++) {
			String message = "Hello World! " + i;
			channel.basicPublish(EXCHANGE_NAME, "", null, message.getBytes());
			System.out.println(" [x] Sent '" + message + "'");
		}
		channel.close();
		connection.close();

		System.out.println("OK");
		System.exit(1);
	}
}