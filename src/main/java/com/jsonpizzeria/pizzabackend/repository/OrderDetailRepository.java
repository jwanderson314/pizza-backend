package com.jsonpizzeria.pizzabackend.repository;

import com.jsonpizzeria.pizzabackend.dto.OrderDetailDto;
import com.jsonpizzeria.pizzabackend.model.Employee;
import com.jsonpizzeria.pizzabackend.model.OrderDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

public interface OrderDetailRepository extends JpaRepository<OrderDetail,Long> {
    List<OrderDetail> findByEmployeeAndDateBetweenOrderByDate(Employee employee, Date startDate, Date endDate);
    List<OrderDetail> findByZipcodeAndDateBetweenOrderByDate(String zipcode, Date startDate, Date endDate);
}
