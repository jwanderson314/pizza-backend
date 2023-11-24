package com.jsonpizzeria.pizzabackend.services.implementation;

import com.jsonpizzeria.pizzabackend.dto.CustomerOrderDto;
import com.jsonpizzeria.pizzabackend.exception.ResourceNotFoundException;
import com.jsonpizzeria.pizzabackend.mapper.CustomerOrderMapper;
import com.jsonpizzeria.pizzabackend.model.Customer;
import com.jsonpizzeria.pizzabackend.model.CustomerOrder;
import com.jsonpizzeria.pizzabackend.model.Employee;
import com.jsonpizzeria.pizzabackend.repository.CustomerOrderRepository;
import com.jsonpizzeria.pizzabackend.repository.CustomerRepository;
import com.jsonpizzeria.pizzabackend.repository.EmployeeRepository;
import com.jsonpizzeria.pizzabackend.services.CustomerOrderService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
@AllArgsConstructor
public class CustomerOrderServiceImpl implements CustomerOrderService {
    @Autowired
    private CustomerOrderRepository customerOrderRepository;

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public CustomerOrder createOrder(CustomerOrderDto orderDto) {
        Customer customer = customerRepository.findById(orderDto.getCustomer().getPhone_number()).orElseThrow(
                () -> new ResourceNotFoundException("Customer not found")
        );
        Employee employee = employeeRepository.findById(orderDto.getEmployee().getEmployee_id()).orElseThrow(
                () -> new ResourceNotFoundException("Employee not found")
        );
        CustomerOrder customerOrder = new CustomerOrder();
        customerOrder.setOrder_id(orderDto.getOrder_id());
        customerOrder.setCustomer(customer);
        customerOrder.setDate(orderDto.getDate());
        customerOrder.setEmployee(employee);

        return customerOrderRepository.save(customerOrder);
    }
}
