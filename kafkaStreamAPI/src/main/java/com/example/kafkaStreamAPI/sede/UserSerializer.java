package com.example.kafkaStreamAPI.sede;

import org.apache.kafka.common.serialization.Serializer;

import com.example.kafkaStreamAPI.entity.User;
import com.fasterxml.jackson.databind.ObjectMapper;

public class UserSerializer implements Serializer<User> {

	@Override
	public byte[] serialize(String s, User user) {
		byte[] retVal = null;
		ObjectMapper objectMapper = new ObjectMapper();
		try {
			retVal = objectMapper.writeValueAsString(user).getBytes();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return retVal;
	}
}