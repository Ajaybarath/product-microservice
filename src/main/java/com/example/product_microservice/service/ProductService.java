package com.example.product_microservice.service;

import com.example.product_microservice.exceptions.CategoryException;
import com.example.product_microservice.exceptions.ProductException;
import com.example.product_microservice.model.Category;
import com.example.product_microservice.model.Product;
import com.example.product_microservice.model.Stock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.*;
import java.util.HashMap;
import java.util.Map;

@Service
public class ProductService {

    Map<Integer, Product> productList = new HashMap<>();

    @Autowired
    CategoryService categoryService;

    public Product getProduct(int id) throws ProductException {
        if (!productList.containsKey(id)) {
            throw new ProductException("Product does not exist");
        }
        return productList.get(id);
    }

    public List<Product> getAllProducts() {
        List<Product> products = new ArrayList<>(productList.values());
        return products;
    }

    public void createProduct(Product product) throws ProductException, CategoryException {
        if (productList.containsKey(product.getId())) {
            throw new ProductException("Product already exist");
        }
        product.getCategory().getProductList().put(product.getId(), product);
        productList.put(product.getId(), product);
//        categoryService.addProductFromCategory(product.getCategory().getId(), product);
    }

    public void deleteProduct(int id) throws ProductException, CategoryException {
        if (!productList.containsKey(id)) {
            throw new ProductException("Product does not exist");
        }
        categoryService.deleteProductFromCategory(id, productList.get(id).getCategory().getId());
        productList.remove(id);

    }

    public void updateProduct(Product product) throws ProductException {
        if (!productList.containsKey(product.getId())) {
            throw new ProductException("Product does not exist");
        }

        productList.put(product.getId(), product);
    }

    public void updateStockBy(int id, int quantity) throws ProductException {
        if (productList.containsKey(id)) {
            throw new ProductException("Product does not exist");
        }

        if (quantity == 0) {
            return;
        }

        Product product = productList.get(id);
        Stock stock = product.getStock();
        int updatedStock = stock.getStock() + quantity;
        stock.setStock(updatedStock);
        product.setStock(stock);

        productList.put(id, product);
    }

}
