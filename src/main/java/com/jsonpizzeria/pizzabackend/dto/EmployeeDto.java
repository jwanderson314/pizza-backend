package com.jsonpizzeria.pizzabackend.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.jsonpizzeria.pizzabackend.model.Customer;
import com.jsonpizzeria.pizzabackend.model.CustomerOrder;
import com.jsonpizzeria.pizzabackend.model.OrderDetail;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeDto {
    private Long employee_id;
    private String username;
    @JsonIgnore
    private CustomerOrder customerOrder;
    @JsonIgnore
    private List<OrderDetail> orderDetails;
}
