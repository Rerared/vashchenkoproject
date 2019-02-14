package com.vashchenko.services;

import java.math.BigDecimal;

public interface ProductService {
    /**
     * Add new product to the List of products.
     * @param name of the product;
     * @param price of the product.
     */
    void addProduct(String name, BigDecimal price);
}
