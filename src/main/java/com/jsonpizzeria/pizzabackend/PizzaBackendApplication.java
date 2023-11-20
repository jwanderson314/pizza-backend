package com.jsonpizzeria.pizzabackend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan("com.jsonpizzeria.pizzabackend.model")
public class PizzaBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(PizzaBackendApplication.class, args);
	}

}
