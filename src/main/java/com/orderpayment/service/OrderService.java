package com.orderpayment.service;


import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.orderpayment.dto.OrderResponse;
import com.orderpayment.model.Order;
import com.orderpayment.model.Status;
import com.orderpayment.repo.OrderRepository;

@Service
public class OrderService {

	@Autowired
	private OrderRepository orderRepository;
	
	Logger logger = LoggerFactory.getLogger(OrderService.class);
	
	public List<OrderResponse> searchOrders(Status status,Long userId,LocalDateTime from,LocalDateTime to,int pageNumber , int pageSize){
			Pageable page =	PageRequest.of(pageNumber, pageSize);
			// there will be circular problem so create the response DTO
			logger.info("Calling the DB layer");
			
		return orderRepository.searchOrders(status,userId,from,to,page).stream().map(p->OrderResponse.convertToOrderResponse(p)).collect(Collectors.toList());
		
	}
	
}
