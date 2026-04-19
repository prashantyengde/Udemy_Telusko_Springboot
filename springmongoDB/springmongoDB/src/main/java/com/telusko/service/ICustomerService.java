package com.telusko.service;

import java.util.List;

import com.telusko.dto.CustomerDTO;
import com.telusko.model.Customer;

public interface ICustomerService 
{
	String registerCustomerInfo(CustomerDTO dto);
	List<Customer> findAllCx();
	String removeDocument(String id);

}
