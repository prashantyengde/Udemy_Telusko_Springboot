package com.telusko.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.telusko.entity.Product;
import com.telusko.view.ResultView;

@Repository
public interface IProductRepo extends JpaRepository<Product, Integer> 
{
	//Crud PagingSorting JPA
	
	List<ResultView> findByPriceLessThan(Double price);

}
