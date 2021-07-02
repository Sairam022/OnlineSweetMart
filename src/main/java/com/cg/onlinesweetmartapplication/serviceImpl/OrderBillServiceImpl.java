package com.cg.onlinesweetmartapplication.serviceImpl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cg.onlinesweetmartapplication.exceptions.OrderBillNotFoundException;
import com.cg.onlinesweetmartapplication.entities.OrderBill;
import com.cg.onlinesweetmartapplication.model.OrderBillDTO;
import com.cg.onlinesweetmartapplication.repository.OrderBillRepository;
import com.cg.onlinesweetmartapplication.service.OrderBillService;
import com.cg.onlinesweetmartapplication.utils.OrderBillUtils;

@Service
public class OrderBillServiceImpl implements OrderBillService {
	private static final Logger logger = LoggerFactory.getLogger(OrderBillServiceImpl.class);
	
	@Autowired
	private OrderBillRepository orderbillRepo;
	
	@Override
	public OrderBillDTO addOrderBill(OrderBill orderbill) {
		logger.info("addOrderBill() service is initiated");
		OrderBill orderbillEntity ;
		if(orderbill == null)
		{
			orderbillEntity = null;
		}
		else
		{
			logger.info("addOrderBill() service has executed");
			orderbillEntity = orderbillRepo.save(orderbill);
		}
		return OrderBillUtils.convertToOrderBillDto(orderbillEntity);
	}
	
	@Override
	public OrderBillDTO updateOrderBill(OrderBill orderbill) throws OrderBillNotFoundException{
		logger.info("updateOrderBill() service is initiated");
		OrderBill orderbillEntity ;
		OrderBill orderbillExist = orderbillRepo.findById(orderbill.getOrderBillId()).get();
		orderbillEntity = orderbillRepo.save(orderbill);
		logger.info("updateOrderBill() service has executed");		
		return OrderBillUtils.convertToOrderBillDto(orderbillEntity);
	}
	
	@Override
	public OrderBillDTO cancelOrderBill(int OrderBillId) {
		logger.info("cancelOrderBill() service is initiated");
		OrderBill orderbillExist = orderbillRepo.findById(OrderBillId).get();
		logger.info("cancelOrderBill() service has executed");
		return OrderBillUtils.convertToOrderBillDto(orderbillExist);
	}
	
	@Override
	public List<OrderBillDTO> showAllOrderBills(){
		logger.info("showAllOrderBills() service is initiated");
		List<OrderBill>orderbillList = orderbillRepo.findAll();
		logger.info("showAllOrderBills() service has executed");
		return OrderBillUtils.convertToOrderBillDtoList(orderbillList);
	}
	
	@Override
	public OrderBillDTO showAllOrderBillsById(int OrderBillId) {
		logger.info("showAllOrderBillsById() service is initiated");
		OrderBill orderbillList = orderbillRepo.findById(OrderBillId).get();
		logger.info("showAllOrderBillsById() service has executed");
		return OrderBillUtils.convertToOrderBillDto(orderbillList);
	}
}