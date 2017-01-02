/**
 * 
 */
package wangdh.learner.rabbitmq.queues;

import java.io.IOException;
import java.util.Date;
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
public class NewTask {
	/**
	 * 队列名称
	 */
	private final static String QUEUE_NAME = "hello.task.queue";
	/**
	 * 交换器名称
	 */
	private final static String EXCHANGE_NAME = "task.queue-01";
	/**
	 * 路由键
	 */
	private final static String ROUTE_KEY = "route_key_02";

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
		channel.exchangeDeclare(EXCHANGE_NAME, ExchangeType.direct.getCode());

		// 创建队列
		channel.queueDeclare(QUEUE_NAME, false, false, false, null);

		// 绑定队列到交换器
		channel.queueBind(QUEUE_NAME, EXCHANGE_NAME, ROUTE_KEY);

		for (int i = 0; i < 10; i++) {
			// 待发送的消息
			String message = "【" + i + "】,hello task queue,time:" + new Date().getTime();

			// 发送消息，需指定交换器名称，路由键值
			channel.basicPublish(EXCHANGE_NAME, ROUTE_KEY, null, message.getBytes());
		}
		channel.close();
		connection.close();

		System.out.println("OK");
		System.exit(1);
	}
}
