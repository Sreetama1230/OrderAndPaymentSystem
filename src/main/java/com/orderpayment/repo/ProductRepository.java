package com.orderpayment.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.orderpayment.model.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

	@Query("Select p from Product p where name = :name")
	public Product findByName(@Param("name") String name);
}
