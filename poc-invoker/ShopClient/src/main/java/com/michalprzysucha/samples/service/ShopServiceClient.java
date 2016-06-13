package com.michalprzysucha.samples.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.remoting.caucho.BurlapProxyFactoryBean;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import com.michalprzysucha.shop.model.Order;
import com.michalprzysucha.shop.service.ShopService;

/**
 * 
 * @author Michal Przysucha
 *
 */
@Component
public class ShopServiceClient {
	
	@Autowired
	private BurlapProxyFactoryBean shopServiceBurlapProxy;
	
	@Autowired
	private ShopService shopService;
	
	public void makeOrder(Order order) {
		System.out.println(shopService.getClass().getName());
		shopServiceBurlapProxy.setUsername(SecurityContextHolder.getContext().getAuthentication().getName());
		shopServiceBurlapProxy.setPassword(SecurityContextHolder.getContext().getAuthentication().getCredentials().toString());
		shopService.makeOrder(order);
	}
	
}
