package com.mpk.products.services;

import java.util.List;

import com.mpk.products.shared.Product;
import com.mpk.products.shared.ProductDto;

public interface ProductService {
	
	public ProductDto createProduct(ProductDto productDetail);
	
	public List<ProductDto> findAll();

	public ProductDto getProductById(String productId);
	
	public List<Product> getAllProductsOverTheWire();

}
