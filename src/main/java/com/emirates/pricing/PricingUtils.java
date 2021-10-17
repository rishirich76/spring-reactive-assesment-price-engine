package com.emirates.pricing;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.PrimitiveIterator.OfInt;
import java.util.Random;

import com.emirates.pricing.entity.PriceEntity;

public class PricingUtils {

	private final static int TOTAL_NUM_OF_RECORDS_DB = 20;
	private final static String[] carrier = { "EK", "FZ" };
	private final static String[] rbds = { "A", "M", "S", "D" };

	/**
	 * generate random flight records
	 * 
	 * @return
	 */
	public static List<PriceEntity> generateRandomPriceDataDB() {
		List<PriceEntity> list = new ArrayList<PriceEntity>();
		OfInt ran = new Random().ints(2, 9999).iterator();
		OfInt ranRBD = new Random().ints(0, 4).iterator();
		Random ranC = new Random();

		for (int i = 0; i < TOTAL_NUM_OF_RECORDS_DB; i++) {
			int rbdCount = ranRBD.nextInt();
			String car = carrier[ranC.nextInt(carrier.length)];
			String fltNum = String.format("%04d", ran.nextInt());
			for (int j = 0; j < rbdCount; j++) {
				list.add(new PriceEntity(car, fltNum, rbds[j], Double.valueOf(ranC.nextInt(9999) / 10.0), "AED",
						new Date()));
			}
		}
		return list;
	}
}
