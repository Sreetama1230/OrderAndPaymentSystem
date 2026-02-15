package com.orderpayment.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.orderpayment.model.Tag;

@Repository
public interface TagRepository extends JpaRepository<Tag, Long> {

}
