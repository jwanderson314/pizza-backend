package com.jsonpizzeria.pizzabackend.mapper;

import com.jsonpizzeria.pizzabackend.dto.CustomerDto;
import com.jsonpizzeria.pizzabackend.model.Customer;

public class CustomerMapper {

    public static CustomerDto mapToCustomerDto(Customer customer){

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

    public static Customer mapToCustomer(CustomerDto customerDto){
        return new Customer(
                customerDto.getPhone_number(),
                customerDto.getZipcode(),
                customerDto.getCity(),
                customerDto.getState(),
                customerDto.getStreet_address(),
                customerDto.getOrders()
        );
    }
}
