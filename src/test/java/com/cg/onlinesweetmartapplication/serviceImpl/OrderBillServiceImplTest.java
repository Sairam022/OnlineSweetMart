package com.cg.onlinesweetmartapplication.serviceImpl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNotSame;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;

import java.time.LocalDate;
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

import com.cg.onlinesweetmartapplication.entities.OrderBill;
import com.cg.onlinesweetmartapplication.entities.SweetOrder;
import com.cg.onlinesweetmartapplication.exceptions.InvalidOrderBillDetailsException;
import com.cg.onlinesweetmartapplication.exceptions.OrderBillNotFoundException;
import com.cg.onlinesweetmartapplication.model.OrderBillDTO;
import com.cg.onlinesweetmartapplication.repository.OrderBillRepository;
import com.cg.onlinesweetmartapplication.service.OrderBillService;
import com.cg.onlinesweetmartapplication.utils.OrderBillUtils;

@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderBillServiceImplTest {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(OrderBillServiceImplTest.class);
	
	@MockBean
	private OrderBillRepository orderbillRepo;
	
	@Autowired
	private OrderBillService orderbillService;
	
	@BeforeAll
	public static void init() {
		LOGGER.info("OrderBillServiceImpl Testing Initiated");
	}
	
	@Test
	public void addOrderBillTest() throws InvalidOrderBillDetailsException {
		LOGGER.info("Testing addOrderBillTest()");
		OrderBill orderbill = new OrderBill(1, LocalDate.now(), 0, new ArrayList<SweetOrder>());
		Mockito.when(orderbillRepo.save(orderbill)).thenReturn(orderbill);
		assertEquals(orderbill.getTotal(), 0);
		
	}

	
	@Test
	public void showOrderBillByIdTest() throws OrderBillNotFoundException , InvalidOrderBillDetailsException {
		LOGGER.info("Testing showOrderBillByIdTest()");
		OrderBill orderbill = new OrderBill();
		orderbill.setOrderBillId(20);
		orderbill.setTotal(460);
		Mockito.when(orderbillRepo.save(orderbill)).thenReturn(orderbill);
		assertEquals(orderbill.getOrderBillId(),20);
	}
	
	@Test
	public void  showAllOrderBillsTest() throws OrderBillNotFoundException
	{
		LOGGER.info("Testing showAllOrderBillsTest()");
		OrderBill orderbillOne = new OrderBill();
		orderbillOne.setOrderBillId(404);
		orderbillOne.setTotal(985);
		
		
		OrderBill orderbillTwo = new OrderBill();
		orderbillTwo.setOrderBillId(410);
		orderbillTwo.setTotal(600);
		
		OrderBill orderbillThree = new OrderBill();
		orderbillThree.setOrderBillId(499);
		orderbillThree.setTotal(710);
		
		List<OrderBill> orderbillsList = new ArrayList<>();
		orderbillsList.add(orderbillOne);
		orderbillsList.add(orderbillTwo);
		orderbillsList.add(orderbillThree);
		Mockito.when(orderbillRepo.findAll()).thenReturn(orderbillsList);
		List<OrderBillDTO> dto =OrderBillUtils.convertToOrderBillDtoList(orderbillsList);
		assertSame(orderbillService.showAllOrderBills().size(),3);
	}
	

	@AfterAll
	public static void end() {
		LOGGER.info("OrderBillServiceImpl Testing Terminated");
	}
}	
