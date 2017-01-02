/**
 * 
 */
package wangdh.learner.rabbitmq.queues;

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
 * @author wdhcxx
 *
 */
public class Worker2 {
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
		
		System.out.println("Worker2 [*] Waiting for messages. To exit press CTRL+C");

		// 每次从队列中获取数量
		channel.basicQos(2);

		// 实例化队列消费者
		com.rabbitmq.client.Consumer consumer = new DefaultConsumer(channel) {
			@Override
			public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties,
					byte[] body) throws IOException {
				String message = new String(body, "UTF-8");
				System.out.println("Worker2 Received 【" + message + "】");
				try {
					Thread.sleep(1000);
				} catch (InterruptedException _ignored) {
					Thread.currentThread().interrupt();
				} finally {
					channel.basicAck(envelope.getDeliveryTag(), false);
				}
			}
		};
		channel.basicConsume(QUEUE_NAME, false, consumer);
	}
}