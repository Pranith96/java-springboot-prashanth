package com.product.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.product.config.DataSourceProperties;
import com.product.entity.Product;
import com.product.service.ProductService;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/product")
@Slf4j
public class ProductController {

	@Autowired
	ProductService productService;

	@Autowired
	DataSourceProperties dataSourceProperties;

	@PostMapping("/add")
	public ResponseEntity<Product> addProduct(@RequestBody Product product) throws Exception {
		log.info("In product add controller");
		Product productResponse = productService.addProduct(product);
		if (productResponse == null) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new Product());
		}
		log.info("In product add controller after service call");
		return ResponseEntity.status(HttpStatus.CREATED).body(productResponse);
	}

	@GetMapping("/get")
	public ResponseEntity<List<Product>> getAllProducts() {
		log.info("In product add controller");
		List<Product> products = productService.getAllProducts();
		log.info("In product add controller after service call");
		return ResponseEntity.status(HttpStatus.OK).body(products);
	}

	// http://localhost:9091/product/get/{productId}
	@GetMapping("/get/{productId}")
	public ResponseEntity<Product> getProductById(@PathVariable(name = "productId") Integer productId)
			throws Exception {
		log.info("In product add controller");
		Product productResponse = productService.getProductById(productId);
		log.info("In product add controller after service call");
		return ResponseEntity.status(HttpStatus.OK).body(productResponse);
	}

	@PutMapping(value = "/update/details", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Product> updateProduct(@RequestBody Product product) throws Exception {
		log.info("In product add controller");
		Product productResponse = productService.updateProduct(product);
		log.info("In product add controller after service call");
		return ResponseEntity.status(HttpStatus.OK).body(productResponse);
	}

	@DeleteMapping("/delete/{productId}")
	public ResponseEntity<String> deleteProductById(@PathVariable(name = "productId") Integer productId)
			throws Exception {
		log.info("In product add controller");
		String productResponse = productService.deleteProductById(productId);
		log.info("In product add controller after service call");
		return ResponseEntity.status(HttpStatus.OK).body(productResponse);
	}
}
