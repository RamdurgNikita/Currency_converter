package com.convert.currency.Service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.convert.currency.model.CurrencyResponse;



@FeignClient(name = "MANAGE-CURRENCYSERVICE-MS" ,url = "http://manage-currencyservice-ms:8081")
public interface ConvertServiceproxy {
	@RequestMapping(method = RequestMethod.POST, path = "/currency-conversion/{countryCode}")
	public CurrencyResponse getConversionFactor(@PathVariable("countryCode") String countrycode);

}
