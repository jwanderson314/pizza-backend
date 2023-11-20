package com.jsonpizzeria.pizzabackend.services.impl;

import com.jsonpizzeria.pizzabackend.dto.CustomerDto;
import com.jsonpizzeria.pizzabackend.mapper.CustomerMapper;
import com.jsonpizzeria.pizzabackend.model.Customer;
import com.jsonpizzeria.pizzabackend.repository.CustomerRepository;
import com.jsonpizzeria.pizzabackend.services.CustomerService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CustomerServiceImpl implements CustomerService {
    private CustomerRepository customerRepository;
    @Override
    public CustomerDto createCustomer(CustomerDto customerDto) {

        Customer customer = CustomerMapper.mapToCustomer((customerDto));
        Customer savedCustomer =  customerRepository.save(customer);
        return CustomerMapper.mapToCustomerDto(savedCustomer);
    }
}
