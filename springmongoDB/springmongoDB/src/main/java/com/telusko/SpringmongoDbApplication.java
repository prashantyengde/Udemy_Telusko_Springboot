package com.telusko;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.telusko.dto.CustomerDTO;
import com.telusko.service.ICustomerService;
import com.telusko.util.IDGenerator;

@SpringBootApplication
public class SpringmongoDbApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext container = SpringApplication.run(SpringmongoDbApplication.class, args);
		ICustomerService service = container.getBean(ICustomerService.class);
		CustomerDTO dto=new CustomerDTO();
		dto.setName("abhishek");
		dto.setCity("bengaluru");
		dto.setCusNum(56);
		String id=IDGenerator.generateID();
		dto.setId(id);
    	String status=service.registerCustomerInfo(dto);
  	System.out.println(status);
  	System.out.println(service.removeDocument("554aba8203"));
		
		service.findAllCx().forEach(c->System.out.println(c));
	
	}

}
