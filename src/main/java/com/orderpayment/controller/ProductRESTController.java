package com.orderpayment.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.orderpayment.response.ProductResponse;
import com.orderpayment.service.ProductService;

@RestController
@RequestMapping("/products")
public class ProductRESTController {

	@Autowired
	private ProductService productService;

	@GetMapping("/all")
	public Page<ProductResponse> findAll(@RequestParam int pageNumber, @RequestParam int pageSize) {

		return productService.findAll(pageNumber, pageSize, null);
	}

	@GetMapping()
	public Page<ProductResponse> findAll(@RequestParam int pageNumber, @RequestParam int pageSize,
			@RequestParam String sort) {

		return productService.findAll(pageNumber, pageSize,sort);
	}
}
