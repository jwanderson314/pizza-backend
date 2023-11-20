package com.jsonpizzeria.pizzabackend.repository;

import com.jsonpizzeria.pizzabackend.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer,Long> {
}
