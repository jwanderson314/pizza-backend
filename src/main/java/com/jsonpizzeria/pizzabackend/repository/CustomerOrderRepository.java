package com.jsonpizzeria.pizzabackend.repository;

import com.jsonpizzeria.pizzabackend.model.CustomerOrder;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerOrderRepository extends JpaRepository<CustomerOrder,Long> {
}
