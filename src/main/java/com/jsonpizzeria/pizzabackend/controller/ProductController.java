package com.jsonpizzeria.pizzabackend.controller;

import com.jsonpizzeria.pizzabackend.dto.EmployeeDto;
import com.jsonpizzeria.pizzabackend.dto.ProductDto;
import com.jsonpizzeria.pizzabackend.model.Employee;
import com.jsonpizzeria.pizzabackend.model.Product;
import com.jsonpizzeria.pizzabackend.services.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/products")
public class ProductController {
    private ProductService productService;

    @GetMapping
    public ResponseEntity<List<ProductDto>> getAllProducts(){
        List<ProductDto> products = productService.getAllProducts();
        return ResponseEntity.ok(products);
    }

    @PutMapping("{product_id}")
    public ResponseEntity<Product> updateProduct(@PathVariable("product_id") Long product_id, @RequestBody ProductDto updatedProduct){
        Product product = productService.updateProduct(product_id,updatedProduct);
        return ResponseEntity.ok(product);
    }
}
