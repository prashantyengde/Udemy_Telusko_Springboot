package com.telusko.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.telusko.entity.Product;
import com.telusko.view.View;

@Repository
public interface IProductRepo extends JpaRepository<Product, Integer> 
{
	//Crud PagingSorting JPA
	
	<T extends View>List<T> findByPriceLessThan(Double price,  Class<T> cls);

}
