package com.orderpayment.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import com.orderpayment.request.ProductRequest;
import com.orderpayment.response.ProductResponse;
import com.orderpayment.service.ProductService;

@Controller
public class ProductController {

	@Autowired
	private ProductService productService;

	@MutationMapping("createProduct")
	public ProductResponse addProduct(@Argument ProductRequest prodReq) {
		return productService.saveProduct(prodReq);
	}

	@QueryMapping("findByProductName")
	public ProductResponse findByProductName(@Argument String name) {
		return productService.findByProductName(name);
	}

}
