package com.product.service;

import java.util.List;

import com.product.entity.Product;


public interface ProductService {
	List<Product> getAllProducts();

	Product getProductById(Integer productId) throws Exception;

	Product updateProduct(Product product) throws Exception;

	Product addProduct(Product product);

	String deleteProductById(Integer productId) throws Exception;

}
