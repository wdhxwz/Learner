/**
 * 
 */
package wangdh.learner.rabbitmq.route;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

import com.rabbitmq.client.AMQP;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.Consumer;
import com.rabbitmq.client.DefaultConsumer;
import com.rabbitmq.client.Envelope;

import wangdh.learner.rabbitmq.common.RabbitMQConfig;

/**
 * @author wdhcxx
 *
 */
public class ReceiveLogsDirect1 {
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
		channel.exchangeDeclare(EXCHANGE_NAME, "direct", true);

		// 获取匿名队列名称
		String queueName = channel.queueDeclare().getQueue();

		// 根据路由关键字进行多重绑定
		for (String severity : routingKeys) {
			channel.queueBind(queueName, EXCHANGE_NAME, severity);
			System.out.println("ReceiveLogsDirect1 exchange:" + EXCHANGE_NAME + ", queue:" + queueName
					+ ", BindRoutingKey:" + severity);
		}

		Consumer consumer = new DefaultConsumer(channel) {
			@Override
			public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties,
					byte[] body) throws IOException {
				String message = new String(body, "UTF-8");
				System.out.println(" [x] Received '" + envelope.getRoutingKey() + "':'" + message + "'");
			}
		};
		channel.basicConsume(queueName, true, consumer);
	}
}