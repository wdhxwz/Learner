/**
 * 
 */
package wangdh.learner.rabbitmq.route;

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
public class RoutingSendDirect {
	private static final String EXCHANGE_NAME = "direct_logs";

	// 路由关键字
	private static final String[] routingKeys = new String[] { "info", "warning", "error" };

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
		channel.exchangeDeclare(EXCHANGE_NAME, ExchangeType.direct.getCode(), true);

		// 发送消息
		for (String severity : routingKeys) {
			String message = "Send the message level:" + severity;
			channel.basicPublish(EXCHANGE_NAME, severity, null, message.getBytes());
			System.out.println(" [x] Sent '" + severity + "':'" + message + "'");
		}
		channel.close();
		connection.close();
	}
}