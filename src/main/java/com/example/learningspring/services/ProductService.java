package com.example.learningspring.services;

import com.example.learningspring.models.Product;

import java.util.List;

public interface ProductService {
    Product getProductById(Long id);

    List<Product> getAllProducts();

    Product createProduct(Product product);
}
