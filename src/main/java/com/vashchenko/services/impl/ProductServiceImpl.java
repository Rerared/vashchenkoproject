package com.vashchenko.services.impl;

import com.vashchenko.dao.ProductDao;
import com.vashchenko.dao.impl.ProductDaoImpl;
import com.vashchenko.services.ProductService;

import java.math.BigDecimal;

public class ProductServiceImpl implements ProductService {
    private ProductDao productDao = new ProductDaoImpl();

    @Override
    public void addProduct(String name, BigDecimal price) {
        productDao.addProduct(name, price);
        System.out.println("Product was added");
    }
}
