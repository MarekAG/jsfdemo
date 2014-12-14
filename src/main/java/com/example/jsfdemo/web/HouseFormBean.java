package com.example.jsfdemo.web;

import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.bean.SessionScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.model.ListDataModel;
import javax.faces.validator.ValidatorException;
import javax.inject.Inject;
import javax.inject.Named;

import com.example.jsfdemo.domain.House;
import com.example.jsfdemo.service.HouseManager;


@SessionScoped
@Named("houseBean")
public class HouseFormBean implements Serializable {

	private static final long serialVersionUID = 4748856762144576328L;
	
	private House house = new House();
	
	private ListDataModel<House> houses = new ListDataModel<House>();
	
	@Inject
	private HouseManager hm;

	public House getHouse() {
		return house;
	}

	public void setHouse(House house) {
		this.house = house;
	}
	
	public ListDataModel<House> getAllHouses() {
		houses.setWrappedData(hm.getAllHouses());
		return houses;
	}
	
	public String addHouse() {
		hm.addHouse(house);
		return "showHouses";
	}
	
	public String deleteHouse() {
		House houseToDelete = houses.getRowData();
		hm.deleteHouse(houseToDelete);
		return null;
	}
	
	public void uniqueAddress(FacesContext context, UIComponent component,
			Object value) {

		String address = (String) value;

		for (House house : hm.getAllHouses()) {
			if (house.getAddress().equalsIgnoreCase(address)) {
				FacesMessage message = new FacesMessage(
						"House with this address already exists in database");
				message.setSeverity(FacesMessage.SEVERITY_ERROR);
				throw new ValidatorException(message);
			}
		}
	}
	

}
