package com.jsonpizzeria.pizzabackend.services.implementation;

import com.jsonpizzeria.pizzabackend.dto.CustomerDto;
import com.jsonpizzeria.pizzabackend.exception.ResourceNotFoundException;
import com.jsonpizzeria.pizzabackend.mapper.CustomerMapper;
import com.jsonpizzeria.pizzabackend.model.Customer;
import com.jsonpizzeria.pizzabackend.repository.CustomerRepository;
import com.jsonpizzeria.pizzabackend.services.CustomerService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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
    public Customer updateCustomer(Long phone_number, CustomerDto updatedCustomerDto) {
        Customer customer = customerRepository.findById(phone_number).orElseThrow(
                () -> new ResourceNotFoundException("Employee does not exists with given id: " + phone_number)
        );
        if (customer != null){
            if(updatedCustomerDto.getZipcode() != null){
                customer.setZipcode(updatedCustomerDto.getZipcode());
            }
            if(updatedCustomerDto.getCity() != null){
                customer.setCity(updatedCustomerDto.getCity());
            }
            if(updatedCustomerDto.getState() != null){
                customer.setState(updatedCustomerDto.getState());
            }
            if(updatedCustomerDto.getStreet_address() != null){
                customer.setStreet_address(updatedCustomerDto.getStreet_address());
            }
            return customerRepository.save(customer);
        }
        return null;
    }

    @Override
    public List<CustomerDto> getAllCustomers() {
        List<Customer> customers = customerRepository.findAll();
        return customers.stream().map((customer) -> CustomerMapper.mapToCustomerDto(customer)).collect(Collectors.toList());
    }

}
