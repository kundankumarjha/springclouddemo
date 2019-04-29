package com.example.details;

import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@RibbonClient("product")
public class ProductService {
	private static final Logger LOG = Logger.getLogger(ProductService.class.getName());

	@Autowired
	private LoadBalancerClient client;
	private RestTemplate rest;

	public ProductService(RestTemplate rest) {
		this.rest = rest;
	}

	public String getProductName() {
		String URL = client.choose("product").getUri().toString();
		LOG.info("Picked URL : " + URL);
		return rest.getForObject(URL, String.class);
	}
}
