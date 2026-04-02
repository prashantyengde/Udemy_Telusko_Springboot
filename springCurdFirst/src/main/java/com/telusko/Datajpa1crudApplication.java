package com.telusko;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.telusko.entity.Product;
import com.telusko.service.IProductService;

@SpringBootApplication
public class Datajpa1crudApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext container = SpringApplication.run(Datajpa1crudApplication.class, args);
	IProductService service = container.getBean(IProductService.class);
	
	Product pd1=new Product("Laptop", "Electronics", 75000.0, 20);
	
	System.out.println(service.saveproduct(pd1));
	
	List<Product> products=new ArrayList<>();
	products.add(new Product("Mobile", "Electronics", 5000.0, 20));
	products.add(new Product("Watch", "Accessories", 5500.0, 15));
	products.add(new Product("Shoes", "Fashion", 500.0, 40));
	products.add(new Product("BOOKS", "Staionary", 000.0, 50));
	
	service.saveMultipleProducts(products).forEach(p->System.out.println(p));

	service.getAllproducts().forEach(p->System.out.println(p));
	List<Integer> ids=Arrays.asList(2,4,1);
	service.getAllproductsByIds(ids).forEach(p->System.out.println(p));
	
	System.out.println(service.getProductById(4));
	
	System.out.println("Total number of products "+ service.getTotalProductsCount());
	Boolean status=service.isProductAvailable(3);
	if(status)
		System.out.println("Product available");
	else
		System.out.println("Product not available");
	
	int id=8;
	System.out.println(service.deleteProductById(id));
//	List<Integer> ids=Arrays.asList(2,4,1);
//	String status=service.deleteProductsByIds(ids);
//	System.out.println(status);
	
	
	}

}
