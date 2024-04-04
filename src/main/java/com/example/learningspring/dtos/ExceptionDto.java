package com.example.learningspring.dtos;

import lombok.Getter;
import lombok.Setter;
import org.springframework.web.bind.annotation.GetMapping;

@Getter
@Setter
public class ExceptionDto {
    private String message;
    private String resoultion;
}
