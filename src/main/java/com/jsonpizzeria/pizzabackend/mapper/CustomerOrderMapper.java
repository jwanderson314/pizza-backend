package com.jsonpizzeria.pizzabackend.mapper;

import com.jsonpizzeria.pizzabackend.dto.CustomerOrderDto;
import com.jsonpizzeria.pizzabackend.model.CustomerOrder;

public class CustomerOrderMapper {

    public static CustomerOrderDto mapToCustomerOrderDto(CustomerOrder customerOrder){
        return new CustomerOrderDto(
                customerOrder.getOrder_id(),
                customerOrder.getPhone_number(),
                customerOrder.getEmployee_id(),
                customerOrder.getDate(),
                customerOrder.getTime()
        );
    }

    public static CustomerOrder mapToCustomerOrder(CustomerOrderDto customerOrderDto){
        return new CustomerOrder(
                customerOrderDto.getOrder_id(),
                customerOrderDto.getPhone_number(),
                customerOrderDto.getEmployee_id(),
                customerOrderDto.getDate(),
                customerOrderDto.getTime()
        );
    }
}
