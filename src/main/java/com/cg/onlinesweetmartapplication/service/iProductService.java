package com.cg.onlinesweetmartapplication.service;

import java.util.List;

import com.cg.onlinesweetmartapplication.entities.Product;
import com.cg.onlinesweetmartapplication.exceptions.InvalidProductDetailsException;
import com.cg.onlinesweetmartapplication.exceptions.ProductNotFoundException;
import com.cg.onlinesweetmartapplication.model.ProductDTO;

public interface iProductService{

	public ProductDTO addProduct(Product product) throws InvalidProductDetailsException;
	public ProductDTO updateProduct(Product product, int productId) throws ProductNotFoundException;
	public ProductDTO deleteProduct(int productId) throws ProductNotFoundException;
	public ProductDTO showProductById(int productId) throws ProductNotFoundException;
	public List<ProductDTO> showAllProducts() throws ProductNotFoundException;
	public List<ProductDTO> showProductsByAvailability() throws ProductNotFoundException;
	
}
