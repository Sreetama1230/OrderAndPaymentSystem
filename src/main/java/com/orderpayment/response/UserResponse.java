package com.orderpayment.response;

import java.util.List;

import com.orderpayment.model.Order;
import com.orderpayment.model.Status;
import com.orderpayment.model.User;

public class UserResponse {

	private int id;

	private String name;

	private String email;

	private Status status;

	private List<OrderResponse> orderResponse;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public List<OrderResponse> getOrderResponse() {
		return orderResponse;
	}

	public void setOrderResponse(List<OrderResponse> orderResponse) {
		this.orderResponse = orderResponse;
	}

	public UserResponse() {
		super();
		// TODO Auto-generated constructor stub
	}

	public UserResponse(int id, String name, String email, Status status, List<OrderResponse> orderResponse) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.status = status;
		this.orderResponse = orderResponse;
	}

	public static UserResponse convertToUserResponse(User u) {
		
	List<OrderResponse> ors=	u.getOrders().stream().map(o-> OrderResponse.convertToOrderResponse(o)).toList();
		UserResponse response = 
				
				new UserResponse(u.getId() , u.getName(), u.getEmail()
						, u.getStatus(), ors);
		return response;
	}

}
