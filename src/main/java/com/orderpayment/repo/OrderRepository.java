package com.orderpayment.repo;


import java.time.LocalDateTime;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.orderpayment.model.Order;
import com.orderpayment.model.Status;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {

	@Query("""
			Select o from Order o
			Where (:status IS NULL OR o.status = :status)
			AND (:userId IS NULL OR o.user.id=:userId)
			AND (:from IS NULL OR o.createdAt >= :from)
			AND (:to IS NULL OR o.createdAt <= : to)
			""")
	public Page<Order> searchOrders(
			@Param("status") Status status,
			@Param ("userId") Long userId,
			@Param ("from") LocalDateTime from,
			@Param("to") LocalDateTime to,
			Pageable pageable
			);
}
