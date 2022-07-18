package com.ar.ecommerce.dao.api;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.ar.ecommerce.model.Orders;

public interface OrdersDaoAPI extends CrudRepository<Orders, Long> {
	
	public List<Orders> findByCustomerId(String customerId);

}