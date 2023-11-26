package com.jsonpizzeria.pizzabackend.mapper;

import com.jsonpizzeria.pizzabackend.dto.ProductDto;
import com.jsonpizzeria.pizzabackend.model.Product;

public class ProductMapper {
    public static ProductDto mapToProductDto(Product product){
        if(product == null){
            return null;
        }
        ProductDto productDto = new ProductDto();
        productDto.setProduct_id(product.getProduct_id());
        productDto.setProduct_name(product.getProduct_name());
        productDto.setDescription(product.getDescription());
        productDto.setPrice(product.getPrice());

        return productDto;
    }

    public static Product mapToProduct(ProductDto productDto){
        if(productDto == null){
            return null;
        }
        Product product = new Product();
        product.setProduct_id(productDto.getProduct_id());
        product.setProduct_name(productDto.getProduct_name());
        product.setDescription(productDto.getDescription());
        product.setPrice(productDto.getPrice());

        return product;
    }
}
