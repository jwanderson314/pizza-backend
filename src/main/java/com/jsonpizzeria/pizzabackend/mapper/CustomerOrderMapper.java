package com.jsonpizzeria.pizzabackend.mapper;

import com.jsonpizzeria.pizzabackend.dto.CustomerOrderDto;
import com.jsonpizzeria.pizzabackend.model.Customer;
import com.jsonpizzeria.pizzabackend.model.CustomerOrder;

public class CustomerOrderMapper {

    public static CustomerOrderDto mapToCustomerOrderDto(CustomerOrder customerOrder){
        return new CustomerOrderDto(
                customerOrder.getOrder_id(),
                customerOrder.getEmployee_id(),
                customerOrder.getDate(),
                customerOrder.getCustomer()
        );
    }

    public static CustomerOrder mapToCustomerOrder(CustomerOrderDto customerOrderDto){
        return new CustomerOrder(
                customerOrderDto.getOrder_id(),
                customerOrderDto.getEmployee_id(),
                customerOrderDto.getDate(),
                customerOrderDto.getCustomer()
        );
    }
}
