package com.jsonpizzeria.pizzabackend.services.implementation;

import com.jsonpizzeria.pizzabackend.dto.EmployeeDto;
import com.jsonpizzeria.pizzabackend.dto.ProductDto;
import com.jsonpizzeria.pizzabackend.exception.ResourceNotFoundException;
import com.jsonpizzeria.pizzabackend.mapper.ProductMapper;
import com.jsonpizzeria.pizzabackend.model.Employee;
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

    @Override
    public Product updateProduct(Long product_id, ProductDto updatedProductDto) {
        Product product = productRepository.findById(product_id).orElseThrow(
                () -> new ResourceNotFoundException("Product with id " + product_id + " not foudn")
        );
        if (product != null){
            if(updatedProductDto.getProduct_name() != null){
                product.setProduct_name(updatedProductDto.getProduct_name());
            }
            if(updatedProductDto.getDescription() != null){
                product.setDescription(updatedProductDto.getDescription());
            }
            if(updatedProductDto.getPrice() != null){
                product.setPrice(updatedProductDto.getPrice());
            }
            return productRepository.save(product);
        }
        return null;
    }
}
