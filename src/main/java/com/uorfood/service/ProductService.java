package com.uorfood.service;

import com.uorfood.dao.implementation.ProductImplementation;
import com.uorfood.ddd.Products;

import java.sql.SQLException;
import java.util.List;

public class ProductService {
    private ProductImplementation productDao = new ProductImplementation();

    public ProductService() throws SQLException {
    }

    public List<Products> getAllProduct() {
        return productDao.getAllProduct();
    }

    public void insertProduct(Products products) {
        productDao.insertProduct(products);
    }
}
