package com.quinnox.springrest.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Repository;

import com.quinnox.springrest.dto.ProductDTO;
import com.quinnox.springrest.entity.Product;

@Repository
public class ProductDAOImpl implements ProductDAO {
	
	@PersistenceContext
	EntityManager manager;

	@Override
	@Transactional
	public boolean addProduct(ProductDTO product) {
		Product product2 = new Product();
		BeanUtils.copyProperties(product, product2);
		manager.persist(product2);
		return true;
	}

	@Override
	public List<Product> getAllProducts() {	
		TypedQuery<Product> query =  manager.createQuery("from Product", Product.class);
		return query.getResultList();
	}

	@Override
	@Transactional
	public boolean updateProduct(ProductDTO product) {
		Product product1 = manager.find(Product.class, product.getProductId());
		BeanUtils.copyProperties(product, product1);
		return true;
	}

	@Override
	@Transactional
	public boolean deleteProduct(int productId) {
		Product product = manager.find(Product.class, productId);
		manager.remove(product);
		return true;
	}

}
