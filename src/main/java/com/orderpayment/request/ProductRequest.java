package com.orderpayment.request;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import com.orderpayment.model.Product;
import com.orderpayment.model.Tag;


public class ProductRequest {


	private String name;

	private String description;

	private BigDecimal price;

	private int stockQuantity;

	private boolean active;
	
	private Set<TagRequest> tagRequest;


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public int getStockQuantity() {
		return stockQuantity;
	}

	public void setStockQuantity(int stockQuantity) {
		this.stockQuantity = stockQuantity;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public ProductRequest() {
		super();
		// TODO Auto-generated constructor stub
	}


	public ProductRequest(String name, String description, BigDecimal price, int stockQuantity, boolean active,
			Set<TagRequest> tagRequest) {
		super();
		this.name = name;
		this.description = description;
		this.price = price;
		this.stockQuantity = stockQuantity;
		this.active = active;
		this.tagRequest = tagRequest;
	}

	public Set<TagRequest> getTagRequest() {
		return tagRequest;
	}

	public void setTagRequest(Set<TagRequest> tagRequest) {
		this.tagRequest = tagRequest;
	}

	public static Product convertToProduct(ProductRequest productRequest) {

		return new Product(productRequest.getName()
				, productRequest.getDescription(), productRequest.getPrice()
				, productRequest.getStockQuantity(), true, LocalDateTime.now(), new ArrayList<>()
				, new TreeSet<>());
	}
}
