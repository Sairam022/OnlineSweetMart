package com.cg.onlinesweetmartapplication.model;

import org.springframework.stereotype.Component;

import com.cg.onlinesweetmartapplication.entities.Cart;
import com.cg.onlinesweetmartapplication.entities.Customer;
import com.cg.onlinesweetmartapplication.entities.Product;
import com.cg.onlinesweetmartapplication.entities.SweetItem;
import com.cg.onlinesweetmartapplication.entities.User;


@Component
public class AdminDTO {

	
	private int id;
//	private Customer customer;
	private User user;
	private SweetItem item;
	private Cart cart;
	private Product product;
	
	
	public AdminDTO() {
		
	}
	public AdminDTO(int id, User user, SweetItem item, 
			Cart cart,Product product) {
		super();
		this.id = id;
//		this.customer = customer;
		this.user = user;
		this.item = item;
		this.cart = cart;
		this.product = product;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
//	public Customer getCustomer() {
//		return customer;
//	}
//	public void setCustomer(Customer customer) {
//		this.customer = customer;
//	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public SweetItem getItem() {
		return item;
	}
	public void setItem(SweetItem item) {
		this.item = item;
	}
	public Cart getCart() {
		return cart;
	}
	public void setCart(Cart cart) {
		this.cart = cart;
	}
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	@Override
	public String toString() {
		return "AdminDTO [id=" + id + ",  user=" + user + ", item="
				+ item + ", cart=" + cart + ", product=" + product + "]";
	}

	
	
}
