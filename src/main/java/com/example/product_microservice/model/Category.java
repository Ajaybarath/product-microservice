package com.example.product_microservice.model;

import java.util.HashMap;
import java.util.Map;

public class Category {

    private int id;
    private String name;
    private Map<Integer, Product> productList = new HashMap<>();

    public Category(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public Map<Integer, Product> getProductList() {
        return productList;
    }

    public void setProductList(Map<Integer, Product> productList) {
        this.productList = productList;
    }

    public void addProduct(Product product) {
        productList.put(product.getId(), product);
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
