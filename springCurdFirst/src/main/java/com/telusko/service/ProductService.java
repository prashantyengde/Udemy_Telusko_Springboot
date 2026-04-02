package com.telusko.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.telusko.entity.Product;
import com.telusko.repo.IProductRepo;

@Service
public class ProductService implements IProductService
{
	
	@Autowired
	private IProductRepo repo;

	@Override
	public String saveproduct(Product product)
	{
		Product pd=repo.save(product);
		return "Product stored with id "+ pd.getId();
	}

	@Override
	public Iterable<Product> saveMultipleProducts(Iterable<Product> products)
	{
		return repo.saveAll(products);
	}

	@Override
	public Iterable<Product> getAllproducts() 
	{
		
		return repo.findAll();
	}

	@Override
	public Iterable<Product> getAllproductsByIds(List<Integer> ids) 
	{
		return repo.findAllById(ids);
	}

	@Override
	public Product getProductById(Integer id)
	{
		
		Optional<Product> optional = repo.findById(id);
		if(optional.isPresent())
		{
			Product pd=optional.get();
			return pd;
		}
		else
		{
			return new Product();
		}
	}

	@Override
	public Boolean isProductAvailable(Integer id) 
	{
		return repo.existsById(id);
		
	}

	@Override
	public Long getTotalProductsCount()
	{
		//System.out.println("Implemeting class of repo "+ repo.getClass().getName());
		return repo.count();
	}
	
	
	@Override
	public String deleteProductById(Integer id)
	{
		Optional<Product> optional = repo.findById(id);
		if(optional.isPresent())
		{
			repo.deleteById(id);
			return "Product with Id "+id+ " is deleted";
		}
		else
		{
			return "Product with Id "+id+ " is not in records";
		}
		
	}

	@Override  //1,2,3,4  ==> 3,4
	public String deleteProductsByIds(List<Integer> ids) 
	{
		List<Product> products = (List<Product>) repo.findAllById(ids);
		if(products.size()!=0)
		{
			repo.deleteAllById(ids);
			return "All Products records with given ids deleted";
		}
		else
		{
			return "Product info with given ids are not in records to delete";
		}
//		if(products.size()==ids.size())
//		{
//			repo.deleteAllById(ids);
//			return "All Products records with given ids deleted";
//		}
//		else
//		{
//			return "Product info with given ids are not in records to delete";
//		}
	}

}
