package com.jsonpizzeria.pizzabackend.services.implementation;

import com.jsonpizzeria.pizzabackend.dto.CustomerOrderDto;
import com.jsonpizzeria.pizzabackend.mapper.CustomerOrderMapper;
import com.jsonpizzeria.pizzabackend.model.CustomerOrder;
import com.jsonpizzeria.pizzabackend.repository.CustomerOrderRepository;
import com.jsonpizzeria.pizzabackend.services.CustomerOrderService;

public class CustomerOrderServiceImpl implements CustomerOrderService {
    private CustomerOrderRepository customerOrderRepository;
    @Override
    public CustomerOrderDto createOrder(CustomerOrderDto customerOrderDto) {
        CustomerOrder customerOrder = CustomerOrderMapper.mapToCustomerOrder(customerOrderDto);
        CustomerOrder savedOrder = customerOrderRepository.save(customerOrder);
        return CustomerOrderMapper.mapToCustomerOrderDto(savedOrder) ;
    }
}
