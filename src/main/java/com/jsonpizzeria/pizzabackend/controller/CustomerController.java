package com.jsonpizzeria.pizzabackend.controller;

import com.jsonpizzeria.pizzabackend.dto.CustomerDto;
import com.jsonpizzeria.pizzabackend.model.Customer;
import com.jsonpizzeria.pizzabackend.services.CustomerService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    public ResponseEntity<Customer> updateCustomer(@PathVariable("phone_number") Long phone_number,@RequestBody CustomerDto updatedCustomer){
        Customer customer = customerService.updateCustomer(phone_number,updatedCustomer);
        return ResponseEntity.ok(customer);

    }

    @GetMapping
    public ResponseEntity<List<CustomerDto>> getAllCustomers(){
        List<CustomerDto> customers = customerService.getAllCustomers();
        return ResponseEntity.ok(customers);
    }
}
