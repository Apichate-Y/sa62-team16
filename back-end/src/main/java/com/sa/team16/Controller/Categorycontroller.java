package com.sa.team16.Controller;

import com.sa.team16.Entity.Category;
import com.sa.team16.Repository.CategoryRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.stream.Collectors;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
public class Categorycontroller {

    @Autowired
    private final CategoryRepository categoryRepository;

    public Categorycontroller(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @GetMapping("/category")
    public Collection<Category> Categorys() {
        return categoryRepository.findAll().stream().collect(Collectors.toList());
    }

}