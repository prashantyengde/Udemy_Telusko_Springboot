package com.telusko;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.telusko.service.IProductService;
import com.telusko.view.ResultView3;

@SpringBootApplication
public class Datajpa1crudApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext container = SpringApplication.run(Datajpa1crudApplication.class, args);
	IProductService service = container.getBean(IProductService.class);
	
	service.searchByPriceLessThan(1200.0, ResultView3.class)
	.forEach(p->System.out.println(p.getProductName()+ " : "+ p.getQuantity()));
	}

}
