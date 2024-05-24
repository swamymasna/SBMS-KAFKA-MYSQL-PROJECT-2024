package com.kes.ip.producer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.kes.ip.dto.ProductEvent;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class KafkaProductProducer {

	@Value("${kafka.topic.name}")
	private String topic;

	@Autowired
	private KafkaTemplate<String, ProductEvent> kafkaTemplate;

	public String publishProductEvent(ProductEvent productEvent) {

		kafkaTemplate.send(topic, productEvent);

		log.info(String.format("Published Prodct Details : %s", productEvent));

		return "Product Details Published Successfully..!";
	}

}
