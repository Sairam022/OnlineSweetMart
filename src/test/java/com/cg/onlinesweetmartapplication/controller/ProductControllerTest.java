package com.cg.onlinesweetmartapplication.controller;

import static org.junit.jupiter.api.Assertions.*;

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
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.cg.onlinesweetmartapplication.entities.Product;
import com.cg.onlinesweetmartapplication.service.iProductService;
import com.cg.onlinesweetmartapplication.utils.ProductUtils;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@RunWith(SpringRunner.class)
@WebMvcTest(value = ProductController.class )
public class ProductControllerTest {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(ProductControllerTest.class);

	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private iProductService productService;
	
	@BeforeAll
	public static void init() {
		LOGGER.info("ProductController Testing Initiated");
	}
	
	@Test
	public void testNewProduct() throws Exception
	{
		LOGGER.info("Testing testNewProduct()");
		String URI = "/api/osm/addProduct";
		Product product = new Product();
		product.setProductId(1);
		product.setName("Kala Jamoon");
		product.setPrice(25.0);
		product.setAvailable(true);
		product.setDescription("Member of Gulab Jamoon family");
		String jsonInput = this.convertToJson(product);
		
		Mockito.when(productService.addProduct(Mockito.any(Product.class))).thenReturn(ProductUtils.convertToProductDto(product));
		MvcResult mvcResult = this.mockMvc.perform(MockMvcRequestBuilders.post(URI).accept(MediaType.APPLICATION_JSON).content(jsonInput).contentType(MediaType.APPLICATION_JSON)).andReturn();
		MockHttpServletResponse mockHttpServletResponse = mvcResult.getResponse();
		String jsonOutput = mockHttpServletResponse.getContentAsString();
		assertEquals(jsonInput, jsonOutput);
		assertEquals(HttpStatus.ACCEPTED.value(), mockHttpServletResponse.getStatus());
	}
	
	@Test
	public void testGetProductById() throws Exception
	{
		LOGGER.info("Testing testGetProductById()");
		String URI = "/api/osm/viewProduct/{id}";
		Product product = new Product();
		product.setProductId(3);
		product.setName("Gulab Jamoon");
		product.setPrice(20.0);
		product.setAvailable(true);
		product.setDescription("Gulab Jamoon family");
		String jsonInput = this.convertToJson(product);
		
		Mockito.when(productService.showProductById(Mockito.anyInt())).thenReturn(ProductUtils.convertToProductDto(product));
		MvcResult mvcResult = this.mockMvc.perform(MockMvcRequestBuilders.get(URI, 3).accept(MediaType.APPLICATION_JSON)).andReturn();
		MockHttpServletResponse mockHttpServletResponse = mvcResult.getResponse();
		String jsonOutput = mockHttpServletResponse.getContentAsString();
		
		assertEquals(jsonInput, jsonOutput);
	}
	
	@Test
	public void testGetAllProducts() throws Exception
	{
		LOGGER.info("Testing testGetAllProducts()");
		String URI = "/api/osm/viewAllProducts";
		Product productOne = new Product();
		productOne.setProductId(5);
		productOne.setName("Rasamalai");
		productOne.setAvailable(true);
		productOne.setPrice(65.0);
		
		Product productTwo = new Product();
		productTwo.setProductId(6);
		productTwo.setName("Boondi");
		productTwo.setAvailable(false);
		productTwo.setPrice(20.0);
		
		List<Product> productsList = new ArrayList<>();
		productsList.add(productOne);
		productsList.add(productTwo);
		
		String jsonInput = this.convertToJson(productsList);
		Mockito.when(productService.showAllProducts()).thenReturn(ProductUtils.convertToProductDtoList(productsList));
		MvcResult mvcResult = this.mockMvc.perform(MockMvcRequestBuilders.get(URI).accept(MediaType.APPLICATION_JSON)).andReturn();
		MockHttpServletResponse mockHttpServletResponse =mvcResult.getResponse();
		String jsonOutput = mockHttpServletResponse.getContentAsString();
		assertEquals(jsonInput, jsonOutput);
	}
	
	@Test
	public void testGetProductsByAvailability() throws Exception
	{
		LOGGER.info("Testing testGetProductsByAvailability()");
		String URI = "/api/osm/viewProductsByAvailability";
		Product productOne = new Product();
		productOne.setProductId(5);
		productOne.setName("Rasamalai");
		productOne.setAvailable(true);
		productOne.setPrice(65.0);
		productOne.setDescription("Sweet");
		
		Product productTwo = new Product();
		productTwo.setProductId(6);
		productTwo.setName("Boondi");
		productTwo.setAvailable(false);
		productTwo.setPrice(20.0);
		productTwo.setDescription("Small ball pieces");
		
		List<Product> productsList = new ArrayList<>();
		productsList.add(productOne);
		productsList.add(productTwo);
		String jsonInput  = this.convertToJson(productsList);
		
		Mockito.when(productService.showProductsByAvailability()).thenReturn(ProductUtils.convertToProductDtoList(productsList));
		MvcResult mvcResult = this.mockMvc.perform(MockMvcRequestBuilders.get(URI).accept(MediaType.APPLICATION_JSON)).andReturn();
		MockHttpServletResponse mockHttpServletResponse = mvcResult.getResponse();
		String jsonOutput = mockHttpServletResponse.getContentAsString();
		assertNotEquals(jsonOutput, convertToJson(productTwo));
	}
	
	@Test
	public void testDeleteProduct() throws Exception
	{
		LOGGER.info("Testing testDeleteProduct()");
		String URI = "/api/osm/deleteProduct/{id}";
		Product product = new Product();
		product.setProductId(3);
		product.setName("Carrot halwa");
		product.setAvailable(true);
		product.setPrice(40.0);
		
		Mockito.when(productService.deleteProduct(Mockito.anyInt())).thenReturn(ProductUtils.convertToProductDto(product));
		MvcResult mvcResult = this.mockMvc.perform(MockMvcRequestBuilders.delete(URI, 3).accept(MediaType.APPLICATION_JSON)).andReturn();
		MockHttpServletResponse mockHttpServletResponse = mvcResult.getResponse();
		assertEquals(HttpStatus.ACCEPTED.value(), mockHttpServletResponse.getStatus());
	}
	
	/*@Test
	public void testUpdateProduct() throws Exception
	{
		LOGGER.info("Testing testUpdateProduct()");
		String URI = "/api/osm/updateProduct";
		Product product = new Product();
		product.setProductId(5);
		product.setName("LAddu");
		product.setAvailable(true);
		product.setPrice(10.0);
		String jsonInput = this.convertToJson(product);
		
		Mockito.when(productService.updateProduct(Mockito.any())).thenReturn(ProductUtils.convertToProductDto(product));
		MvcResult mvcResult = this.mockMvc.perform(MockMvcRequestBuilders.put(URI, "\"false\"").accept(MediaType.APPLICATION_JSON).content(jsonInput).contentType(MediaType.APPLICATION_JSON)).andReturn();
		MockHttpServletResponse mockHttpServletResponse = mvcResult.getResponse();
		String jsonOutput = mockHttpServletResponse.getContentAsString();
		assertNotSame(jsonInput.substring(0, 2), jsonOutput.substring(0, 2));
	}*/
	

	@AfterAll
	public static void end() {
		LOGGER.info("ProductContoller Testing Terminated");
	}
	
	private String convertToJson(Object Product) throws JsonProcessingException
	{
		ObjectMapper objectMapper = new ObjectMapper();
		return objectMapper.writeValueAsString(Product);
	}

}
