package com.example.kafkaStreamAPI.sede;

import org.apache.kafka.common.serialization.Deserializer;
import org.apache.kafka.common.serialization.Serde;
import org.apache.kafka.common.serialization.Serializer;

import com.example.kafkaStreamAPI.entity.User;

public class CustomSrdes implements Serde<User> {

	@Override
	public Serializer<User> serializer() {
		return new UserSerializer();
	}

	@Override
	public Deserializer<User> deserializer() {
		return new UserDeserializer();
	}

}
