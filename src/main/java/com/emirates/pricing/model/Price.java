/**
 * 
 */
package com.emirates.pricing.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @author LENOVO
 *
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Price {

	private String carrier;

	private String number;

	private String rbd;

	private Double price;

	private String currency;

}
