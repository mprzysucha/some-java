package com.michalprzysucha.shop.model;

import java.io.Serializable;

/**
 * 
 * @author Michal Przysucha
 *
 */
public class Item implements Serializable {
	
	private static final long serialVersionUID = -4781358815588496419L;
	
	private Catalog itemType;
	private Size size;
	
	public Catalog getItemType() {
		return itemType;
	}
	public void setItemType(Catalog itemType) {
		this.itemType = itemType;
	}
	public Size getSize() {
		return size;
	}
	public void setSize(Size size) {
		this.size = size;
	}
	
	@Override
	public String toString() {
		return "Item [itemType=" + itemType + ", size=" + size + "]";
	}

}
