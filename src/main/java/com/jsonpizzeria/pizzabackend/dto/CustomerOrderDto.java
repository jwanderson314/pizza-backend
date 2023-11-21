package com.jsonpizzeria.pizzabackend.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Timestamp;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CustomerOrderDto {

    private Long order_id;
    private Long phone_number;
    private Long employee_id;
    private Date date;
    private Timestamp time;
}
