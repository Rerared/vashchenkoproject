package com.vashchenko.dao.impl;

import com.vashchenko.dao.OrderDao;
import com.vashchenko.domain.Product;

import java.util.List;

public class OrderDaoImpl implements OrderDao {
    @Override
    public void saveOrder(long id, List<Product> products) {
        System.out.println("Order of client: " + id + "with products: " + products.toString() + " was saved.");
    }

    @Override
    public boolean isActive() {

        return true;
    }
}
