package com.mpk.products.controller;

import java.util.List;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mpk.products.controller.model.CreateProductRequestModel;
import com.mpk.products.controller.model.CreateProductResponseModel;
import com.mpk.products.services.ProductService;
import com.mpk.products.shared.Product;
import com.mpk.products.shared.ProductDto;

@RestController
@RequestMapping("/products")
public class ProductsController {

	@Autowired
	private ProductService productService;
	@Autowired
	private Environment env;
	
	private Logger logger = LoggerFactory.getLogger(ProductsController.class);
	

	@GetMapping("/status")
	public String status() {

		return "Product service is up and running ...";
	}

	@PostMapping(consumes = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })

	public ResponseEntity<CreateProductResponseModel> createProduct(
			@RequestBody @Valid CreateProductRequestModel productDetail) {

		ModelMapper mapper = new ModelMapper();
		mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);

		ProductDto productDto = mapper.map(productDetail, ProductDto.class);

		ProductDto returnDto = productService.createProduct(productDto);

		CreateProductResponseModel returnValue = mapper.map(returnDto, CreateProductResponseModel.class);

		return ResponseEntity.status(HttpStatus.CREATED).body(returnValue);
	}

	@GetMapping(produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
	@RequestMapping("/getAll")
	public List<CreateProductResponseModel> getAllProducts() {

		List<CreateProductResponseModel> allProducts = null;
		List<ProductDto> productsDto = productService.findAll();
		
		ModelMapper mapper = new ModelMapper();
		mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		
		List map = mapper.map(productsDto, List.class );
		allProducts =(List<CreateProductResponseModel>) map;

		return allProducts;

	}

	@GetMapping(produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
	@RequestMapping("/{productId}")
	public ResponseEntity<CreateProductResponseModel> findProductById(@PathVariable String productId) {
		CreateProductResponseModel returnValue = null;
		ProductDto dto = productService.getProductById(productId);

		if (dto != null) {
			ModelMapper mapper = new ModelMapper();
			mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);

			returnValue = mapper.map(dto, CreateProductResponseModel.class);
			return ResponseEntity.status(HttpStatus.OK).body(returnValue);
		}

		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);

	}
	

	@GetMapping
	public List<Product> getAllProductsOverTheWire(){
		
		logger.info("Request coming on port :"+env.getProperty("local.server.port"));
		logger.info("Getting peoducts from products service .. over the wire.");
		List<Product> products = productService.getAllProductsOverTheWire();
		
		return products;
	}

}
