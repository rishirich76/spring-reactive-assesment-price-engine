package com.emirates.pricing;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.emirates.pricing.exception.NoPriceInfoFoundException;
import com.emirates.pricing.model.PricingError;

@RestControllerAdvice
public class PriceExceptionHandler {

	@ExceptionHandler(MissingServletRequestParameterException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public PricingError missingQueryParam(MissingServletRequestParameterException ex) {
		return PricingError.builder().code(PricingErrorMessages.MISSING_QUERY_PARAM.getCode())
				.message(PricingErrorMessages.MISSING_QUERY_PARAM.getMessage()).build();
	}
	
	@ExceptionHandler(NoPriceInfoFoundException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public PricingError noPricingFound(NoPriceInfoFoundException ex) {
		return PricingError.builder().code(PricingErrorMessages.NO_PRICE_FOUND.getCode())
				.message(PricingErrorMessages.NO_PRICE_FOUND.getMessage()).build();
	}
	
	@ExceptionHandler(Exception.class)
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	public PricingError genericError(Exception ex) {
		return PricingError.builder().code(PricingErrorMessages.GENERIC_ERROR.getCode())
				.message(PricingErrorMessages.GENERIC_ERROR.getMessage()).build();
	}
}
