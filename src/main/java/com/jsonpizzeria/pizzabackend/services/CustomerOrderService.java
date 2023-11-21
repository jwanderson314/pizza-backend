package com.jsonpizzeria.pizzabackend.services;

import com.jsonpizzeria.pizzabackend.dto.CustomerOrderDto;

public interface CustomerOrderService {

    CustomerOrderDto createOrder(CustomerOrderDto customerOrderDto);
}
