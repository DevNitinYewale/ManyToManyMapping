package com.manyToManyMap;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Item {
	@Id
	private int item_id;
	private String item_desc;
	private Double item_price;
	
	@ManyToMany
	private List<Cart> cart;

	public int getItem_id() {
		return item_id;
	}

	public void setItem_id(int item_id) {
		this.item_id = item_id;
	}

	public String getItem_desc() {
		return item_desc;
	}

	public void setItem_desc(String item_desc) {
		this.item_desc = item_desc;
	}

	public Double getItem_price() {
		return item_price;
	}

	public void setItem_price(Double item_price) {
		this.item_price = item_price;
	}

	public List<Cart> getCart() {
		return cart;
	}

	public void setCart(List<Cart> cart) {
		this.cart = cart;
	}

	public Item(int item_id, String item_desc, Double item_price, List<Cart> cart) {
		super();
		this.item_id = item_id;
		this.item_desc = item_desc;
		this.item_price = item_price;
		this.cart = cart;
	}

	public Item() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
