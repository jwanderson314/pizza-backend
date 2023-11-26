package com.jsonpizzeria.pizzabackend.services.implementation;

import com.jsonpizzeria.pizzabackend.dto.OrderDetailDto;
import com.jsonpizzeria.pizzabackend.exception.ResourceNotFoundException;
import com.jsonpizzeria.pizzabackend.mapper.OrderDetailMapper;
import com.jsonpizzeria.pizzabackend.model.CustomerOrder;
import com.jsonpizzeria.pizzabackend.model.Employee;
import com.jsonpizzeria.pizzabackend.model.OrderDetail;
import com.jsonpizzeria.pizzabackend.model.Product;
import com.jsonpizzeria.pizzabackend.repository.CustomerOrderRepository;
import com.jsonpizzeria.pizzabackend.repository.EmployeeRepository;
import com.jsonpizzeria.pizzabackend.repository.OrderDetailRepository;
import com.jsonpizzeria.pizzabackend.repository.ProductRepository;
import com.jsonpizzeria.pizzabackend.services.OrderDetailService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.mvc.condition.ProducesRequestCondition;

@Service
@AllArgsConstructor
public class OrderDetailServiceImpl implements OrderDetailService {
    @Autowired
    private CustomerOrderRepository customerOrderRepository;
    @Autowired
    private EmployeeRepository employeeRepository;
    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private OrderDetailRepository orderDetailRepository;
    @Override
    public OrderDetail createOrderDetail(OrderDetailDto orderDetailDto) {
        CustomerOrder customerOrder = customerOrderRepository.findById(orderDetailDto.getCustomerOrder().getOrder_id()).orElseThrow(
                () -> new ResourceNotFoundException("Customer Order ID does not exist")
        );
        Product product = productRepository.findById(orderDetailDto.getProduct().getProduct_id()).orElseThrow(
                () -> new ResourceNotFoundException("Product ID not found")
        );
        Employee employee = employeeRepository.findById(orderDetailDto.getEmployee().getEmployee_id()).orElseThrow(
                () -> new ResourceNotFoundException("Employee ID not found")
        );
        OrderDetail orderDetail = new OrderDetail();
        orderDetail.setOrder_detail_id(orderDetailDto.getOrder_detail_id());
        orderDetail.setZipcode(orderDetailDto.getZipcode());
        orderDetail.setCustomerOrder(customerOrder);
        orderDetail.setProduct(product);
        orderDetail.setQuantity(orderDetailDto.getQuantity());
        orderDetail.setPriceCharged(orderDetailDto.getPriceCharged());
        orderDetail.setHistoricPrice(orderDetailDto.getHistoricPrice());
        orderDetail.setEmployee(employee);

        return orderDetailRepository.save(orderDetail);


    }
}
