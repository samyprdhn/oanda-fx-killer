package com.satalix.poller;

import java.util.Collection;
import java.util.Comparator;

import org.apache.commons.lang3.ObjectUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.satalix.Candles;
import com.satalix.OandaResponse;
import com.satalix.api.OandaRestService;

@Service
public class ScheduledPricePoller {
	
	@Autowired
	private OandaRestService oandaRestService;
	
	//@Scheduled(cron = "*/2 * * * * *")
	public void getPrice(){
		ResponseEntity<OandaResponse> response = oandaRestService.callApi();

		OandaResponse oandaResponse = response.getBody();

		Collection<Candles> candles = oandaResponse.getCandles();
		

		Comparator<Candles> comparator = new Comparator<Candles>() {

			@Override
			public int compare(Candles o1, Candles o2) {
				return ObjectUtils.compare(o2.getTime(), o1.getTime());
			}
		};

		candles.stream().sorted(comparator).forEach(System.out::println);

		
	}

}
