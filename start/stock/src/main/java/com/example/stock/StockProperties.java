package com.example.stock;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties
public class StockProperties {
	private int count;

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}
	
}
