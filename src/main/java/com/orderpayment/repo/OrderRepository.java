package com.orderpayment.repo;

import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;

import com.orderpayment.model.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {

	Page<Order> searchOrders();
}
