package com.telusko;

import java.util.Arrays

;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.telusko.service.IProductService;

@SpringBootApplication
public class TeluskoDataJpaFourthFinderMethodApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext container = SpringApplication.run(TeluskoDataJpaFourthFinderMethodApplication.class, args);
	IProductService service = container.getBean(IProductService.class);
	service.searchByPrice(5000.0).forEach(p->System.out.println(p));
	service.searchByPriceGreaterThan(550.0).forEach(p->System.out.println(p));
	service.searchByPriceLessThan(550.0).forEach(p->System.out.println(p));
	service.searchByPriceBetween(450.0, 5001.0).forEach(p->System.out.println(p));
	service.searchByCategoryEquals("Fashion").forEach(p->System.out.println(p));
	//80
	//50%  --> 50%
	List<String> categories=Arrays.asList("Fashion", "Electronic");
	service.searchByCategoryInAndPriceBetween(categories, 450.0, 6000.0)
	.forEach(p->System.out.println(p));
	
	}

}
