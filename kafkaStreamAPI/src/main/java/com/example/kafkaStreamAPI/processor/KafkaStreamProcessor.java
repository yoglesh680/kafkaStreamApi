//package com.example.kafkaStreamAPI.processor;
//
//import java.util.Arrays;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
//import org.apache.kafka.common.serialization.Serdes;
//import org.apache.kafka.streams.StreamsBuilder;
//import org.apache.kafka.streams.StreamsConfig;
//import org.apache.kafka.streams.kstream.KStream;
//import org.apache.kafka.streams.kstream.Predicate;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.autoconfigure.kafka.KafkaProperties;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.kafka.annotation.EnableKafka;
//import org.springframework.kafka.annotation.EnableKafkaStreams;
//import org.springframework.kafka.annotation.KafkaStreamsDefaultConfiguration;
//import org.springframework.kafka.config.KafkaStreamsConfiguration;
//
//import com.example.kafkaStreamAPI.entity.User;
//
//@Configuration
//@EnableKafka
//@EnableKafkaStreams
//public class KafkaStreamProcessor {
//
//	@Autowired
//	UpparCaseProcessor upparCaseProcessor;
//
//	@Bean(name = KafkaStreamsDefaultConfiguration.DEFAULT_STREAMS_CONFIG_BEAN_NAME)
//	public KafkaStreamsConfiguration kStreamsConfigs(KafkaProperties kafkaProperties) {
//		Map<String, Object> config = new HashMap<>();
//		config.put(StreamsConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
//		config.put(StreamsConfig.APPLICATION_ID_CONFIG, kafkaProperties.getClientId());
//		config.put(StreamsConfig.DEFAULT_KEY_SERDE_CLASS_CONFIG, Serdes.String().getClass());
//		config.put("value.deserializer", "com.example.kafkaStreamAPI.sede.CustomDeserializer");
//
//		return new KafkaStreamsConfiguration(config);
//	}
//
//	@Bean
//	public KStream<String, List<User>> kStream(StreamsBuilder kStreamBuilder) {
//		KStream<String, List<User>> stream = kStreamBuilder.stream("input-topic");
//		Predicate<String, List<User>> predicate = ((k, v) -> v.get(0).getName().startsWith("r"));
//		KStream<String, List<User>>[] branches = stream.branch(predicate);
//		branches[0].mapValues(v -> v.get(0).getName() + 20).to("double-output");
//		Arrays.stream(branches).forEach(b -> b.to("double-output"));
//		return stream;
//	}
//
//}
