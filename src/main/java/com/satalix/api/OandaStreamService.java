package com.satalix.api;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.message.BasicHeader;
import org.springframework.stereotype.Service;

@Service
public class OandaStreamService {

	private static final String STREAM_URL = "https://stream-fxtrade.oanda.com/v3/accounts/001-001-1225022-001/pricing/stream?instruments=EUR_USD%2CUSD_CAD";

	public void stream() throws ClientProtocolException, IOException {
		HttpClient httpClient = HttpClientBuilder.create().build();
		HttpUriRequest httpGet = new HttpGet(STREAM_URL);
		httpGet.setHeader(new BasicHeader("Authorization",
				""));

		HttpResponse resp = httpClient.execute(httpGet);
		HttpEntity entity = resp.getEntity();
		InputStream stream = entity.getContent();
		BufferedReader reader = new BufferedReader(new InputStreamReader(stream));

		String line = null;
		while ((line = reader.readLine()) != null) {
			System.out.println(line.toString());
		}

	}

}
