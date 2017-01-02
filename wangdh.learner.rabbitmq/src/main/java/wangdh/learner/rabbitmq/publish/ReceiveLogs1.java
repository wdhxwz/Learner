/**
 * 
 */
package wangdh.learner.rabbitmq.publish;

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
public class ReceiveLogs1 {
	/**
	 * 交换器名称
	 */
	private final static String EXCHANGE_NAME = "Logs";

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
		channel.exchangeDeclare(EXCHANGE_NAME, ExchangeType.fanout.getCode());

		// 创建临时队列
		// 创建一个非持久化、独立、自动删除的队列名称。
		// 断开消费者，队列立即被删除。
		String queueName = channel.queueDeclare().getQueue();
		System.out.println("【临时队列】" + queueName);

		// 绑定队列到交换器
		channel.queueBind(queueName, EXCHANGE_NAME, "");

		System.out.println("[*] Waiting for messages. To exit press CTRL+C");
		
		// 实例化队列消费者
		com.rabbitmq.client.Consumer consumer = new DefaultConsumer(channel) {
			@Override
			public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties,
					byte[] body) throws IOException {
				String message = new String(body, "UTF-8");
				System.out.println("Received 【" + message + "】");
			}
		};
		channel.basicConsume(queueName, true, consumer);
	}
}