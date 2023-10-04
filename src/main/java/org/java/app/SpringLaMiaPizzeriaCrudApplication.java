package org.java.app;

import java.util.List;

import org.java.app.db.pojo.Pizza;
import org.java.app.db.service.PizzaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringLaMiaPizzeriaCrudApplication implements CommandLineRunner {

	@Autowired
	private PizzaService pizzaService;
	
	public static void main(String[] args) {
		SpringApplication.run(SpringLaMiaPizzeriaCrudApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Pizza pizza1 = new Pizza("Margherita", "Best pizza in the world", "https://images.pexels.com/photos/6605214/pexels-photo-6605214.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1", 795);
		
		Pizza pizza2 = new Pizza("Tonno e cipolla", "Second best pizza in the world", "https://images.pexels.com/photos/1049626/pexels-photo-1049626.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1", 900);
		
		pizzaService.savePizza(pizza1);
		pizzaService.savePizza(pizza2);
		
		List<Pizza> pizzas = pizzaService.findAll();
		
		for(Pizza pizza : pizzas) {
			System.out.println(pizza);
		}
	}
}
