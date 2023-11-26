package com.jsonpizzeria.pizzabackend.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.jsonpizzeria.pizzabackend.model.OrderDetail;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProductDto {
    private Long product_id;
    private String product_name;
    private String description;
    private BigDecimal price;
    @JsonIgnore
    private OrderDetail orderDetail;
}
