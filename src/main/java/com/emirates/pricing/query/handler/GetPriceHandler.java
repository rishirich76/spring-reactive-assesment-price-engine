/**
 * 
 */
package com.emirates.pricing.query.handler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import com.emirates.pricing.exception.NoPriceInfoFoundException;
import com.emirates.pricing.model.Price;
import com.emirates.pricing.repository.PricingRepository;

import lombok.extern.log4j.Log4j2;
import reactor.core.publisher.Flux;

/**
 * @author LENOVO
 *
 */
@Service
@Log4j2
public class GetPriceHandler {

	@Autowired
	@Lazy
	private PricingRepository pricingRepository;

	public Flux<Price> getFlights(String carrier, String number, String date) {
		// can add date logic depends on biz logic

		// get data from db, say as pricing engine
		return pricingRepository.findByCarrierAndNumber(carrier, number)
				.map(p -> Price.builder().carrier(p.getCarrier()).number(p.getNumber()).price(p.getPrice())
						.currency(p.getCurrency()).rbd(p.getRbd()).build())
				.sort((p1, p2) -> p1.getPrice().compareTo(p2.getPrice()))
				.switchIfEmpty(Flux.error(new NoPriceInfoFoundException()));

	}

}
