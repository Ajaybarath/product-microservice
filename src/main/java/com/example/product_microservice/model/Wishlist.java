package com.example.product_microservice.model;

import java.util.*;

public class Wishlist {

    private int id;
    private int userid;
    private List<Product> productsLists;

    public Wishlist(int id, int userid, List<Product> productsLists) {
        this.id = id;
        this.userid = userid;
        this.productsLists = productsLists;
    }

    public void addToWishList(Product product) {
        productsLists.add(product);
    }

    public int getId() {
        return id;
    }

    public int getUserid() {
        return userid;
    }

    public List<Product> getProductsLists() {
        return productsLists;
    }
}
