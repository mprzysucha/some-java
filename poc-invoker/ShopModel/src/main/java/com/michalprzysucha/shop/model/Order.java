package com.michalprzysucha.shop.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author Michal Przysucha
 *
 */
public class Order implements Serializable {

	private static final long serialVersionUID = -9180096016569940896L;
	
	private Person customer;
	private BigDecimal price;
	private List<Item> items = new ArrayList<Item>();
	
	public Person getCustomer() {
		return customer;
	}
	public void setCustomer(Person customer) {
		this.customer = customer;
	}
	public BigDecimal getPrice() {
		return price;
	}
	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	public List<Item> getItems() {
		return items;
	}
	public void setItems(List<Item> items) {
		this.items = items;
	}
	
	@Override
	public String toString() {
		return "Order [customer=" + customer + ", price=" + price + ", items="
				+ items + "]";
	}

}
