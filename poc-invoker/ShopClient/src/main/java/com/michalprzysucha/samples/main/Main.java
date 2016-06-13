package com.michalprzysucha.samples.main;

import java.math.BigDecimal;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import com.michalprzysucha.samples.service.ShopServiceClient;
import com.michalprzysucha.shop.model.Address;
import com.michalprzysucha.shop.model.Catalog;
import com.michalprzysucha.shop.model.Item;
import com.michalprzysucha.shop.model.Order;
import com.michalprzysucha.shop.model.Person;
import com.michalprzysucha.shop.model.Size;

public class Main {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
				new String[] { "context.xml" });
		ShopServiceClient shopServiceClient = (ShopServiceClient) context.getBean("shopServiceClient");
		Order order = createOrder();
		System.out.println(order);
		Authentication auth = new UsernamePasswordAuthenticationToken("michal", "michal");
		SecurityContextHolder.getContext().setAuthentication(auth);
		shopServiceClient.makeOrder(order);
		context.close();
	}
	
	private static Order createOrder() {
		Order order = new Order();
		order.setPrice(new BigDecimal(123));
		Person customer = new Person();
		customer.setFirstName("John");
		customer.setLastName("Smith");
		Address address = new Address();
		address.setCity("L.A.");
		customer.setAddress(address);
		order.setCustomer(customer);
		Item item1 = new Item();
		item1.setItemType(Catalog.TSHIRT_1ZC48);
		item1.setSize(Size.XL);
		order.getItems().add(item1);
		Item item2 = new Item();
		item2.setItemType(Catalog.TSHIRT_1ZE48);
		item2.setSize(Size.M);
		order.getItems().add(item2);
		return order;
	}

}
