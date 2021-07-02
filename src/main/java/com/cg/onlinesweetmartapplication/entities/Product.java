package com.cg.onlinesweetmartapplication.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
	

@Entity
@Table(name="Product")
public class Product {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "PRODUCT_ID")
    private int productId;
	@Column(name = "PRODUCT_NAME")
    private String name;
	@Column(name = "PRODUCT_PRICE")
    private Double price;
	@Column(name = "DESCRIPTION")
    private String description;
	@Column(name = "PRODUCT_AVAILABILITY")
    private Boolean available = true;
	
	
	public Product(int productId, String name, Double price, String description, Boolean available) {
		super();
		this.productId = productId;
		this.name = name;
		this.price = price;
		this.description = description;
		this.available = available;
	}
	public Product() {
		super();
	}
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Boolean getAvailable() {
		return available;
	}
	public void setAvailable(Boolean available) {
		this.available = available;
	}
	
	@Override
	public String toString() {
		return "Product [productId=" + productId + ", name=" + name + ", price=" + price + ", description="
				+ description + ", available=" + available + "]";
	}
	

	
}
