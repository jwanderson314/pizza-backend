package com.jsonpizzeria.pizzabackend.services;

import com.jsonpizzeria.pizzabackend.dto.EmployeeDto;
import com.jsonpizzeria.pizzabackend.model.Employee;

public interface EmployeeService {

    EmployeeDto createEmployee(EmployeeDto employeeDto);

    Employee updateEmployee(Long employee_id, EmployeeDto updatedEmployeeDto);

    void deleteEmployee(Long employee_id);



}
