package com.orderpayment.request;

import java.time.LocalDateTime;
import java.util.ArrayList;

import com.orderpayment.model.Status;
import com.orderpayment.model.User;



public class UserRequest {
	private String name;
	private String email;

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

	public UserRequest() {
		super();
	}
	
	public static User convertToUser(UserRequest request) {
		User u = new User();
		u.setEmail(request.getEmail());
		u.setOrders(new ArrayList<>());
		u.setCreateAt(LocalDateTime.now());
		u.setName(request.getName());
		u.setStatus(Status.ACTIVE);
		return u;
	}
	
	
}
