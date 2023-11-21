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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long order_id;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name = "phone_number",referencedColumnName = "phone_number")
    private Customer customer;
    @Column(name = "employee_id")
    private Long employee_id;
    @Column(name="date")
    private Date date;
    @Column(name="time")
    private Timestamp time;


    @PrePersist
    protected void onCreate(){
        this.date = new Date();
        this.time = new Timestamp(System.currentTimeMillis());
    }




}
