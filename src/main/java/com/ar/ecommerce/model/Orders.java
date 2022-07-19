package com.ar.ecommerce.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonFormat;


@Entity
@Table(name="orders")
public class Orders {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "customer_id")
	@NotBlank
	private String customerId;
	
	@Column
	@NotNull
	private Long product_id;

	@Column
	@NotBlank
	private String name_product;
	
	@Column
	private String made_product;
	
	@Column
	@NotBlank
	private String category_product;
	
	@Column
	@NotBlank
	private String shipping;
	
	@Column
	@NotBlank
	private String address_user;
	
	@Column
	@JsonFormat(pattern = "ddd/MM/yyyy")
	private Date order_date;
	
	@Column
	@NotBlank
	private String order_status;
	
	@Column
	private Long quantity;

	@Column
	@NotNull
	private Long price_product;
	
	@Column
	@NotBlank
	private String active;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCustomerId() {
		return customerId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

	public Long getProduct_id() {
		return product_id;
	}

	public void setProduct_id(Long product_id) {
		this.product_id = product_id;
	}

	public String getName_product() {
		return name_product;
	}

	public void setName_product(String name_product) {
		this.name_product = name_product;
	}

	public String getMade_product() {
		return made_product;
	}

	public void setMade_product(String made_product) {
		this.made_product = made_product;
	}

	public String getCategory_product() {
		return category_product;
	}

	public void setCategory_product(String category_product) {
		this.category_product = category_product;
	}

	public String getShipping() {
		return shipping;
	}

	public void setShipping(String shipping) {
		this.shipping = shipping;
	}

	public String getAddress_user() {
		return address_user;
	}

	public void setAddress_user(String address_user) {
		this.address_user = address_user;
	}

	public Date getOrder_date() {
		return order_date;
	}

	public void setOrder_date(Date order_date) {
		this.order_date = order_date;
	}

	public String getOrder_status() {
		return order_status;
	}

	public void setOrder_status(String order_status) {
		this.order_status = order_status;
	}

	public Long getQuantity() {
		return quantity;
	}

	public void setQuantity(Long quantity) {
		this.quantity = quantity;
	}

	public Long getPrice_product() {
		return price_product;
	}

	public void setPrice_product(Long price_product) {
		this.price_product = price_product;
	}

	public String getActive() {
		return active;
	}

	public void setActive(String active) {
		this.active = active;
	}
	
	
}
