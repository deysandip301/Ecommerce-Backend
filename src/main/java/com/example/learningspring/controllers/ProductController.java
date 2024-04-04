package com.example.learningspring.controllers;

import com.example.learningspring.dtos.ExceptionDto;
import com.example.learningspring.dtos.FakeStoreProductDto;
import com.example.learningspring.models.Product;
import com.example.learningspring.services.FakeStoreProductService;
import com.example.learningspring.services.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController // this controller is capable to host HTTP API's
@RequestMapping("/products")  // localhost:8080/products -> ProductController
public class ProductController {
    private ProductService productService;

    ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/{id}")
    public Product getProductById(@PathVariable("id") Long id) {
        return productService.getProductById(id);
    }

    @GetMapping
    public List<Product> getAllProducts() {
        return productService.getAllProducts();
    }
}
