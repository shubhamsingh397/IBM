package com.example.demo.config;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMqCOnfig {

	private static final String QUEUE = "items-queue";
	private static final String EXCHANGE = "otp-exchange";
	private static final String ROUTING_QUEUE = "items";
	
	@Bean
	Queue queue()
	{
		return new Queue(QUEUE);
	}
	@Bean
	DirectExchange directExchange()
	{
		return new DirectExchange(EXCHANGE);
	}
	
	@Bean
	Binding binding(DirectExchange exchange,Queue queue)
	{
		return BindingBuilder.bind(queue).to(exchange).with(ROUTING_QUEUE);
	}
	
	@Bean
	MessageConverter jsonMessageConverter()
	{
		return new Jackson2JsonMessageConverter();
	}
	@Bean
	AmqpTemplate amqpTemplate(ConnectionFactory connectionFactory)
	{
		final RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
		rabbitTemplate.setMessageConverter(jsonMessageConverter());
		return rabbitTemplate;
	}
}
