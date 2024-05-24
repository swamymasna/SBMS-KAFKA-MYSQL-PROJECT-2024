package com.kes.ip.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kes.ip.dto.ProductDto;
import com.kes.ip.dto.ProductEvent;
import com.kes.ip.producer.KafkaProductProducer;

import lombok.AllArgsConstructor;

import java.util.Random;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/api/products")
@AllArgsConstructor
public class ProductController {

	private KafkaProductProducer productProducer;

	@PostMapping
	public ResponseEntity<String> createProduct(@RequestBody ProductDto productDto) {

		productDto.setProductId(new Random().nextInt(10000));

		ProductEvent productEvent = new ProductEvent();
		productEvent.setProductDto(productDto);
		productEvent.setStatus("SUCCESS");

		return new ResponseEntity<>(productProducer.publishProductEvent(productEvent), HttpStatus.CREATED);
	}

}
