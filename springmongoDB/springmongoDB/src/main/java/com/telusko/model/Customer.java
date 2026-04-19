package com.telusko.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Document
@Data
public class Customer
{
	@Id
	private String id;
	
	private String name;
	
	private String city;
	
	private Integer cusNum;

	
	
	

}
