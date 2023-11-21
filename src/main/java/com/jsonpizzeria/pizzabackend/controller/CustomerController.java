package com.jsonpizzeria.pizzabackend.controller;

import com.jsonpizzeria.pizzabackend.dto.CustomerDto;
import com.jsonpizzeria.pizzabackend.services.CustomerService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
@RequestMapping("/api/customers")
public class CustomerController {

    private CustomerService customerService;

    //Build Add Customer REST API
    @PostMapping
    public ResponseEntity<CustomerDto> createCustomer(@RequestBody CustomerDto customerDto){
        CustomerDto savedCustomer = customerService.createCustomer(customerDto);
        return new ResponseEntity<>(savedCustomer, HttpStatus.CREATED);
    }

    @PutMapping("{phone_number}")
    public ResponseEntity<CustomerDto> updateCustomer(@PathVariable("phone_number") Long phone_number,@RequestBody CustomerDto updatedCustomer){
        CustomerDto customerDto = customerService.updateCustomer(phone_number,updatedCustomer);
        return ResponseEntity.ok(customerDto);

    }
}
