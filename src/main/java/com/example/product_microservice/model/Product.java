package com.example.product_microservice.model;

public class Product {

    private int id;
    private String name;
    private String description;
    private Category category;
    private String rate;
    private String mrp;
    private Stock stock;
    private int discount;

    public Product(int id, String name, String description, Category category, String rate, String mrp, Stock stock, int discount) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.category = category;
        this.rate = rate;
        this.mrp = mrp;
        this.stock = stock;
        this.discount = discount;
    }

    public void setId(int id) {
        this.id = id;
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

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public String getRate() {
        return rate;
    }

    public void setRate(String rate) {
        this.rate = rate;
    }

    public String getMrp() {
        return mrp;
    }

    public void setMrp(String mrp) {
        this.mrp = mrp;
    }

    public Stock getStock() {
        return stock;
    }

    public void setStock(Stock stock) {
        this.stock = stock;
    }

    public int getDiscount() {
        return discount;
    }

    public void setDiscount(int discount) {
        this.discount = discount;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
