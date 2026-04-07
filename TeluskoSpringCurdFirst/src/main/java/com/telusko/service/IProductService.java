package com.telusko.service;

import java.util.List;

import com.telusko.entity.Product;

public interface IProductService 
{
	String saveproduct(Product product);
	Iterable<Product> saveMultipleProducts(Iterable<Product> products);
	Iterable<Product> getAllproducts();
	Iterable<Product> getAllproductsByIds(List<Integer>ids);
	Product getProductById(Integer id) ;
	Boolean isProductAvailable(Integer id);
	Long getTotalProductsCount();
	String deleteProductById(Integer id);
	String deleteProductsByIds(List<Integer>ids);


}
