package com.ar.ecommerce.service.api;

import com.ar.ecommerce.model.Customer;

public interface UserService {

		Customer findByUserName(String username);
}
