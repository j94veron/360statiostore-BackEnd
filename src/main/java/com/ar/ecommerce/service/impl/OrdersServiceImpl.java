package com.ar.ecommerce.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ar.ecommerce.commons.GenericServiceImpl;
import com.ar.ecommerce.dao.api.OrdersDaoAPI;
import com.ar.ecommerce.dao.api.ProductDaoAPI;
import com.ar.ecommerce.model.Orders;
import com.ar.ecommerce.model.Product;
import com.ar.ecommerce.service.api.OrdersServiceAPI;

@Transactional
@Service
public class OrdersServiceImpl extends GenericServiceImpl<Orders, Long> implements OrdersServiceAPI {

	@Autowired
	private OrdersDaoAPI ordersDaoAPI;
	
	@Autowired
	private ProductDaoAPI productDaoAPI;
	
	@Override
	public CrudRepository<Orders, Long> getDao() {
		return ordersDaoAPI;
	}
	
	@Transactional(readOnly = true)
	@Override
	public List<Orders> findByCustomerId(String customerId) {
		return ordersDaoAPI.findByCustomerId(customerId);
	}
	
	@Override
	public Orders save(Orders orders) {
		Product product = productDaoAPI.findById(orders.getProduct_id()).get();
		product.setStocks(product.getStocks() - orders.getQuantity());
		productDaoAPI.save(product);
		orders.setPrice_product(product.getPrice() * orders.getQuantity());
		ordersDaoAPI.save(orders);
		return ordersDaoAPI.save(orders);
	}
		

}