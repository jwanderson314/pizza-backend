package com.jsonpizzeria.pizzabackend.services;

import com.jsonpizzeria.pizzabackend.model.Employee;
import com.jsonpizzeria.pizzabackend.model.OrderDetail;
import com.jsonpizzeria.pizzabackend.repository.OrderDetailRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
@Transactional
public class OrderDetailService {

    @Autowired
    private OrderDetailRepository orderDetailRepository;
    public List<OrderDetail> findByEmployeeAndWeek(Employee employee, Date startDate, Date endDate){
        return orderDetailRepository.findByEmployeeAndOrderDateBetween(employee,startDate,endDate);
    }

    public List<OrderDetail> findByZipcodeAndWeek(String zipcode, Date startDate, Date endDate) {
        return orderDetailRepository.findByCustomer_ZipcodeAndOrderDateBetween(zipcode, startDate, endDate);
    }
}
