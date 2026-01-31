package com.orderpayment.dto;

import java.math.BigDecimal;

public class OrderItemResponse {

	private int quantity;

	private BigDecimal pricePerUnit;

	private BigDecimal totalPrice;

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public BigDecimal getPricePerUnit() {
		return pricePerUnit;
	}

	public void setPricePerUnit(BigDecimal pricePerUnit) {
		this.pricePerUnit = pricePerUnit;
	}

	public BigDecimal getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(BigDecimal totalPrice) {
		this.totalPrice = totalPrice;
	}

	public OrderItemResponse() {
		super();
		// TODO Auto-generated constructor stub
	}

	public OrderItemResponse(int quantity, BigDecimal pricePerUnit, BigDecimal totalPrice) {
		super();
		this.quantity = quantity;
		this.pricePerUnit = pricePerUnit;
		this.totalPrice = totalPrice;
	}

	

}
