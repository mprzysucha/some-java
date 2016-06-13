package com.michalprzysucha.shop.model;

import java.io.Serializable;

/**
 * 
 * @author Michal Przysucha
 *
 */
public class Person implements Serializable {
	
	private static final long serialVersionUID = -5546243651192986360L;
	
	private String firstName;
	private String lastName;
	private Address address;
	
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	
	@Override
	public String toString() {
		return "Person [firstName=" + firstName + ", lastName=" + lastName
				+ ", address=" + address + "]";
	}
	
}
