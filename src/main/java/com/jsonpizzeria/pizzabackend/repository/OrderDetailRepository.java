package com.jsonpizzeria.pizzabackend.repository;

import com.jsonpizzeria.pizzabackend.model.Employee;
import com.jsonpizzeria.pizzabackend.model.OrderDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface OrderDetailRepository extends JpaRepository<OrderDetail,Long> {
    List<OrderDetail> findByEmployeeAndOrderDateBetween(Employee employee, Date startDate, Date endDate);

    List<OrderDetail> findByCustomer_ZipcodeAndOrderDateBetween(String zipcode, Date startDate, Date endDate);

}
