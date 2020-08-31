package com.example.product_microservice;

import com.example.product_microservice.controller.AdminProductController;
import com.example.product_microservice.controller.UserProductController;
import com.example.product_microservice.exceptions.CategoryException;
import com.example.product_microservice.exceptions.ProductException;
import com.example.product_microservice.model.Category;
import com.example.product_microservice.model.Product;
import com.example.product_microservice.model.Stock;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashMap;

@SpringBootTest
class ProductMicroserviceApplicationTests {

    @Autowired
    UserProductController userProductController;

    @Autowired
    AdminProductController adminProductController;

    @Test
    void ProductFlowTest() throws CategoryException, ProductException {


        Category category1 = new Category(1, "Fashion");
        Category category2 = new Category(2, "Electronics");
        Category category3 = new Category(3, "Kitchen");
        Category category4 = new Category(4, "Sports");

        Stock stock1 = new Stock(1, 10);
        Stock stock2 = new Stock(2, 5);
        Stock stock3 = new Stock(3, 15);
        Stock stock4 = new Stock(4, 50);
        Stock stock5 = new Stock(5, 20);
        Stock stock6 = new Stock(6, 30);
        Stock stock7 = new Stock(7, 50);

        Product product1 = new Product(1, "Smart Phone", "description", category2,"500", "600", stock1, 5);
        Product product2 = new Product(2, "Laptop", "description", category2,"6000", "10000", stock2, 5);
        Product product3 = new Product(3, "Jeans Pant", "description", category1,"700", "800", stock3, 10);
        Product product4 = new Product(4, "Sport Shoe", "description", category4,"1000", "1600", stock4, 15);
        Product product5 = new Product(5, "Cassual Shirt", "description", category1,"300", "600", stock5, 20);
        Product product6 = new Product(6, "Kitchen Knife", "description", category3,"200", "400", stock6, 25);
        Product product7 = new Product(7, "Badmitton Racket", "description", category4,"4500", "6000", stock7, 5);

        adminProductController.addCategory(category1);
        adminProductController.addCategory(category2);
        adminProductController.addCategory(category3);
        adminProductController.addCategory(category4);

        adminProductController.addProduct(product1);
        adminProductController.addProduct(product2);
        adminProductController.addProduct(product3);
        adminProductController.addProduct(product4);
        adminProductController.addProduct(product5);
        adminProductController.addProduct(product6);
        adminProductController.addProduct(product7);

        userProductController.getAllCategory();
        userProductController.getAllProducts();

        userProductController.getAllProductByCategory(2);
        userProductController.getProductById(7);

    }

}
