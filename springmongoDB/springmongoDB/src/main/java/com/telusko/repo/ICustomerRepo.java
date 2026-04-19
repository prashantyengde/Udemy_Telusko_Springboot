package com.telusko.repo;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.telusko.model.Customer;

public interface ICustomerRepo extends MongoRepository<Customer, String> {

}
