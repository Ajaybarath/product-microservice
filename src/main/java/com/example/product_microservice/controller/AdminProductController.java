package com.example.product_microservice.controller;

import com.example.product_microservice.exceptions.CategoryException;
import com.example.product_microservice.exceptions.ProductException;
import com.example.product_microservice.model.Category;
import com.example.product_microservice.model.Product;
import com.example.product_microservice.service.CategoryService;
import com.example.product_microservice.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("admin")
@RequestMapping("admin")
public class AdminProductController {

    @Autowired
    ProductService productService;

    @Autowired
    CategoryService categoryService;

    @PostMapping("add/product")
    public ResponseEntity addProduct(Product product) throws ProductException, CategoryException {
//        int productid = generateProductId();
//        product.setId(productid);
        productService.createProduct(product);

        return ResponseEntity.ok("Product added Successfully");
    }

    @PostMapping("delete/product/{id}")
    public ResponseEntity deleteProduct(@PathVariable("id") int id) throws ProductException, CategoryException {
        productService.deleteProduct(id);
        return ResponseEntity.ok("Product deleted successfully");
    }

    @PostMapping("update/product/{id}")
    public Product updateProduct(@PathVariable("id") int id, Product product) throws ProductException {
        productService.updateProduct(product);

        return product;
    }

    @PostMapping("update/product/stock/{id}")
    public ResponseEntity updateProduct(@PathVariable("id") int id, int  quantity) throws ProductException {
        productService.updateStockBy(id, quantity);

        return ResponseEntity.ok("Stock updated");
    }

    @PostMapping("add/category")
    public ResponseEntity addCategory(Category category) throws CategoryException {
        categoryService.createCategory(category);

        return ResponseEntity.ok("Created a category successfully");
    }

    @PostMapping("delete/category/{id}")
    public ResponseEntity deleteCategory(@PathVariable("id") int id) throws CategoryException {
        categoryService.deleteCategory(id);
        return ResponseEntity.ok("Category deleted successfully");
    }

    @PostMapping("update/category/{id}")
    public Category updateCategory(@PathVariable("id") int id, Category category) throws CategoryException {
        categoryService.updateCategory(category);

        return category;
    }

//    private int generateProductId() {
//    }

}
