package com.example.product_microservice.service;

import com.example.product_microservice.exceptions.CategoryException;
import com.example.product_microservice.model.Category;
import com.example.product_microservice.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.*;

@Service
public class CategoryService {

    Map<Integer, Category> categoryList = new HashMap<>();

    @Autowired
    ProductService productService;

    public void createCategory(Category category) throws CategoryException {
        if (categoryList.containsKey(category.getId())) {
            throw new CategoryException("Category already exist");
        }

        categoryList.put(category.getId(), category);
    }

    public List<Category> getAllCategory() {
        return new ArrayList<>(categoryList.values());
    }

    public void updateCategory(Category category) throws CategoryException {
        if (!categoryList.containsKey(category.getId())) {
            throw new CategoryException("Category does not exist");
        }
        categoryList.put(category.getId(), category);
    }

    public List<Product> getProductsByCategory(int id) throws CategoryException {
        if (!categoryList.containsKey(id)) {
            throw new CategoryException("Category does not exist");
        }
        Category category = categoryList.get(id);
        return  new ArrayList<>(category.getProductList().values());
//        return products;
    }

    public void deleteCategory(int id) throws CategoryException {
        if (!categoryList.containsKey(id)) {
            throw new CategoryException("Category does not exist");
        }
        Category category = categoryList.get(id);
        categoryList.remove(id);

        productService.productList.remove(category.getProductList());

    }

    public void deleteProductFromCategory(int productId, int categoryId) throws CategoryException {
        Category category = categoryList.get(categoryId);
        if (!category.getProductList().containsKey(productId)) {
            throw new CategoryException("Product does not exist in the category");
        }
        category.getProductList().remove(productId);

        categoryList.put(categoryId, category);
    }

    public void addProductFromCategory(int categoryId, Product product) throws CategoryException {
        Category category = categoryList.get(categoryId);
        if (category.getProductList().containsKey(product.getId())) {
            throw new CategoryException("Product already exist in the category");
        }
        category.getProductList().put(product.getId(), product);
        categoryList.put(categoryId, category);
    }

}
