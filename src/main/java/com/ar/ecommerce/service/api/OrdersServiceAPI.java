package com.ar.ecommerce.service.api;

import java.util.List;

import com.ar.ecommerce.commons.GenericServiceAPI;
import com.ar.ecommerce.model.Orders;

public interface OrdersServiceAPI extends GenericServiceAPI<com.ar.ecommerce.model.Orders, Long> {

	List<Orders> findByCustomerId(String customerId);

}
