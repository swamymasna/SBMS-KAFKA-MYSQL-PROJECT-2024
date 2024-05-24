package com.kes.ip.client;

import org.springframework.beans.BeanUtils;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.kes.ip.dto.ProductDto;
import com.kes.ip.dto.ProductEvent;
import com.kes.ip.entity.Product;
import com.kes.ip.repository.ProductRepository;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@AllArgsConstructor
public class KafkaProductClient {

	private ProductRepository productRepository;

	@KafkaListener(topics = "${kafka.topic.name}", groupId = "${spring.kafka.consumer.group-id}")
	public void consumeProductEvent(ProductEvent productEvent) {

		ProductDto productDto = productEvent.getProductDto();

		Product product = new Product();

		BeanUtils.copyProperties(productDto, product);

		productRepository.save(product);

		log.info("Product Details Received & Also Saved into the Database..!");
	}
}
