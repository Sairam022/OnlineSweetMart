package com.cg.onlinesweetmartapplication.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.onlinesweetmartapplication.entities.Product;
import com.cg.onlinesweetmartapplication.exceptions.InvalidProductDetailsException;
import com.cg.onlinesweetmartapplication.exceptions.ProductNotFoundException;
import com.cg.onlinesweetmartapplication.model.ProductDTO;
import com.cg.onlinesweetmartapplication.service.iProductService;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/osm")
public class ProductController {
	private static final Logger logger = LoggerFactory.getLogger(ProductController.class);
	
	@Autowired
	private iProductService productService;
	
	@PostMapping(value="/addProduct")
	public ResponseEntity<ProductDTO> addProduct(@RequestBody Product product) throws InvalidProductDetailsException
	{
		logger.info("addProduct URL is Opened");
		logger.info("addProduct() in initiated");
		
		ResponseEntity<ProductDTO> productResponse;
		ProductDTO result = productService.addProduct(product);
		productResponse = new ResponseEntity<ProductDTO>(result, HttpStatus.OK);
		logger.info("addProduct() had executed");
		return productResponse;
	}
	
	@GetMapping(value="/viewAllProducts")
	public List<ProductDTO> showAllProducts() throws ProductNotFoundException
	{
		logger.info("viewAllProducts URL is Opened");
		logger.info("showAllProducts() in initiated");
		logger.info("showAllProducts() had executed");
		return productService.showAllProducts();
	}
	
	@GetMapping(value="/viewProduct/{id}")
	public ResponseEntity<ProductDTO> showProductById(@PathVariable int id) throws ProductNotFoundException
	{
		logger.info("viewProduct By Id URL is Opened");
		logger.info("showProductById() in initiated");
		
		ResponseEntity<ProductDTO> productResponse;
		ProductDTO result = productService.showProductById(id);
		productResponse = new ResponseEntity<ProductDTO>(result, HttpStatus.ACCEPTED);
		logger.info("showPrdouctsById() has executed");
		return productResponse;
	}
	
	@GetMapping(value="/viewProductsByAvailability")
	public List<ProductDTO> showProductsByAvailablity() throws ProductNotFoundException
	{
		logger.info("viewProductsByAvailability URL is Opened");
		logger.info("showProductsByAvailability() in initiated");
		logger.info("showProductsByAvailability() had executed");
		return productService.showProductsByAvailability();
	}
	
	@PutMapping(value="/updateProduct/{id}")
	public ResponseEntity<ProductDTO> updateProduct(@RequestBody Product product, @PathVariable int id) throws ProductNotFoundException
	{
		logger.info("updateProduct URL is Opened");
		logger.info("updateProduct() in initiated");
		
		ResponseEntity<ProductDTO> productResponse;
		ProductDTO result = productService.updateProduct(product, id);
		productResponse = new ResponseEntity<ProductDTO>(result, HttpStatus.OK);
		logger.info("updateProduct() has executed");
		return productResponse;
	}
	
	@DeleteMapping(value="/deleteProduct/{id}")
	public ResponseEntity<ProductDTO> deleteProduct(@PathVariable int id) throws ProductNotFoundException
	{
		logger.info("deleteProduct URL is Opened");
		logger.info("deleteProduct() in initiated");
		
		ResponseEntity<ProductDTO> productResponse;
		ProductDTO result = productService.deleteProduct(id);
		productResponse = new ResponseEntity<ProductDTO>(result, HttpStatus.ACCEPTED);
		logger.info("deleteProduct() has executed");
		return productResponse;
	}
}
