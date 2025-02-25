package com.product.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import com.product.entity.Product;
import com.product.exceptions.ProductNotFoundException;
import com.product.repository.ProductRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class ProductServiceImpl implements ProductService {
	@Autowired
	ProductRepository productRepository;

	@Override
	public List<Product> getAllProducts() {
		List<Product> products = productRepository.findAll();
		if (ObjectUtils.isEmpty(products)) {
			return new ArrayList<>();
		}
		return products;
	}

	@Override
	public Product getProductById(Integer productId) throws Exception {
		Optional<Product> optionalProduct = productRepository.findById(productId);
		if (!optionalProduct.isPresent()) {
			throw new ProductNotFoundException(String.format("No Such Product Found for productId %s", productId));
		}
		return optionalProduct.get();
	}

	@Override
	public Product updateProduct(Product product) throws Exception {
		Product productResponse = getProductById(product.getProductId());
		if (product.getProductName() != null) {
			productResponse.setProductName(product.getProductName());
		}
		if (product.getPricePerItem() != null) {
			productResponse.setPricePerItem(product.getPricePerItem());
		}
		if (product.getProductCode() != null) {
			productResponse.setProductCode(product.getProductCode());
		}
		if (product.getStockQuantity() != null) {
			productResponse.setStockQuantity(product.getStockQuantity());
		}
		Product response = productRepository.save(product);
		return response;
	}

	@Override
	public Product addProduct(Product productRequest) {
		Product product = productRepository.save(productRequest);
		if (ObjectUtils.isEmpty(product)) {
			return null;
		}
		return product;
	}

	@Override
	public String deleteProductById(Integer productId) throws Exception {
		Product productResponse = getProductById(productId);
		log.info("product details to be delete {}", productResponse);
		// productRepository.delete(productResponse);
		productRepository.deleteById(productId);

		return "product deleted successfully";
	}
}
