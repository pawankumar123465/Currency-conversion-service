package com.example.currency_exchange_service.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.currency_exchange_service.pojo.CurrencyExchange;

@Repository
public interface CurrencyExchangeRepository extends JpaRepository<CurrencyExchange, Long> 
{
	CurrencyExchange findByFromAndTo(String from ,String to);

}
