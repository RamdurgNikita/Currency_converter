package com.convert.currency.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.convert.currency.Service.ConvertService;
import com.convert.currency.model.CurrencyRequest;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;


@RestController

public class CovertCurrencyController {

	@Autowired
	ConvertService convertService;

	@PostMapping("/convert-currency/convertcurrency")
public ResponseEntity<?> convertCurrency(@RequestBody CurrencyRequest request ){
		
		return  ResponseEntity.ok(convertService.convertCurrency(request));
		
	}
	
	@PostMapping("/convert-currency/convertcurrency1")
	@CircuitBreaker(name="manageCurrencyConversion", fallbackMethod="testConversionFactorFallback" )
	public ResponseEntity<?> convertCurrency1(@RequestBody CurrencyRequest request ){
		
		return  ResponseEntity.ok(convertService.convertCurrency(request));
		
	}
	
    public ResponseEntity<?> testConversionFactorFallback(CurrencyRequest request, Throwable t){
		double amt =0;
		if(request!=null) {
    	
			amt = request.getAmount() * 10.0;
			}
			
		return ResponseEntity.ok(amt);
		
		
		
		
	}
	
	}
	
	


