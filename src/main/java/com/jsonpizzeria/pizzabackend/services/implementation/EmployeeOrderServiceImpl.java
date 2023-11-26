package com.jsonpizzeria.pizzabackend.services.implementation;

import com.jsonpizzeria.pizzabackend.dto.EmployeeDto;
import com.jsonpizzeria.pizzabackend.exception.ResourceNotFoundException;
import com.jsonpizzeria.pizzabackend.mapper.EmployeeMapper;
import com.jsonpizzeria.pizzabackend.model.Customer;
import com.jsonpizzeria.pizzabackend.model.Employee;
import com.jsonpizzeria.pizzabackend.repository.EmployeeRepository;
import com.jsonpizzeria.pizzabackend.services.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class EmployeeOrderServiceImpl implements EmployeeService {
    private EmployeeRepository employeeRepository;
    @Override
    public EmployeeDto createEmployee(EmployeeDto employeeDto) {
        Employee employee = EmployeeMapper.mapToEmployee((employeeDto));
        Employee savedEmployee =  employeeRepository.save(employee);
        return EmployeeMapper.mapToEmployeeDto(savedEmployee);
    }

    @Override
    public Employee updateEmployee(Long employee_id, EmployeeDto updatedEmployeeDto) {
        Employee employee = employeeRepository.findById(employee_id).orElseThrow(
                () -> new ResourceNotFoundException("Employee with id " + employee_id + " not foudn")
        );
        if (employee != null){
            if(updatedEmployeeDto.getUsername() != null){
                employee.setUsername(updatedEmployeeDto.getUsername());
            }
            return employeeRepository.save(employee);
        }
        return null;
    }

    @Override
    public void deleteEmployee(Long employee_id) {
        Employee employee = employeeRepository.findById(employee_id).orElseThrow(
                () -> new ResourceNotFoundException("Employee with id " + employee_id + " not foudn")
        );
        employeeRepository.deleteById(employee_id);
    }

    @Override
    public List<EmployeeDto> getAllEmployees() {
        List<Employee> employees = employeeRepository.findAll();
        return employees.stream().map((employee) -> EmployeeMapper.mapToEmployeeDto(employee)).collect(Collectors.toList());
    }

    @Override
    public EmployeeDto getEmployeeById(Long employee_id) {
        Employee employee = employeeRepository.findById(employee_id).orElseThrow(
                () -> new ResourceNotFoundException("Employee not found")
        );
        return EmployeeMapper.mapToEmployeeDto(employee);
    }
}
