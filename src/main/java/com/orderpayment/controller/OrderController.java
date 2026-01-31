package com.orderpayment.controller;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.orderpayment.dto.OrderResponse;
import com.orderpayment.model.Status;
import com.orderpayment.service.OrderService;

@RestController
@RequestMapping("/order/")
public class OrderController {
	
	@Autowired
	private OrderService orderService;
}
