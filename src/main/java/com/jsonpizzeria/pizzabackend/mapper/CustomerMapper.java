package com.jsonpizzeria.pizzabackend.mapper;

import com.jsonpizzeria.pizzabackend.dto.CustomerDto;
import com.jsonpizzeria.pizzabackend.model.Customer;

public class CustomerMapper {

    public static CustomerDto mapToCustomerDto(Customer customer){

        return new CustomerDto(
                customer.getPhone_number(),
                customer.getZipcode(),
                customer.getCity(),
                customer.getState(),
                customer.getState()
        );
    }

    public static Customer mapToCustomer(CustomerDto customerDto){
        return new Customer(
                customerDto.getPhone_number(),
                customerDto.getZipcode(),
                customerDto.getCity(),
                customerDto.getState(),
                customerDto.getStreet_address()
        );
    }
}
