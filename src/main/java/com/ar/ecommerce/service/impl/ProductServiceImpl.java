package com.ar.ecommerce.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import com.ar.ecommerce.commons.GenericServiceImpl;
import com.ar.ecommerce.dao.api.ProductDaoAPI;
import com.ar.ecommerce.model.Product;
import com.ar.ecommerce.service.api.ProductServiceAPI;

@Service
public class ProductServiceImpl extends GenericServiceImpl<Product, Long> implements ProductServiceAPI {

	@Autowired
	private ProductDaoAPI productDaoAPI;
	
	@Override
	public CrudRepository<Product, Long> getDao() {
		return productDaoAPI;
	}

}