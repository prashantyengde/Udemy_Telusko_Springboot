package com.telusko.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.telusko.entity.Product;

import jakarta.transaction.Transactional;

@Repository
public interface IProductRepo extends JpaRepository<Product, Integer> 
{
//	@Query("FROM Product WHERE category=:category")
//	public List<Product> searchByCategory(String category);
	
	@Query("FROM Product WHERE category=:category")
	public List<Product> searchByCategory(@Param("category")String cat);
	
	@Query("SELECT productName, category FROM Product WHERE price BETWEEN :minPrice AND :maxPrice")
	public List<String> searchByPrice(Double minPrice, Double maxPrice);

	@Transactional
	@Modifying
	@Query("UPDATE Product SET price=:newPrice WHERE productName=:productName")
	public int updatePriceByProductName(Double newPrice, String productName);
	
	@Transactional
	@Modifying
	@Query(value = "INSERT INTO product(id, product_name, category, price, quantity) VALUES(?,?,?,?,?)",
    nativeQuery = true)	
	public int insertProductInfo(Integer id, String productName, String category,
			Double price, Integer quantity);
	
	
	
}
