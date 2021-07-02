package com.cg.onlinesweetmartapplication.utils;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.cg.onlinesweetmartapplication.entities.SweetOrder;
import com.cg.onlinesweetmartapplication.model.SweetOrderDTO;
@Component
public class SweetOrderUtils {
	public static List<SweetOrderDTO> convertToSweetOrderDtoList(List<SweetOrder> list){
		List<SweetOrderDTO> dtolist = new ArrayList<SweetOrderDTO>();
		for(SweetOrder sweetOrder : list) 
			dtolist.add(convertToSweetOrderDto(sweetOrder));
		return dtolist;
	}
	
	public static SweetOrderDTO convertToSweetOrderDto(SweetOrder sweetOrder) {
		SweetOrderDTO dto = new SweetOrderDTO();
		dto.setSweetOrderId(sweetOrder.getSweetOrderId());
		dto.setCreatedDate(sweetOrder.getCreatedDate());
		dto.setListItems(sweetOrder.getListItems());
		
		return dto;
	}
	
	
	
	public static List<SweetOrder> convertToSweetOrderList(List<SweetOrderDTO> dtoList){
		List<SweetOrder> list = new ArrayList<SweetOrder>();
		for(SweetOrderDTO sweetOrderDTO : dtoList) 
			list.add(convertToSweetOrder(sweetOrderDTO));
		return list;
	}
	
	
	public static SweetOrder convertToSweetOrder(SweetOrderDTO sweetOrderDto) {
		SweetOrder sweetOrder = new SweetOrder();
		sweetOrder.setSweetOrderId(sweetOrderDto.getSweetOrderId());
		sweetOrder.setCreatedDate(sweetOrderDto.getCreatedDate());
		sweetOrder.setListItems(sweetOrderDto.getListItems());
		
		return sweetOrder;
	}
}
