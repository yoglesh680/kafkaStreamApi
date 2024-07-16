package com.example.kafkaStreamAPI.producer;

import java.util.ArrayList;
import java.util.List;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.example.kafkaStreamAPI.entity.User;

@Service
public class Producer {

	@Autowired
	KafkaTemplate<String, User> kafkaTemplate;

	private static final Logger LOGGER = LoggerFactory.getLogger(KafkaProducer.class);

	public Producer(KafkaTemplate<String, User> kafkaTemplate) {
		this.kafkaTemplate = kafkaTemplate;
	}

	public static int var1 = 0;
	public static int var2 = 0;

	@Scheduled(fixedRate = 1000)
	public void sendMessage() {
		List<User> list = new ArrayList<>();
		User user = new User(var2++, "yoglesh" + var1++, "0" + var1);
		list.add(user);
		for (User user1 : list) {
			kafkaTemplate.send("inputTopic", user1);
		}

		LOGGER.info(String.format("Message sent %s ", user));

	}
}
