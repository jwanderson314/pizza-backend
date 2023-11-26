package com.jsonpizzeria.pizzabackend.services;

import com.jsonpizzeria.pizzabackend.dto.EmployeeDto;
import com.jsonpizzeria.pizzabackend.model.Employee;

import java.util.List;

public interface EmployeeService {

    EmployeeDto createEmployee(EmployeeDto employeeDto);

    Employee updateEmployee(Long employee_id, EmployeeDto updatedEmployeeDto);

    void deleteEmployee(Long employee_id);

    List<EmployeeDto> getAllEmployees();



}
