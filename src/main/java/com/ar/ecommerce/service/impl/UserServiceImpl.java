package com.ar.ecommerce.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ar.ecommerce.dao.api.UserDaoAPI;
import com.ar.ecommerce.model.Customer;
import com.ar.ecommerce.service.api.UserService;

@Service
@Transactional
public class UserServiceImpl  implements UserService {
	private static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

	@Autowired
	private UserDaoAPI repository;

	@Override
	@Transactional(readOnly = true)
	public Customer findByUserName(String username) {
		logger.debug("Ingresando al metodo UsuarioServiceImpl.findByUserName");
		String usernameLower = username.toLowerCase();
		Customer user = repository.findByUsername(usernameLower).orElseThrow(() -> new BadCredentialsException("User " + username + " was not found in the database"));
		logger.debug("Saliendo del metodo UsuarioServiceImpl.findByUserName");
		return user;
	}
	
}
