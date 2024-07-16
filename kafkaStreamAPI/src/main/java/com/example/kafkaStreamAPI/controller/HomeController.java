//package com.example.kafkaStreamAPI.controller;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.RestController;
//
//import com.example.kafkaStreamAPI.producer.Producer;
//
//@RestController
//public class HomeController {
//
//	@Autowired
//	private Producer producer;
//
////	@Autowired
////	StreamsBuilderFactoryBean factoryBean;
////
////	@PostMapping("/publish")
////	public String saveUser(@RequestParam String msg) {
////		producer.sendMessage(msg);
////		return "sent successfully";
////
////	}
////	@GetMapping("/count/{word}")
////	public Long getWordCount(@PathVariable String word) {
////		KafkaStreams kafkaStreams = factoryBean.getKafkaStreams();
////		ReadOnlyKeyValueStore<String, Long> counts = kafkaStreams
////				.store(StoreQueryParameters.fromNameAndType("counts", QueryableStoreTypes.keyValueStore()));
////		System.out.println("count word ->" + word);
////		return counts.get(word);
////	}
////
//}
