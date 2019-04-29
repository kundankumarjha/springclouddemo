package com.example.details;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class StockService {
	private static final String URL = "http://localhost:9001";
	private RestTemplate rest;

	public StockService(RestTemplate rest) {
		this.rest = rest;
	}

	public int getStockCount() {
		return Integer.parseInt(rest.getForObject(URL, String.class));
	}
}
