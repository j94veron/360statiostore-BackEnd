package com.ar.ecommerce.dao.api;

import org.springframework.data.repository.CrudRepository;

import com.ar.ecommerce.model.Product;

public interface ProductDaoAPI extends CrudRepository<Product, Long> {

}
