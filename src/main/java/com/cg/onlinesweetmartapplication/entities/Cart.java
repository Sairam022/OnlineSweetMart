package com.cg.onlinesweetmartapplication.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Cart")
public class Cart {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "CART_ID")
    private int cartId;
	@Column(name = "GRAND_TOTAL")
    private double grandTotal ;
	@Column(name = "PRODUCT_COUNT")
    private int productCount;
	@Column(name = "TOTAL")    
    private double total;
	@Column(name = "LIST_PRODUCT")
	private String listProduct;

	
	public Cart() {
		super();
	}
	public Cart(int cartId,String listProduct,double grandTotal, int productCount, double total) {
		super();
		this.cartId = cartId;
		this.grandTotal = grandTotal;
		this.productCount = productCount;
		this.total = total;
		this.listProduct= listProduct;
	}
	public int getCartId() {
		return cartId;
	}
	public void setCartId(int cartId) {
		this.cartId = cartId;
	}
	public double getGrandTotal() {
		return grandTotal;
	}
	public void setGrandTotal(double grandTotal) {
		this.grandTotal = grandTotal;
	}
	public int getProductCount() {
		return productCount;
	}
	public void setProductCount(int productCount) {
		this.productCount = productCount;
	}
	public double getTotal() {
		return total;
	}
	public void setTotal(double total) {
		this.total = total;
	}
	public String getListProduct() {
		return listProduct;
	}
	public void setListProduct(String listProduct) {
		this.listProduct = listProduct;
	}


	
	@Override
	public String toString() {
		return "Cart [cartId=" + cartId + ", grandTotal=" + grandTotal + ", productCount=" + productCount + ", total="
				+ total + ", listProduct=" + listProduct + "]";
	}


	
}

