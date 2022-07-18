package com.ar.ecommerce.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import com.ar.ecommerce.commons.GenericServiceImpl;
import com.ar.ecommerce.dao.api.PersonaDaoAPI;
import com.ar.ecommerce.model.Persona;
import com.ar.ecommerce.service.api.PersonaServiceAPI;

@Service
public class PersonaServiceImpl extends GenericServiceImpl<Persona, Long> implements PersonaServiceAPI {

	@Autowired
	private PersonaDaoAPI personaDaoAPI;
	
	@Override
	public CrudRepository<Persona, Long> getDao() {
		return personaDaoAPI;
	}

}
