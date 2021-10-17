/**
 * 
 */
package com.emirates.pricing.entity;

import java.util.Date;

import org.springframework.data.mongodb.core.mapping.Document;

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
@Document("Pricing")
public class PriceEntity {

	private String carrier;

	private String number;

	private String rbd;

	private Double price;

	private String currency;

	private Date createdTimeStamp;

}
