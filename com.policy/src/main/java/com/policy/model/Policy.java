package com.policy.model;

import org.springframework.stereotype.Component;

@Component
public class Policy {
	
	private int id;
	private String name;
	  private String about;
	  private String maturitydate;
	   
	  
	  
	  public Policy(int id, String name, String about, String maturitydate) {
		super();
		this.id = id;
		this.name = name;
		this.about = about;
		this.maturitydate = maturitydate;
	}
	  public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAbout() {
		return about;
	}
	public void setAbout(String about) {
		this.about = about;
	}
	public String getMaturitydate() {
		return maturitydate;
	}
	public void setMaturitydate(String maturitydate) {
		this.maturitydate = maturitydate;
	}
	  
	  

}
