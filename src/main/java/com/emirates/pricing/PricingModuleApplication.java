package com.emirates.pricing;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableReactiveMongoRepositories;

import com.emirates.pricing.repository.PricingRepository;

import lombok.extern.log4j.Log4j2;

@EnableReactiveMongoRepositories
@SpringBootApplication
@Log4j2
public class PricingModuleApplication implements CommandLineRunner {

	@Autowired
	private PricingRepository pricingRepository;

	public static void main(String[] args) {
		SpringApplication.run(PricingModuleApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		log.info("adding dummy data in DB.");
		pricingRepository.deleteAll().thenMany(pricingRepository.saveAll(PricingUtils.generateRandomPriceDataDB()))
				.thenMany(pricingRepository.findAll()).subscribe();

	}

}
