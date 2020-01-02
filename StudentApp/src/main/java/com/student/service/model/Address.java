package com.student.service.model;

import org.springframework.stereotype.Component;

@Component
public class Address {
	
	private String address_1;
	private String address_2;
	private String address_3;
	
	public Address() {
		
	}
	
	public Address(String address_1, String address_2, String address_3) {
		super();
		this.address_1 = address_1;
		this.address_2 = address_2;
		this.address_3 = address_3;
	}
	
	public String getAddress_1() {
		return address_1;
	}
	public void setAddress_1(String address_1) {
		this.address_1 = address_1;
	}
	public String getAddress_2() {
		return address_2;
	}
	public void setAddress_2(String address_2) {
		this.address_2 = address_2;
	}
	public String getAddress_3() {
		return address_3;
	}
	public void setAddress_3(String address_3) {
		this.address_3 = address_3;
	}
	
	
	

}
