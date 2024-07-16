package com.example.kafkaStreamAPI.consumer;

import java.util.List;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.example.kafkaStreamAPI.entity.User;

@Service
public class StreamConsumer {

	@KafkaListener(topics = "outputTopic", groupId = "gId1")
	public void fizzBuzzConsumer(List<User> user) {
		System.out.println(String.format("Message Consumed  User -> " + user.toString()));

	}

	@KafkaListener(topics = "outputTopic1", groupId = "gId2")
	public void Consumer(String user) {
		System.out.println(String.format("Message Consumed  User with Topic1 -> " + user));

	}

	@KafkaListener(topics = "outputTopic2", groupId = "gId2")
	public void readData(String user) {
		System.out.println(String.format("Message Consumed  User with Topic1 -> " + user));

	}

}
