package com.jsonpizzeria.pizzabackend.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.jsonpizzeria.pizzabackend.model.CustomerOrder;
import com.jsonpizzeria.pizzabackend.model.Employee;
import com.jsonpizzeria.pizzabackend.model.Product;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class OrderDetailDto {
    private Long order_detail_id;
    private Date date;
    private String zipcode;
    private CustomerOrderDto customerOrder;
    private ProductDto product;
    private int quantity;
    private BigDecimal priceCharged;
    private BigDecimal historicPrice;
    private EmployeeDto employee;
}
