package com.satalix.ai;

import org.springframework.stereotype.Service;

import com.satalix.Price;

@Service
public class LogicService {

	public boolean priceIncrease(Price price) {
		return price.getClose() > price.getOpen();
	}
	
	public boolean priceDecrease(Price price) {
		return price.getClose() < price.getOpen();
	}

}
