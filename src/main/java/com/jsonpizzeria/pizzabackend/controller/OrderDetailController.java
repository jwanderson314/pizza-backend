package com.jsonpizzeria.pizzabackend.controller;

import com.jsonpizzeria.pizzabackend.dto.OrderDetailDto;
import com.jsonpizzeria.pizzabackend.mapper.EmployeeMapper;
import com.jsonpizzeria.pizzabackend.model.Employee;
import com.jsonpizzeria.pizzabackend.model.OrderDetail;
import com.jsonpizzeria.pizzabackend.services.EmployeeService;
import com.jsonpizzeria.pizzabackend.services.OrderDetailService;
import lombok.AllArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/orderdetails")
public class OrderDetailController {
    private OrderDetailService orderDetailService;
    private EmployeeService employeeService;

    @PostMapping
    public ResponseEntity<OrderDetail> createOrderDetail(@RequestBody OrderDetailDto orderDetailDto){
        OrderDetail savedOrderDetail = orderDetailService.createOrderDetail(orderDetailDto);
        return new ResponseEntity<>(savedOrderDetail, HttpStatus.CREATED);
    }

    @GetMapping("/getOrdersByEmployeeAndWeek")
    public ResponseEntity<List<OrderDetail>> getOrdersByEmployeeAndWeek(@RequestParam Long employee_id, @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate startDate, @RequestParam @DateTimeFormat(iso=DateTimeFormat.ISO.DATE) LocalDate endDate){
        Date convertedStartDate = Date.from(startDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
        Date convertedEndDate = Date.from(endDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
        Employee employee = EmployeeMapper.mapToEmployee(employeeService.getEmployeeById(employee_id));
        List<OrderDetail> orders = orderDetailService.getOrdersByEmployeeAndWeek(employee,convertedStartDate,convertedEndDate);

        return new ResponseEntity<>(orders,HttpStatus.OK);
    }
    @GetMapping("/getOrdersByZipcodeAndWeek")
    public ResponseEntity<List<OrderDetail>> getOrdersByZipcodeAndWeek(@RequestParam String zipcode, @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate startDate,@RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)LocalDate endDate){
        Date convertedStartDate = Date.from(startDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
        Date convertedEndDate = Date.from(endDate.atStartOfDay(ZoneId.systemDefault()).toInstant());

        List<OrderDetail> orders = orderDetailService.getOrdersByZipcodeAndWeek(zipcode,convertedStartDate,convertedEndDate);

        return new ResponseEntity<>(orders,HttpStatus.OK);
    }

}
