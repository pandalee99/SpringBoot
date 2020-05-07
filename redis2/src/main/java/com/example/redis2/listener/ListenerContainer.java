package com.example.redis2.listener;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.connection.MessageListener;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.listener.ChannelTopic;
import org.springframework.data.redis.listener.RedisMessageListenerContainer;
import org.springframework.data.redis.listener.Topic;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;
import org.springframework.stereotype.Component;

@Component
public class ListenerContainer {

    	// Redis连接工厂
	@Autowired
	private RedisConnectionFactory connectionFactory = null;

	// Redis消息监听器
	@Autowired
	private MessageListener redisMsgListener = null;

	// 任务池
	private ThreadPoolTaskScheduler taskScheduler = null;

	/**
	 * 创建任务池，运行线程等待处理Redis的消息
	 *
	 * @return
	 */
	@Bean
	public ThreadPoolTaskScheduler initTaskScheduler() {
		if (taskScheduler != null) {
			return taskScheduler;
		}
		taskScheduler = new ThreadPoolTaskScheduler();
		taskScheduler.setPoolSize(20);
		return taskScheduler;
	}

	/**
	 * 定义Redis的监听容器
	 *
	 * @return 监听容器
	 */
	@Bean
	public RedisMessageListenerContainer initRedisContainer() {
		RedisMessageListenerContainer container = new RedisMessageListenerContainer();
		// Redis连接工厂
		container.setConnectionFactory(connectionFactory);
		// 设置运行任务池
		container.setTaskExecutor(initTaskScheduler());
		// 定义监听渠道，名称为topic1
		Topic topic = new ChannelTopic("topic1");
		// 使用监听器监听Redis的消息
		container.addMessageListener(redisMsgListener, topic);
		return container;
	}
}
