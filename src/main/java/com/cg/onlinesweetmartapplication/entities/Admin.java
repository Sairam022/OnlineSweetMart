package com.cg.onlinesweetmartapplication.entities;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity 
public class Admin {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	//@OneToOne
	//private Customer customer;
	@OneToOne
	private User user;
	@OneToOne
	private SweetItem item;
	@OneToOne(cascade=CascadeType.ALL)
	private Cart cart;
	@OneToOne
	private Product product;
	
	
	public Admin() {
		
	}
	public Admin(int id, User user, SweetItem item,
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
		return "Admin [id=" + id +  ", user=" + user + ", item="
				+ item + ", cart=" + cart + ", product=" + product + "]";
	}

	
	
}
