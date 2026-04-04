package com.telusko.service;

import java.util.List;

import com.telusko.entity.Product;

public interface IProductService 
{
	List<Product> searchByPrice(Double price);
	List<Product>  searchByPriceGreaterThan(Double price);
	List<Product>  searchByPriceLessThan(Double price);
	List<Product>  searchByPriceBetween(Double minPrice, Double maxPrice);
    List<Product>  searchByCategoryEquals(String category);
    List<Product>  searchByCategoryInAndPriceBetween(List<String> categories, Double minPrice
    		, Double maxPrice);


	
}
