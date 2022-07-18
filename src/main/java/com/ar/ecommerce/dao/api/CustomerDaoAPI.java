package com.ar.ecommerce.dao.api;

import org.springframework.data.repository.CrudRepository;

import com.ar.ecommerce.model.Customer;

public interface CustomerDaoAPI extends CrudRepository<Customer, Long> {

}