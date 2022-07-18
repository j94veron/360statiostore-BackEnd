package com.ar.ecommerce.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ar.ecommerce.model.Orders;
import com.ar.ecommerce.service.api.OrdersServiceAPI;

@RestController
@RequestMapping(value = "/orders")
@CrossOrigin("*")
public class OrdersRestController {

	@Autowired
	private OrdersServiceAPI ordersServiceAPI;

	@GetMapping
	public ResponseEntity<List<Orders>> getAll() {
		return new ResponseEntity<>(ordersServiceAPI.getAll(), HttpStatus.OK);
	}
	
	@GetMapping (value = "/findByUsername/{customerId}")
	public ResponseEntity<List<Orders>> findByCustomerId(@PathVariable String customerId) {
		return new ResponseEntity<>(ordersServiceAPI.findByCustomerId(customerId), HttpStatus.OK);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Orders> find(@PathVariable Long id) {
		Orders obj = ordersServiceAPI.get(id);
		return new ResponseEntity<>(obj, HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity<Orders> save(@RequestBody @Valid Orders orders) {
		Orders obj = ordersServiceAPI.save(orders);
		return new ResponseEntity<>(obj, HttpStatus.OK);
	}
	
	@PutMapping
	public ResponseEntity<Orders> update(@RequestBody @Valid Orders orders){
		Orders obj= ordersServiceAPI.save(orders);
		return new ResponseEntity<>(obj, HttpStatus.OK);
	}

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Orders> delete(@PathVariable Long id) {
		Orders orders = ordersServiceAPI.get(id);
		if (orders != null) {
			ordersServiceAPI.delete(id);
		} else {
			return new ResponseEntity<Orders>(HttpStatus.NO_CONTENT);
		}
		
		return new ResponseEntity<Orders>(orders, HttpStatus.OK);
	}

}
