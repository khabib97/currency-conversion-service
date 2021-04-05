package com.old.school.microservices.currencyconversionservice;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

//old 
//@FeignClient(name="currency-exchange", url="localhost:8000")
//new using eureka
//@FeignClient(name="currency-exchange")
//change-kubernetes
@FeignClient(name="currency-exchange", url="${CURRENCY_EXCHANGE_SERVICE_HOST:http://localhost}:8000")
public interface CurrencyExchangeProxy {

	@GetMapping("/currency-exchange/from/{from}/to/{to}")
	public CurrencyConversion retriveExchangeValue(@PathVariable String from, @PathVariable String to);
}
