package com.orderpayment.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.orderpayment.model.Order;
import com.orderpayment.model.OrderItem;
import com.orderpayment.model.Status;

public class OrderResponse {


	private long id;

	private String orderNumber;

	private Status status;

	private BigDecimal totalAmount;

	private LocalDateTime createdAt;

	private  LocalDateTime updatedAt;

	private String user_name;
	
	List<OrderItemResponse> orderItems;

	private String paymentReference;

	public OrderResponse() {
		super();
		// TODO Auto-generated constructor stub
	}



	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getOrderNumber() {
		return orderNumber;
	}

	public void setOrderNumber(String orderNumber) {
		this.orderNumber = orderNumber;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public BigDecimal getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(BigDecimal totalAmount) {
		this.totalAmount = totalAmount;
	}

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}

	public LocalDateTime getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(LocalDateTime updatedAt) {
		this.updatedAt = updatedAt;
	}

	public String getUser_name() {
		return user_name;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}

	public List<OrderItemResponse> getOrderItems() {
		return orderItems;
	}

	public void setOrderItems(List<OrderItemResponse> orderItems) {
		this.orderItems = orderItems;
	}

	public String getPaymentReference() {
		return paymentReference;
	}

	public void setPaymentReference(String paymentReference) {
		this.paymentReference = paymentReference;
	}
	
	public OrderResponse(long id, String orderNumber, Status status, BigDecimal totalAmount, LocalDateTime createdAt,
			LocalDateTime updatedAt, String user_name, List<OrderItemResponse> orderItems, String paymentReference) {
		super();
		this.id = id;
		this.orderNumber = orderNumber;
		this.status = status;
		this.totalAmount = totalAmount;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
		this.user_name = user_name;
		this.orderItems = orderItems;
		this.paymentReference = paymentReference;
	}
	public static OrderResponse convertToOrderResponse(Order order) {
		
		List<OrderItemResponse>  orderItemResponses = new ArrayList<>();
		
		for(OrderItem orderItem : order.getOrderItems()) {
			orderItemResponses.add(new OrderItemResponse(orderItem.getQuantity(), orderItem.getPricePerUnit(), orderItem.getTotalPrice()));
		}
		
		
		return new OrderResponse(order.getId(),order.getOrderNumber(),order.getStatus(),order.getTotalAmount(),order.getCreatedAt(),order.getUpdatedAt()
				,order.getUser().getName(),orderItemResponses,order.getPayment().getPaymentReference());
	}

}
