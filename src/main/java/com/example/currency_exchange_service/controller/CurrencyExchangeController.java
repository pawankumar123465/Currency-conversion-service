package com.example.currency_exchange_service.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.currency_exchange_service.dao.CurrencyExchangeRepository;
import com.example.currency_exchange_service.pojo.CurrencyExchange;

@RestController
public class CurrencyExchangeController 
{
	@Autowired
	private Environment env;
	
	@Autowired
	private CurrencyExchangeRepository currencyExchangeRepository;
	
	@GetMapping("currency-exchange/from/{from}/to/{to}")
	public CurrencyExchange retriveExchange(@PathVariable String from,@PathVariable String to)
	{
		CurrencyExchange currencyExchange= currencyExchangeRepository.findByFromAndTo(from, to);
		String port=env.getProperty("server.port");
		currencyExchange.setEnv(port);
		System.out.println("hello hhh    ");
		return currencyExchange;
		
	}

}
