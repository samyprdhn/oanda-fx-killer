package com.satalix.app;

import java.net.Authenticator;
import java.net.InetSocketAddress;
import java.net.PasswordAuthentication;
import java.net.Proxy;
import java.net.Proxy.Type;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.client.RestTemplate;

@Configuration
@EnableScheduling
public class AppConfig {

//	@Bean
//	public MongoTemplate mongoTemplate() {
//		MongoTemplate mongoTemplate = new MongoTemplate(mongoDbFactory());
////		mongoTemplate.setWriteConcern(WriteConcern.W2);
////		mongoTemplate.setWriteResultChecking(WriteResultChecking.EXCEPTION);
//		return mongoTemplate;
//	}
//
//	@Bean
//	public MongoDbFactory mongoDbFactory() {
//		return new SimpleMongoDbFactory(mongoClient(), "oanda");
//	}
//
//	@Bean
//	public MongoClient mongoClient() {
//		return new MongoClient();
//	}
	
	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate(clientHttpRequestFactory());
	}

	private SimpleClientHttpRequestFactory clientHttpRequestFactory() {
		
		SimpleClientHttpRequestFactory factory = new SimpleClientHttpRequestFactory();
		

	
		return factory;
	}
	
	 class ProxyAuthenticator extends Authenticator{
		 
		 private String user, password;

		    public ProxyAuthenticator(String user, String password) {
		        this.user = user;
		        this.password = password;
		    }

		    protected PasswordAuthentication getPasswordAuthentication() {
		        return new PasswordAuthentication(user, password.toCharArray());
		    }

		 
	 }

}
