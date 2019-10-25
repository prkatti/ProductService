package com.mpk.products.controller.model;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class CreateProductRequestModel {

	@NotNull(message = "Product name can not be null")
	@Size(min= 5, message="Product name must be at least 5 characters")
	private String name;
	
	@NotNull(message = "Description can not be null")
	@Size(min= 5, message="Description must be at least 5 characters")
	private String description;
	
	@NotNull(message = "Category name can not be null")
	@Size(min= 5, message="Category must be at least 5 characters")
	private String category;
	
	//@NotNull(message = "Price  can not be null")
	//@Size(min= 2, max=4, message="Price name must be greater than 0 and less than 1000")
	private Long price;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public Long getPrice() {
		return price;
	}

	public void setPrice(Long price) {
		this.price = price;
	}

}
