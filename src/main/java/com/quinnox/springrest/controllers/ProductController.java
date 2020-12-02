package com.quinnox.springrest.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.quinnox.springrest.dao.ProductDAO;
import com.quinnox.springrest.dto.ProductDTO;
import com.quinnox.springrest.dto.ResponseData;
import com.quinnox.springrest.entity.Product;

@RestController
public class ProductController {
	
	@Autowired
	ProductDAO dao;
	
	@PostMapping("/product")
	public String addProduct(@RequestBody ProductDTO product) {
		System.out.println(product);
		dao.addProduct(product);
		return "product added";
	}
	
	@GetMapping("/products")
	public ResponseData findAllProducts() {
		ResponseData response = new ResponseData();
		response.setMsg("Product Recived Successfully");
		response.setData(dao.getAllProducts());
		return response;
	}
	
	@PutMapping("/product")
	public ResponseData updateProduct(@RequestBody ProductDTO product) {
		dao.updateProduct(product);
		ResponseData response = new ResponseData();
		response.setMsg("Product Updated Successfully");
		return response;
	}
	
	@DeleteMapping("/product/{productId}")
	public ResponseData deleteProduct(@PathVariable int productId) {
		dao.deleteProduct(productId);
		ResponseData response = new ResponseData();
		response.setMsg("Product Deleted Successfully");
		return response;
	}

}
