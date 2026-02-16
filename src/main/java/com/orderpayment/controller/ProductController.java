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
	public ResponseEntity<ProductResponse> addProduct(@Argument ProductRequest productRequest) {
		return new ResponseEntity<ProductResponse>(productService.saveProduct(productRequest), HttpStatus.CREATED);
	}

	@QueryMapping("findByProductName")
	public ResponseEntity<ProductResponse> findByProductName(@Argument String s) {
		return new ResponseEntity<ProductResponse>(productService.findByProductName(s), HttpStatus.OK);
	}

}
