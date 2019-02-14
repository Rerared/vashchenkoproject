package com.vashchenko.dao;

import java.math.BigDecimal;

public interface ProductDao {
    /**
     * Add new product to the product list.
     * @param name
     * @param price
     * @return
     */
    boolean addProduct(String name, BigDecimal price);

}
