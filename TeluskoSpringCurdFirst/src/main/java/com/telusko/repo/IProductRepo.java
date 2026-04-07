package com.telusko.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.telusko.entity.Product;

@Repository
public interface IProductRepo extends CrudRepository<Product, Integer> 
{

}
