package com.jsonpizzeria.pizzabackend.model;

import jakarta.persistence.*;
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
@Entity
@Table(name="CUSTOMERORDER")
public class CustomerOrder {
    @Id
    private Long order_id;
//    @Column(name = "phone_number")
//    private Long phone_number;
    @Column(name = "employee_id")
    private Long employee_id;
    @Column(name="date")
    private Date date;
    @Column(name="time")
    private Timestamp time;


}
