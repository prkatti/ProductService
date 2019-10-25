package com.mpk.products.shared;

import java.io.Serializable;

public class ProductDto implements Serializable {

	 
	private static final long serialVersionUID = -4900754832336722267L;
	
	private String productId;
	private String name;
	private String description;
	private String category;
	private Long price;

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

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
