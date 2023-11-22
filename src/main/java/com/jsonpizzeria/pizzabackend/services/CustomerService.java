package com.jsonpizzeria.pizzabackend.services;

import com.jsonpizzeria.pizzabackend.dto.CustomerDto;
import com.jsonpizzeria.pizzabackend.model.Customer;

import java.util.List;

public interface CustomerService {
    CustomerDto createCustomer (CustomerDto customerDto);
    Customer updateCustomer(Long phone_number, CustomerDto updatedCustomerDto);

    List<CustomerDto> getAllCustomers();

}
