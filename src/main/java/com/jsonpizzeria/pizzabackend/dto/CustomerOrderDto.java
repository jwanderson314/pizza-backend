package com.jsonpizzeria.pizzabackend.dto;

import com.jsonpizzeria.pizzabackend.model.Customer;
import com.jsonpizzeria.pizzabackend.model.CustomerOrder;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CustomerOrderDto {

    private Long order_id;
    private Long employee_id;
    private Date date;
    private Customer customer;
}
