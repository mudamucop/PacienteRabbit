package com.Mudamu.service;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.Mudamu.model.Employee;

@Service
public class RabbitMQSender {

	@Autowired
	private AmqpTemplate amqpTemplate;

	@Value("${loginPacientes.rabbitmq.exchange}")
	private String exchange;

	@Value("${loginPacientes.rabbitmq.routingkey}")
	private String routingkey;
	String kafkaTopic = "java_in_use_topic";

	public void send(Employee company) {
		amqpTemplate.convertAndSend(exchange, routingkey, company);
		System.out.println("Send msg = " + company);

	}
}