package com.cg.onlinesweetmartapplication.controller;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

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

import com.cg.onlinesweetmartapplication.entities.OrderBill;
import com.cg.onlinesweetmartapplication.service.OrderBillService;
import com.cg.onlinesweetmartapplication.utils.OrderBillUtils;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@RunWith(SpringRunner.class)
@WebMvcTest(value = OrderBillController.class )

public class OrderBillControllerTest {
	private static final Logger LOGGER = LoggerFactory.getLogger(OrderBillControllerTest.class);
	
	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private OrderBillService orderbillService;
	
	@BeforeAll
	public static void init() {
		LOGGER.info("OrderBillController Testing Initiated");
	}
	
	@Test
	public void testNewOrderBill() throws Exception
	{
		LOGGER.info("Testing testNewOrderBill()");
		String URI = "/api/osm/addOrderBill";
		OrderBill orderbill = new OrderBill();
		orderbill.setOrderBillId(71);
		orderbill.setTotal(750);
		String jsonInput = this.convertToJson(orderbill);
		
		Mockito.when(orderbillService.addOrderBill(Mockito.any(OrderBill.class))).thenReturn(OrderBillUtils.convertToOrderBillDto(orderbill));
		MvcResult mvcResult = this.mockMvc.perform(MockMvcRequestBuilders.post(URI).accept(MediaType.APPLICATION_JSON).content(jsonInput).contentType(MediaType.APPLICATION_JSON)).andReturn();
		MockHttpServletResponse mockHttpServletResponse = mvcResult.getResponse();
		String jsonOutput = mockHttpServletResponse.getContentAsString();
		System.out.println("out"+jsonOutput);
		System.out.println("inp"+jsonInput);
		assertNotEquals(jsonInput, jsonOutput);
		assertNotEquals(HttpStatus.OK.value(), mockHttpServletResponse.getStatus());
	}
	
	@Test
	public void testGetOrderBillById() throws Exception
	{
		LOGGER.info("Testing testGetOrderBillById()");
		String URI = "/api/osm/viewOrderBill/{id}";
		OrderBill orderbill = new OrderBill();
		orderbill.setOrderBillId(423);
		orderbill.setTotal(840);
		
		String jsonInput = this.convertToJson(orderbill);
		
		Mockito.when(orderbillService.showAllOrderBillsById(Mockito.anyInt())).thenReturn(OrderBillUtils.convertToOrderBillDto(orderbill));
		MvcResult mvcResult = this.mockMvc.perform(MockMvcRequestBuilders.get(URI, 3).accept(MediaType.APPLICATION_JSON)).andReturn();
		MockHttpServletResponse mockHttpServletResponse = mvcResult.getResponse();
		String jsonOutput = mockHttpServletResponse.getContentAsString();
		
		assertEquals(jsonInput, jsonOutput);
	}
	
	@Test
	public void testGetAllOrderBills() throws Exception {
		LOGGER.info("Testing testGetAllOrderBills()");
		String URI = "/api/osm/viewAllOrderBills";
		OrderBill orderbillOne = new OrderBill();
		orderbillOne.setOrderBillId(55);
		orderbillOne.setTotal(710);
		
		
		OrderBill orderbillTwo = new OrderBill();
		orderbillTwo.setOrderBillId(64);
		orderbillTwo.setTotal(835);
		
		List<OrderBill> orderbillsList = new ArrayList<>();
		orderbillsList.add(orderbillOne);
		orderbillsList.add(orderbillTwo);
		
		String jsonInput = this.convertToJson(orderbillsList);
		Mockito.when(orderbillService.showAllOrderBills()).thenReturn(OrderBillUtils.convertToOrderBillDtoList(orderbillsList));
		MvcResult mvcResult = this.mockMvc.perform(MockMvcRequestBuilders.get(URI).accept(MediaType.APPLICATION_JSON)).andReturn();
		MockHttpServletResponse mockHttpServletResponse =mvcResult.getResponse();
		String jsonOutput = mockHttpServletResponse.getContentAsString();
		assertEquals(jsonInput, jsonOutput);
	}
	

	@AfterAll
	public static void end() {
		LOGGER.info("OrderBill Testing Terminated");
	}

	private String convertToJson(Object OrderBill) throws JsonProcessingException
	{
		ObjectMapper objectMapper = new ObjectMapper();
		return objectMapper.writeValueAsString(OrderBill);
	}
		

}
