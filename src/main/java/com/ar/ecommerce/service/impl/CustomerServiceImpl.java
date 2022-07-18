package com.ar.ecommerce.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import com.ar.ecommerce.commons.GenericServiceImpl;
import com.ar.ecommerce.dao.api.CustomerDaoAPI;
import com.ar.ecommerce.model.Customer;
import com.ar.ecommerce.service.api.CustomerServiceAPI;

@Service
public class CustomerServiceImpl extends GenericServiceImpl<Customer, Long> implements CustomerServiceAPI {

	@Autowired
	private CustomerDaoAPI customerDaoAPI;
	
	@Override
	public CrudRepository<Customer, Long> getDao() {
		return customerDaoAPI;
	}

}