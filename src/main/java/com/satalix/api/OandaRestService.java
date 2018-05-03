package com.satalix.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.satalix.OandaResponse;

@Service
public class OandaRestService {

	@Autowired
	private RestTemplate restTemplate;

	private static final String OANDA_URL = "https://api-fxtrade.oanda.com/v3/instruments/USD_JPY/candles?granularity=M5";

	public ResponseEntity<OandaResponse> callApi() {
		return restTemplate.exchange(OANDA_URL, HttpMethod.GET, new HttpEntity<String>(createHeaders()),
				OandaResponse.class);
	}

	private HttpHeaders createHeaders() {
		HttpHeaders header = new HttpHeaders();
		header.set("Authorization", "");
		return header;
	}
	
	
	// ResponseEntity<?> response = restTemplate.exchange(
	// "https://api-fxtrade.oanda.com/v3/instruments/USD_JPY/candles?granularity=M30",
	// HttpMethod.GET,
	// new HttpEntity<String>(createHeaders()), String.class);

	// JSONObject data = new JSONObject(new
	// JSONTokener(response.getBody().toString()));
	//
	// System.out.println(data);
	

}
