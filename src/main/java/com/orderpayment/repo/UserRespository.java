package com.orderpayment.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.orderpayment.model.User;

public interface UserRespository extends JpaRepository<User, Integer> {

	@Query("Select u from User u where u.name = :name")
	public User findByName( @Param("name") String name);
}
