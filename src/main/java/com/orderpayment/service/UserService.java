package com.orderpayment.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.orderpayment.exception.UserNotFoundException;
import com.orderpayment.model.User;
import com.orderpayment.repo.UserRespository;
import com.orderpayment.request.UserRequest;
import com.orderpayment.response.UserResponse;

@Service
public class UserService {

	
	@Autowired
	private UserRespository respository;
	
	public User createUser(UserRequest request) {
		return respository.save(UserRequest.convertToUser(request));
	}
	
	public UserResponse getByName(String name) {
		User u = respository.findByName(name);
		if(u == null) {
			 throw new UserNotFoundException("user is not present with this name!");
		}
		return UserResponse.convertToUserResponse(u);
	}
	
	
}
