package com.quinnox.springrest.dao;

import java.util.List;

import com.quinnox.springrest.dto.ProductDTO;
import com.quinnox.springrest.entity.Product;

public interface ProductDAO {
	
	public boolean addProduct(ProductDTO product);
	
	public List<Product> getAllProducts();
	
	public boolean updateProduct(ProductDTO product);
	
	public boolean deleteProduct(int productId);

}
