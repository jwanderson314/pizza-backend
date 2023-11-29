package com.jsonpizzeria.pizzabackend.services;

import com.jsonpizzeria.pizzabackend.dto.ProductDto;
import com.jsonpizzeria.pizzabackend.model.Product;

import java.util.List;

public interface ProductService {
    List<ProductDto> getAllProducts();

    Product updateProduct(Long product_id, ProductDto updatedProductDto);

}
