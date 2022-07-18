package com.ar.ecommerce.dao.api;

import org.springframework.data.repository.CrudRepository;

import com.ar.ecommerce.model.Persona;

public interface PersonaDaoAPI extends CrudRepository<Persona, Long> {

}
