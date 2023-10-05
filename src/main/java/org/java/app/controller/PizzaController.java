package org.java.app.controller;

import java.util.List;

import org.java.app.db.pojo.Pizza;
import org.java.app.db.service.PizzaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class PizzaController {
	
	@Autowired
	private PizzaService pizzaService;
	
	@GetMapping
	public String index(@RequestParam(required = false) String name, Model model) {
		List<Pizza> pizzas = name == null
								? pizzaService.findAll()
								: pizzaService.filterByNameOrDescription(name, name);
		
		model.addAttribute("pizzas", pizzas);
		
		return "index";
	}
	
	@GetMapping("/{id}")
	public String show(@PathVariable int id, Model model) {
		Pizza pizza = pizzaService.findById(id);
		
		model.addAttribute("pizza", pizza);
		
		return "show";
	}
}
