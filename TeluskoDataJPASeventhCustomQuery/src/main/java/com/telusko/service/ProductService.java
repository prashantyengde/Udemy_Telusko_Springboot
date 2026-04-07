package com.telusko.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.telusko.entity.Product;
import com.telusko.repo.IProductRepo;

@Service
public class ProductService implements IProductService
{
	
	@Autowired
	private IProductRepo repo;

	@Override
	public List<Product> findByCategory(String cat) {
		
		return repo.searchByCategory(cat);
	}

	@Override
	public List<String> findByPrice(Double minPrice, Double maxPrice) {
		return repo.searchByPrice(minPrice, maxPrice);
	}

	@Override
	public int updateThePriceByProductName(Double newPrice, String productName) {
		
		return repo.updatePriceByProductName(newPrice, productName);
	}

	@Override
	public int insertTheProductInfo(Integer id, String productName, String category, Double price, Integer quantity) {
		
		return repo.insertProductInfo(id, productName, category, price, quantity);
	}

	
}
