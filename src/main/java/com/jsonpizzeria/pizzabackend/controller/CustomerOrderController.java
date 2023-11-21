package com.jsonpizzeria.pizzabackend.controller;

import com.jsonpizzeria.pizzabackend.dto.CustomerOrderDto;
import com.jsonpizzeria.pizzabackend.services.CustomerOrderService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
@RequestMapping("/api/customerorder")
public class CustomerOrderController {
    private CustomerOrderService customerOrderService;

    @PostMapping
    public ResponseEntity<CustomerOrderDto> createOrder(@RequestBody CustomerOrderDto customerOrderDto){
        CustomerOrderDto savedOrder = customerOrderService.createOrder(customerOrderDto);
        return new ResponseEntity<>(savedOrder, HttpStatus.CREATED);
    }
}
