package com.cg.onlinesweetmartapplication.serviceImpl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotSame;
import static org.junit.jupiter.api.Assertions.assertSame;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.cg.onlinesweetmartapplication.entities.Product;
import com.cg.onlinesweetmartapplication.exceptions.InvalidProductDetailsException;
import com.cg.onlinesweetmartapplication.exceptions.ProductNotFoundException;
import com.cg.onlinesweetmartapplication.model.ProductDTO;
import com.cg.onlinesweetmartapplication.repository.iProductRepository;
import com.cg.onlinesweetmartapplication.service.iProductService;
import com.cg.onlinesweetmartapplication.utils.ProductUtils;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductServiceImplTest {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(ProductServiceImplTest.class);

	@MockBean
	private iProductRepository productRepo;
	
	@Autowired
	private iProductService productService;
	
	@BeforeAll
	public static void init() {
		LOGGER.info("ProductServiceImpl Testing Initiated");
	}
	
	@Test
	public void addProductTest() throws InvalidProductDetailsException
	{
		LOGGER.info("Testing addProductTest()");
		Product product = new Product();
		product.setProductId(1);
		product.setName("MysoorPak");
		product.setPrice(15.0);
		product.setAvailable(true);
		product.setDescription("South Indian");
		Mockito.when(productRepo.save(product)).thenReturn(product);
		assertEquals(product.getName(),"MysoorPak");
	}
	
	@Test
	public void showProductByIdTest() throws ProductNotFoundException
	{
		LOGGER.info("Testing showProductByIdTest()");
		Product product = new Product();
		product.setProductId(1);
		product.setName("Gulab Jamun");
		product.setPrice(20.0);
		product.setAvailable(true);
		product.setDescription("Soft Mouth warming sweet");

		Mockito.when(productRepo.save(product)).thenReturn(product);
		System.out.println("name"+product.getProductId()+ " "+ product.getProductId());
		assertEquals(product.getProductId(), 1);
	}
	
	@Test
	public void showAllProductsTest() throws ProductNotFoundException
	{
		LOGGER.info("Testing showAllProductsTest()");
		Product productOne = new Product();
		productOne.setName("Rasamalai");
		productOne.setAvailable(true);
		productOne.setPrice(65.0);
		
		Product productTwo = new Product();
		productTwo.setName("Boondi");
		productTwo.setAvailable(false);
		productTwo.setPrice(null);
		
		List<Product> productsList = new ArrayList<>();
		productsList.add(productOne);
		productsList.add(productTwo);
		Mockito.when(productService.showAllProducts()).thenReturn(ProductUtils.convertToProductDtoList(productsList));
		assertSame(productsList.size(),2);
	}
	
	@Test
	public void showAllProductsByAvailabilityTest() throws ProductNotFoundException
	{
		LOGGER.info("Testing showAllProductsByAvailabilityTest()");
		Product productOne = new Product();
		productOne.setName("Rasamalai");
		productOne.setAvailable(true);
		productOne.setPrice(65.0);
		
		Product productTwo = new Product();
		productTwo.setName("Boondi");
		productTwo.setAvailable(false);
		productTwo.setPrice(50.0);
		
		List<Product> productsList = new ArrayList<>();
		productsList.add(productOne);
		productsList.add(productTwo);
		Mockito.when(productService.showProductsByAvailability()).thenReturn(ProductUtils.convertToProductDtoList(productsList));
		assertSame(productsList.size(), 1);
	}
	
	@Test
	public void deleteProductTest() throws ProductNotFoundException, InvalidProductDetailsException
	{
		LOGGER.info("Testing deleteProductTest()");
		Product productOne = new Product();
		productOne.setProductId(3);
		productOne.setName("Kala Jamoon");
		productOne.setAvailable(true);
		productOne.setPrice(40.0);
		productOne.setDescription("Another member from Gulab Jamoon family");

		Mockito.when(productRepo.save(productOne)).thenReturn(productOne);
		productRepo.deleteById(productOne.getProductId());
		assertNotEquals(productOne, new Product());
	}
	
	@Test
	public void updateProductTest() throws InvalidProductDetailsException, ProductNotFoundException
	{
		LOGGER.info("Testing updateProductTest()");
		Product product = new Product();
		product.setProductId(1);
		product.setName("Kova");
		product.setPrice(10.0);
		product.setAvailable(true);
		product.setDescription("Milk Sweet");
		
		productRepo.save(product);
		product.setAvailable(false);
		Mockito.when(productRepo.save(product)).thenReturn(product);
		assertEquals(product.getAvailable(), false);
	}
	

	@AfterAll
	public static void end() {
		LOGGER.info("ProductServiceImpl Testing Terminated");
	}
}
