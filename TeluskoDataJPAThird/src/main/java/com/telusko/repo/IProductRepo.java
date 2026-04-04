package com.telusko.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.telusko.entity.Product;

@Repository
public interface IProductRepo extends JpaRepository<Product, Integer> 
{
}
