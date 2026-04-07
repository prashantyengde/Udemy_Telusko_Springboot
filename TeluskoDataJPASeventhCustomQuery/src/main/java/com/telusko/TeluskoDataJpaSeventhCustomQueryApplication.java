package com.telusko;

import java.util.Arrays;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.telusko.service.IProductService;

@SpringBootApplication
public class TeluskoDataJPASeventhCustomQueryApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext container = SpringApplication.run(TeluskoDataJPASeventhCustomQueryApplication.class, args);
	IProductService service = container.getBean(IProductService.class);

	service.findByCategory("Gaming").forEach(p->System.out.println(p));
	
	service.findByPrice(350.5, 2500.5).forEach(p->System.out.println(p));
	
//	int rowAffected=service.updateThePriceByProductName(545.5, "Shoes");
//	System.out.println("Number of rows updated "+ rowAffected);
	
//	int rowAffected=service.insertTheProductInfo(45, "ps5", "Gaming", 55505.5, 4);
//	System.out.println("Number of rows added "+ rowAffected);
	
	}

}
