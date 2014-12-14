package com.example.jsfdemo.service;

import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.ApplicationScoped;

import com.example.jsfdemo.domain.House;

@ApplicationScoped
public class HouseManager {
	private List<House> db = new ArrayList<House>();

	public void addHouse(House house) {
		House newHouse = new House();
		
		newHouse.setSize(house.getSize());
		newHouse.setAddressBean(house.getAddressBean());
		newHouse.setAddress(house.getAddress());
		newHouse.setNrOfDoors(house.getNrOfDoors());
		newHouse.setNrOfFloors(house.getNrOfFloors());
		newHouse.setColor(house.getColor());
		newHouse.setYoc(house.getYoc());
		newHouse.setImageUrl(house.getImageUrl());
	
		db.add(newHouse);
	}
	
	public void deleteHouse(House house) {
		House houseToRemove = null;
		for(House h : db) {
			if(house.getAddress().equals(h.getAddress())) {
				houseToRemove = h;
				break;
			}
		}
		if(houseToRemove != null) {
			db.remove(houseToRemove);
		}
	}
	
	public List<House> getAllHouses() {
		return db;
	}
}
