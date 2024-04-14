package com.example.learningspring.services;

import com.example.learningspring.exceptions.ProductNotFoundException;
import com.example.learningspring.models.Category;
import com.example.learningspring.models.Product;
import com.example.learningspring.repositories.CategoryRepository;
import com.example.learningspring.repositories.ProductRepository;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Primary
public class SelfProductSerivce implements ProductService {
    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;

    public SelfProductSerivce(ProductRepository productRepository , CategoryRepository categoryRepository) {
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
    }

    @Override
    public Product getProductById(Long id) {
        Optional<Product> optionLProduct = productRepository.findById(id);
        if (optionLProduct.isEmpty()) {
            throw new ProductNotFoundException(id, "Please pass a valid productId");
        }
        return optionLProduct.get();
    }

    @Override
    public List<Product> getAllProducts() {
        return null;
    }

    @Override
    public Product createProduct(Product product) {
        Category category = product.getCategory();

        Category savedCategory = null;
        if(category.getId() == null) {
//            savedCategory = categoryRepository.save(category);
            product.setCategory(categoryRepository.save(category));
        }
        Product product1 = productRepository.save(product);
        Optional<Category> optionalCategory = categoryRepository.findById(category.getId());
        if(optionalCategory.isEmpty()) {
            throw new ProductNotFoundException(category.getId(), "Please pass a valid categoryId");
        }
        product1.setCategory(optionalCategory.get());
        return product1;

    }
}
