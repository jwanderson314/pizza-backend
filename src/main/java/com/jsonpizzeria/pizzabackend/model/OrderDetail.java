package com.jsonpizzeria.pizzabackend.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
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
@Entity
@Table(name = "ORDERDETAIL")
public class OrderDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_detail_id")
    private Long order_detail_id;

    @Column(name = "date")
    private Date date;

    @Column(name = "zipcode")
    private String zipcode;

    @OneToOne
    @JoinColumn(referencedColumnName = "order_id")
    @JsonBackReference
    private CustomerOrder customerOrder;

    @OneToOne
    @JoinColumn(referencedColumnName = "product_id")
    @JsonBackReference
    private Product product;

    @Column(name = "quantity")
    private int quantity;

    @Column(name = "price_charged")
    private BigDecimal priceCharged;

    @Column(name = "historic_price")
    private BigDecimal historicPrice;

    @OneToOne
    @JoinColumn(referencedColumnName = "employee_id")
    private Employee employee;




    @PrePersist
    protected void onCreate(){
        this.date = new Date();
    }
}
