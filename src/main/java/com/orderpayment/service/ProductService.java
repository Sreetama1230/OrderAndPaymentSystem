package com.orderpayment.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.orderpayment.exception.ProductNotFoundException;
import com.orderpayment.model.Product;
import com.orderpayment.model.Tag;
import com.orderpayment.repo.ProductRepository;
import com.orderpayment.repo.TagRepository;
import com.orderpayment.request.ProductRequest;
import com.orderpayment.response.ProductResponse;

@Service
public class ProductService {

	@Autowired
	private ProductRepository productRepository;

	@Autowired
	private TagRepository tagRepository;

	Logger log = LoggerFactory.getLogger(ProductService.class);

	public ProductResponse saveProduct(ProductRequest productRequest) {
		Set<Tag> tags = productRequest.getTagRequest().stream().map(tr -> Tag.convertToTag(tr))
				.collect(Collectors.toSet());
		Product newProd = ProductRequest.convertToProduct(productRequest);
		for (Tag tg : tags) {
			tg.setProducts(new ArrayList<>(List.of(newProd)));
			tagRepository.save(tg);
		}

		newProd.setTags(tags);

		Product pct = productRepository.save(newProd);
		log.info("product added successfully: " + pct.getId());
		return ProductResponse.convertToProductResponse(pct);
	}

	public ProductResponse findByProductName(String name) {
		Product dbProduct = productRepository.findByName(name);
		if (dbProduct == null) {
			throw new ProductNotFoundException("product is not present with this name!");
		}
		return ProductResponse.convertToProductResponse(dbProduct);
	}

	public Page<ProductResponse> findAll(int pageNumber, int pageSize, String sort) {
		PageRequest pageReq = null;
		if (sort == null) {
			pageReq = PageRequest.of(pageNumber, pageSize);

		} else {
			pageReq = PageRequest.of(pageNumber, pageSize, Sort.by(sort).ascending());

		}

		Page<ProductResponse> resp = productRepository.findAll(pageReq)
				.map(p -> ProductResponse.convertToProductResponse(p));

		return resp;

	}
}
