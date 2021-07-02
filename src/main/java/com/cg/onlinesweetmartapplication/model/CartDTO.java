
package com.cg.onlinesweetmartapplication.model;


public class CartDTO {
	private int cartId;
	private double grandTotal;
	private int productCount;
	private double total;
	private String listProduct;

	 
	public CartDTO() {
			super();
		}
	
	public CartDTO(int cartId, String listProduct,double grandTotal, int productCount, double total) {
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

	
	



