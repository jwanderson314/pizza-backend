package com.jsonpizzeria.pizzabackend.services.implementation;

import com.jsonpizzeria.pizzabackend.dto.ProductDto;
import com.jsonpizzeria.pizzabackend.mapper.ProductMapper;
import com.jsonpizzeria.pizzabackend.model.Product;
import com.jsonpizzeria.pizzabackend.repository.ProductRepository;
import com.jsonpizzeria.pizzabackend.services.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ProductServiceImpl implements ProductService {
    private ProductRepository productRepository;

    @Override
    public List<ProductDto> getAllProducts() {
        List<Product> products = productRepository.findAll();
        return products.stream().map((product) -> ProductMapper.mapToProductDto(product)).collect(Collectors.toList());
    }
}
