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

import com.ar.ecommerce.model.Customer;
import com.ar.ecommerce.service.api.CustomerServiceAPI;

@RestController
@RequestMapping(value = "/customer")
@CrossOrigin("*")
public class CustomerRestController {

	@Autowired
	private CustomerServiceAPI customerServiceAPI;

	@GetMapping
	public List<Customer> getAll() {
		return customerServiceAPI.getAll();
	}
	
	@GetMapping(value = "/{id}")
	public Customer find(@PathVariable Long id) {
		return customerServiceAPI.get(id);
	}

	@PostMapping
	public ResponseEntity<Customer> save(@RequestBody @Valid Customer customer) {
		Customer obj = customerServiceAPI.save(customer);
		return new ResponseEntity<Customer>(obj, HttpStatus.OK);
	}
	
	@PutMapping
	public ResponseEntity<Customer> update(@RequestBody @Valid Customer customer){
		Customer obj = customerServiceAPI.save(customer);
		return new ResponseEntity<Customer>(obj, HttpStatus.OK);
	}

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Customer> delete(@PathVariable Long id) {
		Customer customer = customerServiceAPI.get(id);
		if (customer != null) {
			customerServiceAPI.delete(id);
		} else {
			return new ResponseEntity<Customer>(HttpStatus.NO_CONTENT);
		}
		
		return new ResponseEntity<Customer>(customer, HttpStatus.OK);
	}

}
