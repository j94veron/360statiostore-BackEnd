package com.ar.ecommerce.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ar.ecommerce.model.Orders;
import com.ar.ecommerce.service.api.OrdersServiceAPI;


@Controller
@RequestMapping("/orders")
public class OrdersController {

	@Autowired
	private OrdersServiceAPI ordersServiceAPI;

	@RequestMapping("/")
	public String index(Model model) {
		model.addAttribute("list", ordersServiceAPI.getAll());
		return "index";
	}

	@GetMapping("/create")
	public String create(Model model) {
		model.addAttribute("orders", new Orders());
		return "save";
	}

	@GetMapping("/save/{id}")
	public String showSave(@PathVariable("id") Long id, Model model) {
		if (id != null && id != 0) {
			model.addAttribute("orders", ordersServiceAPI.get(id));
		} else {
			model.addAttribute("orders", new Orders());
		}
		return "save";
	}

	@PostMapping("/save")
	public String save(Orders orders, Model model) {
		ordersServiceAPI.save(orders);
		return "redirect:/orders/";
	}

	@GetMapping("/delete/{id}")
	public String delete(@PathVariable Long id, Model model) {
		ordersServiceAPI.delete(id);

		return "redirect:/orders/";
	}

}
