package com.shop.repository;

import com.shop.model.Product;

import java.util.ArrayList;
import java.util.List;

public class ProductRepository {
    private final List<Product> products = new ArrayList<>();

    public ProductRepository() {
        products.add(new Product(1, "Iphone X", 100000));
        products.add(new Product(2, "MSI Laptop", 200000));
        products.add(new Product(3, "PC Gaming", 300000));
    }

    public List<Product> getAllProducts() {
        return this.products;
    }
}
