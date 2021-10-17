/**
 * 
 */
package com.emirates.pricing.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

import com.emirates.pricing.entity.PriceEntity;

import reactor.core.publisher.Flux;

/**
 * @author LENOVO
 *
 */
@Repository
public interface PricingRepository extends ReactiveMongoRepository<PriceEntity, String>{

	public Flux<PriceEntity> findByCarrierAndNumber(String carrier, String number);
}
