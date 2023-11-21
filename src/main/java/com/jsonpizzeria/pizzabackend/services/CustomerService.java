package com.jsonpizzeria.pizzabackend.services;

import com.jsonpizzeria.pizzabackend.dto.CustomerDto;

public interface CustomerService {
    CustomerDto createCustomer (CustomerDto customerDto);
    CustomerDto updateCustomer(Long phone_number,CustomerDto updatedCustomerDto);
}
