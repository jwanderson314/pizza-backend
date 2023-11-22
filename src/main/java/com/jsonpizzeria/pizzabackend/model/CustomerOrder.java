package com.jsonpizzeria.pizzabackend.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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
    @Column(name="date")
    private Date date;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(referencedColumnName = "phone_number")
    private Customer customer;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(referencedColumnName = "employee_id")
    private Employee employee;

    @PrePersist
    protected void onCreate(){
        this.date = new Date();
    }




}
