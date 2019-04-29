package com.example.details;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ProductService {
	private static final String URL = "http://localhost:8001";
	private RestTemplate rest;

	public ProductService(RestTemplate rest) {
		this.rest = rest;
	}

	public String getProductName() {
		return rest.getForObject(URL, String.class);
	}
}
