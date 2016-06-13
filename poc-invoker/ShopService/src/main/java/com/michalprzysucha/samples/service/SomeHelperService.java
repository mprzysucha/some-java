package com.michalprzysucha.samples.service;

import java.math.BigDecimal;

import org.springframework.stereotype.Component;

/**
 * 
 * @author Michal Przysucha
 *
 */
@Component
public class SomeHelperService {

	public void helpMe() {
		System.out.println("--------- helper start -----------");
		for (int i = 0; i < 1000000; i++) {
			new BigDecimal(i);
		}
		System.out.println("----------helper stop ------------");
	}

}
