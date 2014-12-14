package com.example.jsfdemo.domain;

import java.io.Serializable;
import java.util.Date;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;

@ManagedBean(name = "house", eager = true) 
public class House implements Serializable {

	private static final long serialVersionUID = -8662458169656189998L;
	
	private int size;
	@ManagedProperty(value = "#{address}")
	private Address addressBean;
	private String address = "";
	private int nrOfDoors;
	private int nrOfFloors;
	private String color = "";
	private Date yoc = new Date();
	private String imageUrl = "";

	@Min(20)
	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}
	
	@NotNull
	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = getAddressBean().toString();
	}

	public Address getAddressBean() {
		return addressBean;
	}

	public void setAddressBean(Address address) {
		this.addressBean = address;
	}

	@Min(1)
	public int getNrOfDoors() {
		return nrOfDoors;
	}

	public void setNrOfDoors(int nrOfDoors) {
		this.nrOfDoors = nrOfDoors;
	}

	@Min(1)
	public int getNrOfFloors() {
		return nrOfFloors;
	}

	public void setNrOfFloors(int nrOfFloors) {
		this.nrOfFloors = nrOfFloors;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	@Past
	public Date getYoc() {
		return yoc;
	}

	public void setYoc(Date yoc) {
		this.yoc = yoc;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	@Override
	public String toString() {
		return "<img src='" + this.getImageUrl()
				+ "' height='150' width='200'> Metraż (m<sup>2</sup>): "
				+ this.getSize() + " <br/>Adres: " + this.addressBean
				+ " <br/>Ilość drzwi: " + this.nrOfDoors
				+ " <br/>Ilość pięter: " + this.nrOfFloors + " <br/>Kolor: "
				+ this.color + " <br/>Rok budowy: " + this.yoc
				+ " <br/>Autor: ";

	}

}