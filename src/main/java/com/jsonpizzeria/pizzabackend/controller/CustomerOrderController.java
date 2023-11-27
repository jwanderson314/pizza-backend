package com.jsonpizzeria.pizzabackend.controller;

import com.jsonpizzeria.pizzabackend.dto.CustomerOrderDto;
import com.jsonpizzeria.pizzabackend.dto.EmployeeDto;
import com.jsonpizzeria.pizzabackend.model.CustomerOrder;
import com.jsonpizzeria.pizzabackend.services.CustomerOrderService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/customerorder")
public class CustomerOrderController {
    private CustomerOrderService customerOrderService;

    @PostMapping
    public ResponseEntity<CustomerOrder> createOrder(@RequestBody CustomerOrderDto orderDto){
        CustomerOrder savedOrder = customerOrderService.createOrder(orderDto);
        return new ResponseEntity<>(savedOrder, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<CustomerOrderDto>> getAllCustomerOrders(){
        List<CustomerOrderDto> customerOrders = customerOrderService.getAllCustomerOrders();
        return ResponseEntity.ok(customerOrders);
    }
}
