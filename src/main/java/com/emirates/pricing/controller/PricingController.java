/**
 * 
 */
package com.emirates.pricing.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.emirates.pricing.model.Price;
import com.emirates.pricing.query.handler.GetPriceHandler;

import reactor.core.publisher.Flux;

/**
 * @author LENOVO
 *
 */
@RestController
public class PricingController {

	@Autowired
	private GetPriceHandler getPriceHandler;

	@GetMapping
	public Flux<Price> getPriceInfo(@RequestParam("carrier") String carrier, @RequestParam("fltNumber") String number,
			@RequestParam("date") String date) {
		return getPriceHandler.getFlights(carrier, number, date);
	}

}
