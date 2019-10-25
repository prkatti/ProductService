package com.mpk.products.services;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mpk.products.data.ProductEntity;
import com.mpk.products.data.ProductRepository;
import com.mpk.products.shared.Product;
import com.mpk.products.shared.ProductDto;

@Service
public class ProductServiceImpl implements ProductService {

	private ProductRepository productRepository;
	private Logger logger = LoggerFactory.getLogger(ProductServiceImpl.class);

	@Autowired
	public ProductServiceImpl(ProductRepository productRepository) {

		this.productRepository = productRepository;
	}

	@Override
	public ProductDto createProduct(ProductDto productDetail) {

		productDetail.setProductId(UUID.randomUUID().toString());

		ModelMapper mapper = new ModelMapper();
		mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		ProductEntity entity = mapper.map(productDetail, ProductEntity.class);
		productRepository.save(entity);
		return productDetail;

	}

	@Override
	public List<ProductDto> findAll() {
		// TODO Auto-generated method stub

		Iterable<ProductEntity> productEntities = productRepository.findAll();
		List<ProductEntity> products = new ArrayList<>();

		productEntities.forEach(product -> products.add(product));

		ModelMapper mapper = new ModelMapper();
		mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);

		List map = mapper.map(products, List.class);
		List<ProductDto> productList = (List<ProductDto>) map;
		return productList;
	}

	@Override
	public ProductDto getProductById(String productId) {
		// TODO Auto-generated method stub

		ProductEntity entity = productRepository.findByProductId(productId);

		ModelMapper mapper = new ModelMapper();
		mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);

		ProductDto returnValue = null;
		if (entity != null) {
			returnValue = mapper.map(entity, ProductDto.class);
		}
		return returnValue;
	}

	@Override
	public List<Product> getAllProductsOverTheWire() {
		logger.info("Sent to remote client .......");
		list.add(new Product(UUID.randomUUID().toString(), "Apple TV", "Brand New Apple TV", 400.46, "Apple Inc", ""));
		list.add(new Product(UUID.randomUUID().toString(), "Micromax  Phone", "Latest MicroMax Next Gen", 250.46, "Micromax Digital Company", ""));
		list.add(new Product(UUID.randomUUID().toString(), "EcoGreen Refrigerator", "Next Fridge ", 100.46, "Eco Green Co",""));

		return list;
	}

	private List<Product> list = new ArrayList<>();

}
