package com.cg.onlinesweetmartapplication.utils;

import java.util.ArrayList;
import java.util.List;

import com.cg.onlinesweetmartapplication.entities.Product;
import com.cg.onlinesweetmartapplication.model.ProductDTO;

public class ProductUtils {
	
	private ProductUtils()
	{
		
	}
	
	public static ProductDTO convertToProductDto(Product product)
	{
		ProductDTO dto = new ProductDTO();
		dto.setProductId(product.getProductId());
		dto.setName(product.getName());
		dto.setPrice(product.getPrice());
		dto.setDescription(product.getDescription());
		dto.setAvailable(product.getAvailable());
		return dto;
	}
	
	public static List<ProductDTO> convertToProductDtoList(List<Product> product)
	{
		List<ProductDTO> dtoList = new ArrayList<>();
		for(Product productlist : product)
			dtoList.add(convertToProductDto(productlist));
		return dtoList;
	}
	
	public static Product convertToProduct(ProductDTO productDTO)
	{
		Product product = new Product();
		product.setProductId(productDTO.getProductId());
		product.setName(productDTO.getName());
		product.setPrice(productDTO.getPrice());
		product.setDescription(productDTO.getDescription());
		product.setAvailable(productDTO.getAvailable());
		return product;
	}

}
