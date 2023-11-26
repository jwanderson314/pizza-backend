package com.jsonpizzeria.pizzabackend.mapper;

import com.jsonpizzeria.pizzabackend.dto.CustomerOrderDto;
import com.jsonpizzeria.pizzabackend.dto.EmployeeDto;
import com.jsonpizzeria.pizzabackend.dto.OrderDetailDto;
import com.jsonpizzeria.pizzabackend.dto.ProductDto;
import com.jsonpizzeria.pizzabackend.model.CustomerOrder;
import com.jsonpizzeria.pizzabackend.model.Employee;
import com.jsonpizzeria.pizzabackend.model.OrderDetail;
import com.jsonpizzeria.pizzabackend.model.Product;

public class OrderDetailMapper {
    public static OrderDetailDto mapToOrderDetailDto(OrderDetail orderDetail){
        if (orderDetail == null){
            return null;
        }
        CustomerOrderDto customerOrderDto = CustomerOrderMapper.mapToCustomerOrderDto(orderDetail.getCustomerOrder());
        ProductDto productDto = ProductMapper.mapToProductDto(orderDetail.getProduct());
        EmployeeDto employeeDto = EmployeeMapper.mapToEmployeeDto(orderDetail.getEmployee());
        return new OrderDetailDto(
                orderDetail.getOrder_detail_id(),
                orderDetail.getDate(),
                orderDetail.getZipcode(),
                customerOrderDto,
                productDto,
                orderDetail.getQuantity(),
                orderDetail.getPriceCharged(),
                orderDetail.getHistoricPrice(),
                employeeDto
        );
    }

    public static OrderDetail mapToOrderDetail(OrderDetailDto orderDetailDto){
        if(orderDetailDto == null){
            return null;
        }
        CustomerOrder customerOrder = CustomerOrderMapper.mapToCustomerOrder(orderDetailDto.getCustomerOrder());
        Product product = ProductMapper.mapToProduct(orderDetailDto.getProduct());
        Employee employee = EmployeeMapper.mapToEmployee(orderDetailDto.getEmployee());
        return new OrderDetail(
                orderDetailDto.getOrder_detail_id(),
                orderDetailDto.getDate(),
                orderDetailDto.getZipcode(),
                customerOrder,
                product,
                orderDetailDto.getQuantity(),
                orderDetailDto.getPriceCharged(),
                orderDetailDto.getHistoricPrice(),
                employee
        );

    }

    private static CustomerOrder mapToCustomerOrder(CustomerOrderDto customerOrderDto){
        if(customerOrderDto == null){
            return null;
        }
        CustomerOrder customerOrder = new CustomerOrder();
        customerOrder.setOrder_id(customerOrderDto.getOrder_id());
        customerOrder.setCustomer(CustomerMapper.mapToCustomer(customerOrderDto.getCustomer()));
        customerOrder.setEmployee(EmployeeMapper.mapToEmployee(customerOrderDto.getEmployee()));

        return customerOrder;
    }
}
