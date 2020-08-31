package com.example.product_microservice.controller;

import com.example.product_microservice.exceptions.CategoryException;
import com.example.product_microservice.exceptions.ProductException;
import com.example.product_microservice.model.Category;
import com.example.product_microservice.model.Product;
import com.example.product_microservice.service.CategoryService;
import com.example.product_microservice.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

@RestController
public class UserProductController {

    @Autowired
    ProductService productService;

    @Autowired
    CategoryService categoryService;

    @GetMapping("get/product")
    public List<Product> getAllProducts() {
        return productService.getAllProducts();
    }

    @GetMapping("get/product/{id}")
    public Product getProductById(@PathVariable("id") int id) throws ProductException {
        return productService.getProduct(id);
    }

    @GetMapping("get/{category}/product")
    public List<Product> getAllProductByCategory(@PathVariable("category") int category) throws CategoryException {
        return categoryService.getProductsByCategory(category);
    }

    @GetMapping("get/categories")
    public List<Category> getAllCategory() {
        return categoryService.getAllCategory();
    }

}
