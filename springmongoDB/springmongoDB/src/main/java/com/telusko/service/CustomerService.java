package com.telusko.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import com.telusko.dto.CustomerDTO;
import com.telusko.model.Customer;
import com.telusko.repo.ICustomerRepo;

@Service
public class CustomerService implements ICustomerService
{
	
	private ICustomerRepo repo;
	
	public CustomerService(ICustomerRepo repo)
	{
		this.repo=repo;
	}

	@Override
	public String registerCustomerInfo(CustomerDTO dto)
	{
		Customer cx=new Customer();
		cx.setName(dto.getName());
     	cx.setCity(dto.getCity());
     	cx.setCusNum(dto.getCusNum());
		BeanUtils.copyProperties(dto, cx);
		Customer c= repo.save(cx);
		return "Customer info stored with id "+ c.getId();
	}

	@Override
	public List<Customer> findAllCx() 
	{
		return repo.findAll();
	}

	@Override
	public String removeDocument(String id)
	{
		Optional<Customer> optional = repo.findById(id);
		if(optional.isPresent())
		{
			repo.deleteById(id);
			return "Customer Info Deleted with id "+ id;
		}
		return "Customer Info not in records to delete";
	}

}
