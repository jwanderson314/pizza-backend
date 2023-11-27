package com.jsonpizzeria.pizzabackend.services;

import com.jsonpizzeria.pizzabackend.dto.CustomerOrderDto;
import com.jsonpizzeria.pizzabackend.model.CustomerOrder;

import java.util.Date;
import java.util.List;

public interface CustomerOrderService {

    CustomerOrder createOrder(CustomerOrderDto orderDto);

    List<CustomerOrderDto> getAllCustomerOrders();
}
