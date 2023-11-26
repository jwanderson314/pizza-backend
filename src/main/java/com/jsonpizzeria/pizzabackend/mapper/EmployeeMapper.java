package com.jsonpizzeria.pizzabackend.mapper;

import com.jsonpizzeria.pizzabackend.dto.EmployeeDto;
import com.jsonpizzeria.pizzabackend.model.Employee;

public class EmployeeMapper {
    public static EmployeeDto mapToEmployeeDto(Employee employee){
        if (employee == null){
            return null;
        }
        EmployeeDto employeeDto = new EmployeeDto();
        employeeDto.setEmployee_id(employee.getEmployee_id());
        employeeDto.setUsername(employee.getUsername());

        return employeeDto;
    }
    public static Employee mapToEmployee(EmployeeDto employeeDto){
        if(employeeDto == null){
            return null;
        }
        return new Employee(
                employeeDto.getEmployee_id(),
                employeeDto.getUsername(),
                employeeDto.getCustomerOrder(),
                employeeDto.getOrderDetail()
        );
    }
}
