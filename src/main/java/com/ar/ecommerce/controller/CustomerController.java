package com.ar.ecommerce.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ar.ecommerce.model.Customer;
import com.ar.ecommerce.service.api.CustomerServiceAPI;



@Controller
@RequestMapping("/customer")
public class CustomerController {

	@Autowired
	private CustomerServiceAPI custormerServiceAPI;

	@RequestMapping("/")
	public String index(Model model) {
		model.addAttribute("list", custormerServiceAPI.getAll());
		return "index";
	}

	@GetMapping("/create")
	public String create(Model model) {
		model.addAttribute("customer", new Customer());
		return "save";
	}

	@GetMapping("/save/{id}")
	public String showSave(@PathVariable("id") Long id, Model model) {
		if (id != null && id != 0) {
			model.addAttribute("customer", custormerServiceAPI.get(id));
		} else {
			model.addAttribute("customer", new Customer());
		}
		return "save";
	}

	@PostMapping("/save")
	public String save(Customer customer, Model model) {
		custormerServiceAPI.save(customer);
		return "redirect:/customer/";
	}

	@GetMapping("/delete/{id}")
	public String delete(@PathVariable Long id, Model model) {
		custormerServiceAPI.delete(id);

		return "redirect:/customer/";
	}
	
	

}