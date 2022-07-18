package com.ar.ecommerce.service.api;

import org.springframework.data.repository.CrudRepository;

import com.ar.ecommerce.model.Detail;

public interface DetailServiceAPI extends CrudRepository<Detail, Long> {

}
