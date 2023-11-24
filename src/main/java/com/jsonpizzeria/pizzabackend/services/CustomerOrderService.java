package com.jsonpizzeria.pizzabackend.services;

import com.jsonpizzeria.pizzabackend.dto.CustomerOrderDto;
import com.jsonpizzeria.pizzabackend.model.CustomerOrder;

import java.util.Date;

public interface CustomerOrderService {

    CustomerOrder createOrder(CustomerOrderDto orderDto);
}
