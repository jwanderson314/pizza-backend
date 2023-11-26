package com.jsonpizzeria.pizzabackend.services;

import com.jsonpizzeria.pizzabackend.dto.OrderDetailDto;
import com.jsonpizzeria.pizzabackend.model.Employee;
import com.jsonpizzeria.pizzabackend.model.OrderDetail;

import java.util.Date;
import java.util.List;

public interface OrderDetailService {
    OrderDetail createOrderDetail(OrderDetailDto orderDetailDto);

    List<OrderDetail> getOrdersByEmployeeAndWeek(Employee employee, Date startDate, Date endDate);

    List<OrderDetail> getOrdersByZipcodeAndWeek(String zipcode, Date startDate, Date endDate);
}
