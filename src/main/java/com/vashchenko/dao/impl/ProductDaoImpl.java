package com.vashchenko.dao.impl;

import com.vashchenko.dao.ProductDao;

import java.math.BigDecimal;

public class ProductDaoImpl implements ProductDao {
    @Override
    public boolean addProduct(String name, BigDecimal price) {
        return true;
    }
}
