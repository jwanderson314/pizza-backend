package com.jsonpizzeria.pizzabackend.services.implementation;

import com.jsonpizzeria.pizzabackend.dto.CustomerDto;
import com.jsonpizzeria.pizzabackend.exception.ResourceNotFoundException;
import com.jsonpizzeria.pizzabackend.mapper.CustomerMapper;
import com.jsonpizzeria.pizzabackend.model.Customer;
import com.jsonpizzeria.pizzabackend.repository.CustomerRepository;
import com.jsonpizzeria.pizzabackend.services.CustomerService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

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

    @Override
    public CustomerDto updateCustomer(Long phone_number, CustomerDto updatedCustomerDto) {
        Customer customer = customerRepository.findById(phone_number).orElseThrow(
                () -> new ResourceNotFoundException("Employee does not exists with given id: " + phone_number)
        );
        customer.setZipcode(updatedCustomerDto.getZipcode());
        customer.setCity(updatedCustomerDto.getCity());
        customer.setState(updatedCustomerDto.getState());
        customer.setStreet_address(updatedCustomerDto.getStreet_address());
        Customer updatedCustomerObj = customerRepository.save(customer);
        return CustomerMapper.mapToCustomerDto(updatedCustomerObj);
    }

}
