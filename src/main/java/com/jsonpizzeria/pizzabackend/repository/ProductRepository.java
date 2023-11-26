package com.jsonpizzeria.pizzabackend.repository;

import com.jsonpizzeria.pizzabackend.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product,Long> {
}
