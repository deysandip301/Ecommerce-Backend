package com.example.learningspring.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor // initialize the constructor with all the attributes
@NoArgsConstructor // initialize default constructor
public class Product {
    private Long id;
    private String title;
    private String description;
    private double price ;
    private Category category;
    private String image;
}
