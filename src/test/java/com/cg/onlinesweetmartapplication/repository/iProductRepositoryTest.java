package com.cg.onlinesweetmartapplication.repository;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import com.cg.onlinesweetmartapplication.entities.Product;



@RunWith(SpringRunner.class)
@DataJpaTest
class iProductRepositoryTest {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(iProductRepositoryTest.class);

	@Autowired
	private iProductRepository productRepo;
	
	@Autowired
	private TestEntityManager testEntityManager;
	
	@BeforeAll
	public static void init() {
		LOGGER.info("iProdcutRepository Testing Initiated");
	}
	
	@Test
	public void getProductByIdTest()
	{
		LOGGER.info("Testing getProductByIdTest()");
		Product product = new Product();
		product.setName("Kaju Burfi");
		product.setPrice(25.0);
		product.setAvailable(true);
		product.setDescription("So Sweet");
		
		Product saveInDb = testEntityManager.persist(product);
		Product getFromDb = productRepo.findById(saveInDb.getProductId()).get();
		assertEquals(getFromDb, saveInDb);
	}
	
	@Test
	public void addProductTest()
	{
		LOGGER.info("Testing addProductTest()");
		Product product = new Product();
		product.setName("Halwa");
		product.setPrice(90.0);
		product.setAvailable(true);
		product.setDescription("Soft sweet");
		
		Product saveToDb = testEntityManager.persist(product);
		Product getFromDb = productRepo.findById(saveToDb.getProductId()).get();
		System.out.println("Name and id is: "+saveToDb.getName()+ " " + saveToDb.getProductId()+ " "+ saveToDb.getPrice());
		assertEquals(getFromDb, saveToDb);
	}
	
	@Test
	public void getAllProductsTest()
	{
		LOGGER.info("Testing getAllProductsTest()");
		Product productOne = new Product();
		productOne.setName("Rasamalai");
		productOne.setAvailable(true);
		productOne.setPrice(65.0);
		productOne.setDescription("Water sweet");
		
		Product productTwo = new Product();
		productTwo.setName("Boondi");
		productTwo.setAvailable(false);
		productTwo.setPrice(25.0);
		productTwo.setDescription("Small balls type sweet");
		
		testEntityManager.persist(productOne);
		testEntityManager.persist(productTwo);
		
		List<Product> productsList = productRepo.findAll();
		assertEquals(2, productsList.size());
	}
	
	@Test
	public void deleteProductTest()
	{
		LOGGER.info("Testing deleteProductTest()");
		Product productOne = new Product();
		productOne.setName("Malai Puri");
		productOne.setAvailable(true);
		productOne.setPrice(50.0);
		
		Product productTwo = new Product();
		productTwo.setName("Kova Pieces");
		productTwo.setAvailable(false);
		productTwo.setPrice(36.0);
		
		testEntityManager.persist(productOne);
		testEntityManager.persist(productTwo);
		
		testEntityManager.remove(productOne);
		
		List<Product> products = productRepo.findAll();
		assertEquals(1, products.size());
	}
	
	@Test
	public void updateProductTest()
	{
		LOGGER.info("Testing updateProductTest()");
		Product product = new Product();
		product.setName("Dry Fruits Laddu");
		product.setAvailable(true);
		product.setPrice(45.0);
		
		Product saveToDb = testEntityManager.persist(product);
		
		Product getFromDb = productRepo.findById(saveToDb.getProductId()).get();
		System.out.println("UPdate test"+ getFromDb.getName()+ " "+ getFromDb.getAvailable());
		getFromDb.setAvailable(false);
		
		System.out.println("Afetr update"+getFromDb.getName()+" "+ getFromDb.getAvailable());
		assertEquals(getFromDb.getAvailable(), false);
		
	}
	
	@AfterAll
	public static void end() {
		LOGGER.info("iProductRepository Testing Terminated");
	}

}
