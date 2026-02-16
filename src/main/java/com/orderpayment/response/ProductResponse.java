package com.orderpayment.response;

import java.math.BigDecimal;
import java.util.Set;
import java.util.stream.Collectors;

import com.orderpayment.model.Product;
import com.orderpayment.model.Tag;

public class ProductResponse {

	private Long id;

	private String name;

	private String description;

	private BigDecimal price;

	private int stockQuantity;

	private boolean active;

	private Set<TagResponse> tagResponse;

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

	public Set<TagResponse> getTagResponse() {
		return tagResponse;
	}

	public void setTagResponse(Set<TagResponse> tagResponse) {
		this.tagResponse = tagResponse;
	}

	public ProductResponse(Long id, String name, String description, BigDecimal price, int stockQuantity,
			boolean active, Set<TagResponse> tagResponse) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.price = price;
		this.stockQuantity = stockQuantity;
		this.active = active;
		this.tagResponse = tagResponse;
	}

	public Long getId() {
		return id;
	}


	public ProductResponse() {
		super();
	}

	public static ProductResponse convertToProductResponse(Product pd) {
		Set<TagResponse> tagsResp = pd.getTags().stream().map(t -> TagResponse.convertToTagResponse(t))
				.collect(Collectors.toSet());
		
		return new ProductResponse(pd.getId(), pd.getName(), pd.getDescription(), pd.getPrice(), pd.getStockQuantity(),
				pd.isActive(), tagsResp);
	}
}
