package com.orderpayment.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.orderpayment.model.User;
import com.orderpayment.request.UserRequest;
import com.orderpayment.response.UserResponse;
import com.orderpayment.service.UserService;

@RestController
@RequestMapping("/api/users")
public class UserController {

	@Autowired
	private UserService service;

	@PostMapping
	public ResponseEntity<User> createUser(@RequestBody UserRequest request) {
		User u = service.createUser(request);
		return new ResponseEntity<User>(u, HttpStatus.CREATED);

	}

	@GetMapping
	public ResponseEntity<UserResponse> getByName(@RequestParam String name) {
		return new ResponseEntity<UserResponse>(service.getByName(name), HttpStatus.OK);
	}

}
