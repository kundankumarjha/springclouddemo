package com.example.product;

import java.util.logging.Logger;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {
	private static final Logger LOG = Logger.getLogger(ProductController.class.getName());

	private ProductProperties productProperties;

	public ProductController(ProductProperties productProperties) {
		this.productProperties = productProperties;
	}

	@RequestMapping
	public String getProductName() {
		LOG.info("Product Name: " + productProperties.getName());
		return productProperties.getName();
	}
}
