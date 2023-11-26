package com.jsonpizzeria.pizzabackend.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "EMPLOYEE")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long employee_id;
    @Column(name ="username")
    private String username;

    @OneToOne(mappedBy = "employee")
    @JsonManagedReference
    private CustomerOrder customerOrder;

    @OneToOne(mappedBy = "employee")
    @JsonManagedReference
    @JsonIgnore
    private OrderDetail orderDetail;
}
