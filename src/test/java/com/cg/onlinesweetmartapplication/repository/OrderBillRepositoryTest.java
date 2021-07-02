package com.cg.onlinesweetmartapplication.repository;
import static org.junit.Assert.assertEquals;

import java.time.LocalDate;
import java.util.ArrayList;
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

import com.cg.onlinesweetmartapplication.entities.OrderBill;
import com.cg.onlinesweetmartapplication.entities.SweetOrder;

@RunWith(SpringRunner.class)
@DataJpaTest
public class OrderBillRepositoryTest {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(OrderBillRepositoryTest.class);
	
	@Autowired
	private OrderBillRepository orderbillRepo;
	
	@Autowired
	private TestEntityManager testEntityManager;
	
	@BeforeAll
	public static void init() {
		LOGGER.info("OrderBillRepository Testing Initiated");
	}
	
	@Test
	public void getOrderBillByIdTest() {
		LOGGER.info("Testing getOrderBillByIdTest()");
		OrderBill orderbill = new OrderBill();
		orderbill.setTotal(90.0);;
		orderbill.setCreatedDate(LocalDate.now());
		OrderBill saveInDb = testEntityManager.persist(orderbill);
		System.out.println(orderbill.getOrderBillId()); 
		OrderBill getFromDb = orderbillRepo.findById(saveInDb.getOrderBillId()).get();
		assertEquals(getFromDb,saveInDb);
		}
	
	
    @Test
	public void addOrderBillTest(){
		LOGGER.info("Testing addOrderBillTest()");
		OrderBill orderbill = new OrderBill();
//		orderbill.setOrderBillId(105);
		orderbill.setTotal(400);
		OrderBill saveInDb = testEntityManager.persist(orderbill);
		OrderBill getFromDb = orderbillRepo.findById(saveInDb.getOrderBillId()).get();
		System.out.println("OrderBillID and GrandTotal is: "+saveInDb.getOrderBillId()+" "+saveInDb.getTotal());
		assertEquals(getFromDb , saveInDb);
	}	
    
    @Test
    public void updateOrderBillTest()
	{
		LOGGER.info("Testing updateOrderBillTest()");
		OrderBill orderbill = new OrderBill();
		orderbill.setCreatedDate(LocalDate.now());
		orderbill.setTotal(90.0);
		
		OrderBill saveToDb = testEntityManager.persist(orderbill);
		
		OrderBill getFromDb = orderbillRepo.findById(saveToDb.getOrderBillId()).get();
		
	}
    
    @Test
	public void deleteOrderBillTest()
	{
		LOGGER.info("Testing deleteOrderBillTest()");
		OrderBill orderbillOne = new OrderBill();
		orderbillOne.setCreatedDate(LocalDate.now());
		orderbillOne.setTotal(485);
		
		OrderBill orderbillTwo = new OrderBill();
		orderbillTwo.setCreatedDate(LocalDate.now());
		orderbillTwo.setTotal(1230);
		
		
		testEntityManager.persist(orderbillOne);
		testEntityManager.persist(orderbillTwo);
		
		testEntityManager.remove(orderbillOne);
		
		List<OrderBill> orderbills = orderbillRepo.findAll();
		assertEquals(1, orderbills.size());
	}


	@AfterAll
	public static void end() {
		LOGGER.info("OrderBillRepository Testing Terminated");
	}
}
