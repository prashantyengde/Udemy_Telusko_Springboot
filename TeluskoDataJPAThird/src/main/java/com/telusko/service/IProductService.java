package com.telusko.service;

import java.util.List;

import com.telusko.entity.Product;

public interface IProductService 
{
	Product searchProductById(Integer id);
	List<Product> searchProductsByIds(Iterable<Integer> ids);
	List<Product> searchProductsByProduct(Product product);
	String deleteProductsByIdsCrud(List<Integer>ids);
	String deleteProductsByIds(List<Integer>ids);

}
