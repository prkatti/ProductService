package com.mpk.products.data;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "products")
public class ProductEntity implements Serializable {

	private static final long serialVersionUID = -7623031294065009600L;

	@Id
	@GeneratedValue
	private long id;

	@Column(nullable=false, unique=true, length =50)
	private String name;

	@Column(nullable=false,  length =50)
	private String category;
	
	@Column(nullable=false,  length =50)
	private String description;

	@Column(nullable=false, unique=true , length =50)
	private String productId;

	@Column(length=10)
	private long price;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public long getPrice() {
		return price;
	}

	public void setPrice(long price) {
		this.price = price;
	}
	
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
