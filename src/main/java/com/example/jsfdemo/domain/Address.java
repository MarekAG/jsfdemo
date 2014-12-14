package com.example.jsfdemo.domain;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@ManagedBean(name="address")
public class Address implements Serializable{
	
	private static final long serialVersionUID = 6037040079637746956L;
	
	private String street = "";
	private int house_number;
	private String zipCode = "";
	private String city = "";
	
	@Size(min = 2, max = 30)
	public String getStreet() {
		return street;
	}
	
	public void setStreet(String street) {
		this.street = street;
	}
	
	public int getHouse_number() {
		return house_number;
	}
	
	public void setHouse_number(int house_number) {
		this.house_number = house_number;
	}
	
	@Pattern(regexp = "[0-9]{2}-[0-9]{3}")
	public String getZipCode() {
		return zipCode;
	}
	
	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}
	
	@Size(min = 2, max = 20)
	public String getCity() {
		return city;
	}
	
	public void setCity(String city) {
		this.city = city;
	}
																											
	
}
