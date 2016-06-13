package com.michalprzysucha.shop.model;

import java.io.Serializable;

/**
 * 
 * @author Michal Przysucha
 *
 */
public class Address implements Serializable {

	private static final long serialVersionUID = -5971322357478454332L;
	
	private String streetName;
	private String streetNumber;
	private String apartmentNumber;
	private String zipcode;
	private String city;
	
	public String getStreetName() {
		return streetName;
	}
	public void setStreetName(String streetName) {
		this.streetName = streetName;
	}
	public String getStreetNumber() {
		return streetNumber;
	}
	public void setStreetNumber(String streetNumber) {
		this.streetNumber = streetNumber;
	}
	public String getApartmentNumber() {
		return apartmentNumber;
	}
	public void setApartmentNumber(String apartmentNumber) {
		this.apartmentNumber = apartmentNumber;
	}
	public String getZipcode() {
		return zipcode;
	}
	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	
	@Override
	public String toString() {
		return "Address [streetName=" + streetName + ", streetNumber="
				+ streetNumber + ", apartmentNumber=" + apartmentNumber
				+ ", zipcode=" + zipcode + ", city=" + city + "]";
	}
	
}
