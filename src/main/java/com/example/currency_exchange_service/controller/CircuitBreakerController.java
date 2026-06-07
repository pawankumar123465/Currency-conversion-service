package com.example.currency_exchange_service.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import io.github.resilience4j.retry.annotation.Retry;

@RestController()
public class CircuitBreakerController 
{
	private Logger logger= LoggerFactory.getLogger(CircuitBreakerController.class);
	@Retry(name="default")
	@GetMapping("testing")
	public String getString()
	{
		logger.info("smaple api call received");
		ResponseEntity<String> value= new RestTemplate().getForEntity("dummyUrlOrThisMicroserviceIsdown", String.class);
		return value.getBody();
	}

}
