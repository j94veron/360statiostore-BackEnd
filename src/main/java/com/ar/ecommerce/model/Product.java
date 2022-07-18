package com.ar.ecommerce.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="products")
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column
	private String sku;
	
	@Column
	@NotBlank
	private String name;
	
	@Column
	@NotNull
	private Long price;
	
	@Column
	private String made;
	
	@Column
	@NotBlank
	private String descriptions;
	
	@Column
	@NotBlank
	private String category;
	
	@Column
	@NotBlank
	private String trademarks;
	
	@Column
	private String create_date;

	@Column
	@NotNull
	private Long stocks;
	
	@Column
	private String image; 
	
	@Column
	private String status;

	public Long getId() {
		return id;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getSku() {
		return sku;
	}

	public void setSku(String sku) {
		this.sku = sku;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getPrice() {
		return price;
	}

	public void setPrice(Long price) {
		this.price = price;
	}

	public String getMade() {
		return made;
	}

	public void setMade(String made) {
		this.made = made;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getCreate_date() {
		return create_date;
	}

	public void setCreate_date(String create_date) {
		this.create_date = create_date;
	}

	public String getDescriptions() {
		return descriptions;
	}

	public void setDescriptions(String descriptions) {
		this.descriptions = descriptions;
	}

	public Long getStocks() {
		return stocks;
	}

	public void setStocks(Long stocks) {
		this.stocks = stocks;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getTrademarks() {
		return trademarks;
	}

	public void setTrademarks(String trademarks) {
		this.trademarks = trademarks;
	}
	
}

