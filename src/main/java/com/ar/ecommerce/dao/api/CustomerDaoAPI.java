package com.ar.ecommerce.dao.api;

import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.ar.ecommerce.model.Customer;

public interface CustomerDaoAPI extends CrudRepository<Customer, Long> {
	
	@Query("select u from Customer u where LOWER(u.username) = LOWER(:username)")
	Optional<Customer> findByUsername(@Param("username") String username);

}