package com.jsonpizzeria.pizzabackend.controller;


import com.jsonpizzeria.pizzabackend.dto.EmployeeDto;
import com.jsonpizzeria.pizzabackend.model.Employee;
import com.jsonpizzeria.pizzabackend.services.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
@RequestMapping("/api/employees")
public class EmployeeController {
    private EmployeeService employeeService;

    @PostMapping
    public ResponseEntity<EmployeeDto> createEmployee(@RequestBody EmployeeDto employeeDto){
        EmployeeDto savedEmployee = employeeService.createEmployee(employeeDto);
        return new ResponseEntity<>(savedEmployee, HttpStatus.CREATED);
    }
    @PutMapping("{employee_id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable("employee_id") Long employee_id,@RequestBody EmployeeDto updatedEmployee){
        Employee employee = employeeService.updateEmployee(employee_id,updatedEmployee);
        return ResponseEntity.ok(employee);
    }

    @DeleteMapping("{employee_id}")
    public ResponseEntity<String> deleteEmployee(@PathVariable("employee_id") Long employee_id){
        employeeService.deleteEmployee(employee_id);
        return ResponseEntity.ok("Employee deleted successfully!");
    }
}
