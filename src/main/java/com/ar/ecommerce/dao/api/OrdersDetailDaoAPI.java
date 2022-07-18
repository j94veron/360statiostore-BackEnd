package com.ar.ecommerce.dao.api;

import org.springframework.data.repository.CrudRepository;

import com.ar.ecommerce.model.Detail;

public interface OrdersDetailDaoAPI extends CrudRepository<Detail, Long> {

}
