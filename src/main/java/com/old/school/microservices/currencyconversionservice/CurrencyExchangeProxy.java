package com.old.school.microservices.currencyconversionservice;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

//old 
//@FeignClient(name="currency-exchange", url="localhost:8000")
//new using eureka
//@FeignClient(name="currency-exchange")
//change-kubernetes
//@FeignClient(name="currency-exchange", url="${CURRENCY_EXCHANGE_SERVICE_HOST:http://localhost}:8000")
//Above approach has problem, CURRENCY_EXCHANGE_SERVICE_HOST is a environment variable and provided by the the environment, 
//so we should always start currency-exchange-service to get this env value, it is a dependency, we need to remove this dependency
<<<<<<< HEAD
@FeignClient(name="currency-exchange", url="${CURRENCY_EXCHANGE_URI:http://localhost}:8000")
=======
@FeignClient(name="currency-exchange", url="${CURRENCY_EXCHANGE_HOST:http://localhost}:8000")
>>>>>>> aebd32e5a6837c84dc503df4e77178711159486d
public interface CurrencyExchangeProxy {

	@GetMapping("/currency-exchange/from/{from}/to/{to}")
	public CurrencyConversion retriveExchangeValue(@PathVariable String from, @PathVariable String to);
}
