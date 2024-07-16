package com.example.kafkaStreamAPI.consumer;

import org.apache.kafka.common.serialization.Serde;
import org.apache.kafka.common.serialization.Serdes;
import org.apache.kafka.common.serialization.Serdes.WrapperSerde;
import org.apache.kafka.streams.StreamsBuilder;
import org.apache.kafka.streams.kstream.Consumed;
import org.apache.kafka.streams.kstream.KStream;
import org.apache.kafka.streams.kstream.ValueMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import com.example.kafkaStreamAPI.entity.User;
import com.example.kafkaStreamAPI.sede.UserDeserializer;
import com.example.kafkaStreamAPI.sede.UserSerializer;

@Service
public class OrdersTopology {

	private static final String OUTPUT_TOPIC_NAME = "outputTopic";
	private static final String OUTPUT_TOPIC_NAME1 = "outputTopic1";
	private static final String INPUT_TOPIC_NAME = "inputTopic";
//	private static final String OUTPUT_TOPIC_NAME2 = "outputTopic2";
//	private static final String SPARK_SOUTPUT_TOPIC_NAME2 = "outputTopicSpark";
	Serde<User> serde = new WrapperSerde<>(new UserSerializer(), new UserDeserializer());

	@Bean
	public KStream<String, User> evenNumbersStream(StreamsBuilder kStreamBuilder)
			throws InstantiationException, IllegalAccessException {
		KStream<String, User> input = kStreamBuilder.stream(INPUT_TOPIC_NAME, Consumed.with(Serdes.String(), serde));

		KStream<String, User> input1 = input;
		KStream<String, String> output = input.mapValues(new ValueMapper<User, String>() {

			@Override
			public String apply(User value) {
				return value.getName();
			}

		});

		input1.to(OUTPUT_TOPIC_NAME);
		output.to(OUTPUT_TOPIC_NAME1);

		return input;

	}

}
