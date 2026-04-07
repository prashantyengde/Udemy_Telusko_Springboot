package com.telusko;

import java.util.Arrays;

import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.telusko.service.IProductService;

@SpringBootApplication
public class TeluskoDAtaJPAFifthStaticProjectionApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext container = SpringApplication.run(TeluskoDAtaJPAFifthStaticProjectionApplication.class, args);
	IProductService service = container.getBean(IProductService.class);
	
	service.searchByPriceLessThan(1200.5)
	.forEach(p-> System.out.println(p.getCategory()+ " - "+ p.getProductName()));
	}

}
