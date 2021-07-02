package com.cg.onlinesweetmartapplication.serviceImpl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.onlinesweetmartapplication.entities.Product;
import com.cg.onlinesweetmartapplication.exceptions.InvalidProductDetailsException;
import com.cg.onlinesweetmartapplication.exceptions.ProductNotFoundException;
import com.cg.onlinesweetmartapplication.model.ProductDTO;
import com.cg.onlinesweetmartapplication.repository.iProductRepository;
import com.cg.onlinesweetmartapplication.service.iProductService;
import com.cg.onlinesweetmartapplication.utils.ProductUtils;

@Service
public class ProductServiceImpl implements iProductService {
	
	private static final Logger logger = LoggerFactory.getLogger(ProductServiceImpl.class);
	
	@Autowired
	private iProductRepository productRepo;
	
	@Override
	public ProductDTO addProduct(Product product) throws InvalidProductDetailsException {
		logger.info("addProduct() service is initiated");
		Product productEntity;
		if(product.getName()==null || product.getAvailable()==null || product.getDescription()== null || product.getPrice()==null)
		{
			throw new InvalidProductDetailsException("Enter All The Required Product details");
		}
		else
		{
			productEntity = productRepo.save(product);
		}
		logger.info("addProduct() had executed");
		return ProductUtils.convertToProductDto(productEntity);
	}

	@Override
	public ProductDTO updateProduct(Product product, int productId) throws ProductNotFoundException {
		logger.info("updateProduct() service is initiated");
		Product productEntity;
		Product productExist = productRepo.findById(productId).orElse(null);
		if(productExist == null)
		{
			throw new ProductNotFoundException("Product Not Available");
		}
		else
		{
			productExist.setName(product.getName());
			productExist.setPrice(product.getPrice());
			productExist.setDescription(product.getDescription());
			
			productEntity = productRepo.save(productExist);
		}
		logger.info("updateProduct() service has executed");
		return ProductUtils.convertToProductDto(productEntity);
	}

	@Override
	public ProductDTO deleteProduct(int productId) throws ProductNotFoundException {
		logger.info("deleteProduct() service is initiated");
		Product productExist = productRepo.findById(productId).orElseThrow(() ->  new ProductNotFoundException("Product ID is Not Available"));
			productRepo.delete(productExist);
			logger.info("deleteProduct() service has executed");
		return ProductUtils.convertToProductDto(productExist);
	}

	@Override
	public ProductDTO showProductById(int productId) throws ProductNotFoundException {
		logger.info("showProductById() service is initiated");
		Product productExist = productRepo.findById(productId).orElseThrow(() -> new ProductNotFoundException("No Product Available with given ID"));
		logger.info("showProductById() service has executed");
		return ProductUtils.convertToProductDto(productExist);
	}

	@Override
	public List<ProductDTO> showAllProducts() throws ProductNotFoundException {
		logger.info("showAllProducts() service is initiated");
		List<Product> productsList = productRepo.findAll();
		if(productsList.size() == 0)
		{
			throw new ProductNotFoundException("No Products Available");
		}
		else
		{
			logger.info("showAllProducts() service has executed");
			return ProductUtils.convertToProductDtoList(productsList);
		}
	}

	@Override
	public List<ProductDTO> showProductsByAvailability() throws ProductNotFoundException {
		logger.info("showProductsByAvailability() service is initiated");
		List<Product> availableList = productRepo.showProductsByAvailability();
		if(availableList == null)
		{
			throw new ProductNotFoundException("No Products Available");
		}
		else
		{
			logger.info("showProductsByAvailability() service has executed");
			return ProductUtils.convertToProductDtoList(availableList);
		}
	}
}
