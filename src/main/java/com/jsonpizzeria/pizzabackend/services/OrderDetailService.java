package com.jsonpizzeria.pizzabackend.services;

import com.jsonpizzeria.pizzabackend.dto.OrderDetailDto;
import com.jsonpizzeria.pizzabackend.model.OrderDetail;

public interface OrderDetailService {
    OrderDetail createOrderDetail(OrderDetailDto orderDetailDto);
}
