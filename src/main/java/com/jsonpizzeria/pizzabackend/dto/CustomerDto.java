package com.jsonpizzeria.pizzabackend.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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

}
