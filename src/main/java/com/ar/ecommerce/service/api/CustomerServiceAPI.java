package com.ar.ecommerce.service.api;

import java.util.Optional;

import com.ar.ecommerce.commons.GenericServiceAPI;
import com.ar.ecommerce.model.Customer;

public interface CustomerServiceAPI extends GenericServiceAPI<Customer, Long>  {
	
	Optional<Customer> findByUserName(String username);

	
}