package com.michalprzysucha.samples.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.michalprzysucha.shop.model.Order;
import com.michalprzysucha.shop.service.ShopService;

/**
 * 
 * @author Michal Przysucha
 *
 */
@Component
public class ShopServiceImpl implements ShopService {
	
	@Autowired
	private SomeHelperService someHelperService;

	@Override
	public void makeOrder(Order order) {
		long start = new Date().getTime();
		System.out.println("----------------------------------");
		System.out.println(order);
		someHelperService.helpMe();
		System.out.println(order);
		someHelperService.helpMe();
		System.out.println(order);
		System.out.println("----------------------------------");
		long stop = new Date().getTime();
		System.out.println("Duration: " + (stop - start) + " ms");
		System.out.println("----------------------------------");
	}
	
}
