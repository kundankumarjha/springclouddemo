package com.example.product;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties
public class ProductProperties {
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
