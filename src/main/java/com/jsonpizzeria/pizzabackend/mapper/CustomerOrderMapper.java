package com.jsonpizzeria.pizzabackend.mapper;

import com.jsonpizzeria.pizzabackend.dto.CustomerDto;
import com.jsonpizzeria.pizzabackend.dto.CustomerOrderDto;
import com.jsonpizzeria.pizzabackend.dto.EmployeeDto;
import com.jsonpizzeria.pizzabackend.model.Customer;
import com.jsonpizzeria.pizzabackend.model.CustomerOrder;
import com.jsonpizzeria.pizzabackend.model.Employee;

public class CustomerOrderMapper {

    public static CustomerOrderDto mapToCustomerOrderDto(CustomerOrder customerOrder){
        if (customerOrder == null){
            return null;
        }
        CustomerDto customerDto = CustomerMapper.mapToCustomerDto(customerOrder.getCustomer());
        EmployeeDto employeeDto = EmployeeMapper.mapToEmployeeDto(customerOrder.getEmployee());
        return new CustomerOrderDto(
                customerOrder.getOrder_id(),
                customerDto,
                employeeDto,
                customerOrder.getOrderDetail()
        );
    }

    public static CustomerOrder mapToCustomerOrder(CustomerOrderDto customerOrderDto){
        if(customerOrderDto == null){
            return null;
        }
        return new CustomerOrder(
                customerOrderDto.getOrder_id(),
                mapToCustomer(customerOrderDto.getCustomer()),
                mapToEmployee(customerOrderDto.getEmployee()),
                customerOrderDto.getOrderDetail()
        );
    }

    private static CustomerDto mapToCustomerDto(Customer customer){
        if(customer == null){
            return null;
        }
        CustomerDto customerDto = new CustomerDto();
        customerDto.setPhone_number(customer.getPhone_number());
        customerDto.setZipcode(customer.getZipcode());
        customerDto.setCity(customer.getCity());
        customerDto.setState(customer.getState());
        customerDto.setStreet_address(customer.getStreet_address());

        return customerDto;
    }
    private static EmployeeDto mapToEmployeeDto(Employee employee){
        if(employee == null){
            return null;
        }
        EmployeeDto employeeDto = new EmployeeDto();
        employeeDto.setEmployee_id(employeeDto.getEmployee_id());
        employeeDto.setUsername(employee.getUsername());

        return employeeDto;
    }

    private static Customer mapToCustomer(CustomerDto customerDto){
        if(customerDto == null){
            return null;
        }
        Customer customer = new Customer();
        customer.setPhone_number(customerDto.getPhone_number());
        customer.setZipcode(customerDto.getZipcode());
        customer.setCity(customerDto.getCity());
        customer.setState(customerDto.getState());
        customer.setStreet_address(customerDto.getStreet_address());

        return customer;
    }
    private static Employee mapToEmployee(EmployeeDto employeeDto){
        if(employeeDto == null){
            return null;
        }
        Employee employee = new Employee();
        employee.setEmployee_id(employeeDto.getEmployee_id());
        employee.setUsername(employeeDto.getUsername());
        employee.setCustomerOrder(employeeDto.getCustomerOrder());
        employee.setOrderDetail(employeeDto.getOrderDetail());

        return employee;
    }
}
