/**
 * 
 */
package wangdh.learner.rabbitmq.helloworld;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

import com.rabbitmq.client.AMQP;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.DefaultConsumer;
import com.rabbitmq.client.Envelope;

import wangdh.learner.rabbitmq.common.ExchangeType;
import wangdh.learner.rabbitmq.common.RabbitMQConfig;

/**
 * 消息消费者
 * 
 * @author wdhcxx
 *
 */
public class Consumer {
	/**
	 * 队列名称
	 */
	private final static String QUEUE_NAME = "hello.rabbitmq";
	/**
	 * 交换器名称
	 */
	private final static String EXCHANGE_NAME = "hello-01";
	/**
	 * 路由键
	 */
	private final static String ROUTE_KEY = "route_key_01";

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

		// 创建交换器
		channel.exchangeDeclare(EXCHANGE_NAME, ExchangeType.direct.getCode());

		// 创建队列
		channel.queueDeclare(QUEUE_NAME, false, false, false, null);

		// 绑定队列到交换器
		channel.queueBind(QUEUE_NAME, EXCHANGE_NAME, ROUTE_KEY);

		// 实例化队列消费者
		com.rabbitmq.client.Consumer consumer = new DefaultConsumer(channel) {
			@Override
			public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties,
					byte[] body) throws IOException {
				String message = new String(body, "UTF-8");
				System.out.println("Received 【" + message + "】");
			}
		};
		channel.basicConsume(QUEUE_NAME, true, consumer);

		System.out.println("OK");
//		System.exit(1);
	}
}
