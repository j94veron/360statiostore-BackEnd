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

import com.ar.ecommerce.model.Product;
import com.ar.ecommerce.service.api.ProductServiceAPI;



@RestController
@RequestMapping(value = "/product")
@CrossOrigin("*")
public class ProductRestController {

	@Autowired
	private ProductServiceAPI productServiceAPI;

	@GetMapping
	public List<Product> getAll() {
		return productServiceAPI.getAll();
	}
	
	@GetMapping(value = "/{id}")
	public Product find(@PathVariable Long id) {
		return productServiceAPI.get(id);
	}

	@PostMapping
	public ResponseEntity<Product> save(@RequestBody @Valid Product product) {
		Product obj = productServiceAPI.save(product);
		return new ResponseEntity<Product>(obj, HttpStatus.OK);
	}
	
	@PutMapping
	public ResponseEntity<Product> update(@RequestBody @Valid Product product) {
		Product obj = productServiceAPI.save(product);
		return new ResponseEntity<Product>(obj, HttpStatus.OK);
	}

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Product> delete(@PathVariable Long id) {
		Product product = productServiceAPI.get(id);
		if (product != null) {
			productServiceAPI.delete(id);
		} else {
			return new ResponseEntity<Product>(HttpStatus.NO_CONTENT);
		}
		
		return new ResponseEntity<Product>(product, HttpStatus.OK);
	}
}
