package com.example.details;

import java.util.logging.Logger;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DetailsController {

	private static final Logger LOG = Logger.getLogger(DetailsController.class.getName());

	private ProductService productService;
	private StockService stockService;

	public DetailsController(ProductService productService, StockService stockService) {
		this.productService = productService;
		this.stockService = stockService;
	}

	@RequestMapping
	public String index() {
		String details =  new StringBuilder().append(productService.getProductName()).
				append(" : ").append(stockService.getStockCount()).toString();
		LOG.info("Product: " + details);
		return details;
	}
}
