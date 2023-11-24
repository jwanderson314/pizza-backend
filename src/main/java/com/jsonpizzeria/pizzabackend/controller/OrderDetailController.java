package com.jsonpizzeria.pizzabackend.controller;

import com.jsonpizzeria.pizzabackend.model.OrderDetail;
import com.jsonpizzeria.pizzabackend.services.OrderDetailService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
@RequestMapping("/api/orderdetails")
public class OrderDetailController {
    private OrderDetailService orderDetailService;

    @PostMapping
    public ResponseEntity<OrderDetail> createOrderDetail(@RequestBody OrderDetail orderDetail){
        OrderDetail savedOrderDetail = orderDetailService.
    }
}
