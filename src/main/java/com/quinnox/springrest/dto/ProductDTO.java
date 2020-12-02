package com.quinnox.springrest.dto;

import lombok.Data;

@Data
public class ProductDTO {
	
	private int productId;
	
	private String productName;
	
	private String productCost;
	
	private String productImg;
	
	private String productCategory;

}
