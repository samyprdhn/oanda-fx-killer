package com.satalix.app;

import java.util.Collection;
import java.util.Comparator;
import java.util.List;

import org.apache.commons.lang3.ObjectUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.ResponseEntity;

import com.satalix.Candles;
import com.satalix.OandaResponse;
import com.satalix.api.OandaRestService;
import com.satalix.api.OandaStreamService;

@SpringBootApplication(scanBasePackages="com.satalix")
public class FxKillerApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(FxKillerApplication.class, args);
	}


//	@Autowired
//	MongoTemplate mongoTemplate;\\
	
	@Autowired
	private OandaRestService oandaRestService;
	
	@Autowired
	private OandaStreamService streamService;
	

	@Override
	public void run(String... arg0) throws Exception {

		ResponseEntity<OandaResponse> oandaResponse = 	oandaRestService.callApi();
		
		Collection<Candles> candles = oandaResponse.getBody().getCandles();
		
		Comparator<Candles> comparator = new Comparator<Candles>() {
			
			@Override
			public int compare(Candles o1, Candles o2) {
				// TODO Auto-generated method stub
				return ObjectUtils.compare(o2.getTime(), o1.getTime());
			}
		};
		
	candles.stream().sorted(comparator).forEach(System.out::println);
//		
//		ArrayList<Price> sortedPriceList = new ArrayList<>();
//		
//		
//		sortedCandles.stream().forEach(x -> sortedPriceList.add(x.getMid()));
//
//		System.out.println(sortedCandles);
				

		// System.out.println(oandaResponse.toString());
		//
		// System.out.println(oandaResponse.getCandles().stream().f);

		// mongoTemplate.insert(oandaResponse);

	//	streamService.stream();

	}

}
