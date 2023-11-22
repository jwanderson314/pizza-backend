package com.jsonpizzeria.pizzabackend.repository;

import com.jsonpizzeria.pizzabackend.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee,Long> {
}
