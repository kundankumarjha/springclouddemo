package com.example.stock;

import java.util.logging.Logger;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StockController {
	private static final Logger LOG = Logger.getLogger(StockController.class.getName());

	private StockProperties stockProperties;

	public StockController(StockProperties stockProperties) {
		this.stockProperties = stockProperties;
	}

	@RequestMapping
	public int getStockCount() {
		LOG.info("Stock Count: " + stockProperties.getCount());
		return stockProperties.getCount();
	}
}
