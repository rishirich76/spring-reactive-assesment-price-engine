/**
 * 
 */
package com.emirates.pricing;

import lombok.Getter;

/**
 * @author LENOVO
 *
 */
@Getter
public enum PricingErrorMessages {

	MISSING_QUERY_PARAM("11001", "Invalid input criteria, missing query params."),
	GENERIC_ERROR("11002", "Internal server error, try after sometime."),
	NO_PRICE_FOUND("11003", "No price information found with given criteria."),;
	
	private String code;
	private String message;
	
	PricingErrorMessages(String code, String message) {
		this.code = code;
		this.message =message;
	}
	
	
	
	
	
}
