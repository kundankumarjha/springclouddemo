package com.example.details;

import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@RibbonClient("stock")
public class StockService {
	private static final Logger LOG = Logger.getLogger(ProductService.class.getName());

	@Autowired
	private LoadBalancerClient client;
	private RestTemplate rest;

	public StockService(RestTemplate rest) {
		this.rest = rest;
	}

	public int getStockCount() {
		String URL = client.choose("stock").getUri().toString();
		LOG.info("Picked URL : " + URL);
		return rest.getForObject(URL, Integer.class);
	}
}
