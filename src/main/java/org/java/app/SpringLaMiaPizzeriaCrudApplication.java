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
		Pizza pizza1 = new Pizza("Margherita", "Tomato sauce and mozzarella", "https://images.pexels.com/photos/6605214/pexels-photo-6605214.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1", 700);
		
		Pizza pizza2 = new Pizza("Tonno e cipolla", "Natural tuna, red onions and mozzarella", "https://www.galbani.it/sites/default/files/styles/width_1920/public/se_tonno_buona_da_star_bene_980x357.jpg", 900);
		
		Pizza pizza3 = new Pizza("Capricciosa", "Tomato sauce, artichokes, mushrooms, anchovies, black olives and mozzarella", "https://images.pexels.com/photos/1049626/pexels-photo-1049626.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1", 900);
		
		pizzaService.savePizza(pizza1);
		pizzaService.savePizza(pizza2);
		pizzaService.savePizza(pizza3);
		
		List<Pizza> pizzas = pizzaService.findAll();
		
		for(Pizza pizza : pizzas) {
			System.out.println(pizza);
		}
	}
}
