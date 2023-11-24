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
public class CustomerDto {
    private Long phone_number;
    private String zipcode;
    private String city;
    private String state;
    private String street_address;
    @JsonIgnore
    private List<CustomerOrder> orders;
    @JsonIgnore
    private List<OrderDetail> orderDetails;

}
