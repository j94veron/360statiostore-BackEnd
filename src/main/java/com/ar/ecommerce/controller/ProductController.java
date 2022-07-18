package com.ar.ecommerce.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ar.ecommerce.model.Product;
import com.ar.ecommerce.service.api.ProductServiceAPI;



@Controller
@RequestMapping("/productos")
public class ProductController {

	@Autowired
	private ProductServiceAPI productServiceAPI;

	@RequestMapping("/")
	public String index(Model model) {
		model.addAttribute("list", productServiceAPI.getAll());
		return "index";
	}

	@GetMapping("/create")
	public String create(Model model) {
		model.addAttribute("product", new Product());
		return "save";
	}

	@GetMapping("/save/{id}")
	public String showSave(@PathVariable("id") Long id, Model model) {
		if (id != null && id != 0) {
			model.addAttribute("product", productServiceAPI.get(id));
		} else {
			model.addAttribute("product", new Product());
		}
		return "save";
	}

	@PostMapping("/save")
	public String save(Product product, Model model) {
		productServiceAPI.save(product);
		return "redirect:/product/";
	}

	@GetMapping("/delete/{id}")
	public String delete(@PathVariable Long id, Model model) {
		productServiceAPI.delete(id);
		return "redirect:/product/";
	}

}