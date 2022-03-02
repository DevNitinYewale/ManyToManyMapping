package com.manyToManyMap;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Cart {
	
	@Id
	private int cart_id;
	private int cart_total;
	
	@ManyToMany(mappedBy = "cart")
	private List<Item> item;

	public int getCart_id() {
		return cart_id;
	}

	public void setCart_id(int cart_id) {
		this.cart_id = cart_id;
	}

	public int getCart_total() {
		return cart_total;
	}

	public void setCart_total(int cart_total) {
		this.cart_total = cart_total;
	}

	public List<Item> getItem() {
		return item;
	}

	public void setItem(List<Item> item) {
		this.item = item;
	}

	/**
	 * @param cart_id
	 * @param cart_total
	 * @param item
	 */
	public Cart(int cart_id, int cart_total, List<Item> item) {
		super();
		this.cart_id = cart_id;
		this.cart_total = cart_total;
		this.item = item;
	}

	public Cart() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
