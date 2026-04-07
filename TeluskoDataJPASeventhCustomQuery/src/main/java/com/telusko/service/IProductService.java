package com.telusko.service;

import java.util.List;

import org.springframework.data.repository.query.Param;

import com.telusko.entity.Product;

public interface IProductService 
{
	public List<Product> findByCategory(@Param("category")String cat);
	public List<String> findByPrice(Double minPrice, Double maxPrice);
	public int updateThePriceByProductName(Double newPrice, String productName);
	public int insertTheProductInfo(Integer id, String productName, String category,
			Double price, Integer quantity);

	
}
