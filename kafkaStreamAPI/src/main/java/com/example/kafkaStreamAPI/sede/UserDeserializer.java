package com.example.kafkaStreamAPI.sede;

import org.apache.kafka.common.serialization.Deserializer;

import com.example.kafkaStreamAPI.entity.User;
import com.fasterxml.jackson.databind.ObjectMapper;

public class UserDeserializer implements Deserializer<User> {

	@Override
	public User deserialize(String s, byte[] bytes) {
		ObjectMapper mapper = new ObjectMapper();
		User quote = null;
		try {
			quote = mapper.readValue(bytes, User.class);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return quote;
	}

}