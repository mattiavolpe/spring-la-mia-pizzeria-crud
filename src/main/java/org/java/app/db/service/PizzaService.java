package org.java.app.db.service;

import java.util.List;

import org.java.app.db.pojo.Pizza;
import org.java.app.db.repo.PizzaRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PizzaService {
	
	@Autowired
	private PizzaRepo pizzaRepo;
	
	public List<Pizza> findAll() {
		return pizzaRepo.findAll();
	}
	
	public void savePizza(Pizza pizza) {
		pizzaRepo.save(pizza);
	}
	
	public Pizza findById(int id) {
		Pizza pizza = pizzaRepo.findById(id).get();
//		System.out.println(pizza);
		return pizza;
	}
}
