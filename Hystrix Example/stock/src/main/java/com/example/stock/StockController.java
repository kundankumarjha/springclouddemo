package com.example.stock;

import java.util.logging.Logger;

import org.apache.commons.lang.math.RandomUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@RestController
public class StockController {
	private static final Logger LOG = Logger.getLogger(StockController.class.getName());

	private StockProperties stockProperties;

	public StockController(StockProperties stockProperties) {
		this.stockProperties = stockProperties;
	}

	@RequestMapping
	@HystrixCommand(fallbackMethod = "fallbackMethod")
	public int getStockCount() {
		if(RandomUtils.nextBoolean()) {
			throw new RuntimeException("Failed");
		}
		LOG.info("Stock Count: " + stockProperties.getCount());
		return stockProperties.getCount();
	}
	
	public int fallbackMethod() {
		return 0;
	}
}
