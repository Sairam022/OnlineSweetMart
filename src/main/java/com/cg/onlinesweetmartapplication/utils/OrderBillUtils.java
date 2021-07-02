package com.cg.onlinesweetmartapplication.utils;

import java.util.ArrayList;
import java.util.List;

import com.cg.onlinesweetmartapplication.entities.OrderBill;
import com.cg.onlinesweetmartapplication.model.OrderBillDTO;



public class OrderBillUtils {

		
		private OrderBillUtils()
		{
			
		}
		
		public static OrderBillDTO convertToOrderBillDto(OrderBill orderbill)
		{
			OrderBillDTO dto = new OrderBillDTO();
			dto.setCreatedDate(orderbill.getCreatedDate());
			dto.setOrderBillId(orderbill.getOrderBillId());
			dto.setTotal(orderbill.getTotal());
			
			return dto;
		}
		
		public static List<OrderBillDTO> convertToOrderBillDtoList(List<OrderBill> orderbill)
		{
			List<OrderBillDTO> dtoList = new ArrayList<>();
			for(OrderBill orderbilllist : orderbill)
				dtoList.add(convertToOrderBillDto(orderbilllist));
			return dtoList;
		}

	}

