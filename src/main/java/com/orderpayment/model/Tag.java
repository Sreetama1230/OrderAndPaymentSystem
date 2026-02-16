package com.orderpayment.model;

import java.util.ArrayList;
import java.util.List;

import com.orderpayment.request.TagRequest;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table
public class Tag {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(unique = true)
	private String name;

	@ManyToMany(mappedBy = "tags")
	List<Product> products;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}

	public Tag(String name, List<Product> products) {
		super();
		this.name = name;
		this.products = products;
	}

	public Tag() {
		super();
		// TODO Auto-generated constructor stub
	}

	public static Tag convertToTag(TagRequest tr) {
		Tag tag = new Tag(tr.getName(), new ArrayList<>());
		return tag;
	}

}
