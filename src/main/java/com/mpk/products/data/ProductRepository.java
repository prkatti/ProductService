package com.mpk.products.data;

import org.springframework.data.repository.CrudRepository;


public interface ProductRepository extends CrudRepository<ProductEntity, Long>{
	
	public ProductEntity findByProductId(String productId);

}
