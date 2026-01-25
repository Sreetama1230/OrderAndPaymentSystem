package com.orderpayment.model;

import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class OrderItem {
	
	@Id
	@GeneratedValue(strategy =  GenerationType.IDENTITY)
	private long id;
	@Column
	private int quantity;
	@Column
	private BigDecimal pricePerUnit;
	@Column
	private BigDecimal totalPrice;

	@ManyToOne
	@JoinColumn(name = "order_id")
	private Order order;
	

	@ManyToOne
	@JoinColumn(name = "product_id")
	private  Product product;


	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}


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


	public Order getOrder() {
		return order;
	}


	public void setOrder(Order order) {
		this.order = order;
	}


	public Product getProduct() {
		return product;
	}


	public void setProduct(Product product) {
		this.product = product;
	}


	public OrderItem(int quantity, BigDecimal pricePerUnit, BigDecimal totalPrice, Order order, Product product) {
		super();
		this.quantity = quantity;
		this.pricePerUnit = pricePerUnit;
		this.totalPrice = totalPrice;
		this.order = order;
		this.product = product;
	}
	
	
	
}
