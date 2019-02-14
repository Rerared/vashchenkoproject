package com.vashchenko.services.impl;

import com.vashchenko.dao.OrderDao;
import com.vashchenko.dao.impl.OrderDaoImpl;
import com.vashchenko.domain.Product;
import com.vashchenko.services.OrderService;

import java.util.List;

public class OrderServiceImpl implements OrderService {
    private OrderDao orderDao = new OrderDaoImpl();

    @Override
    public void makeOrder(long id, List<Product> products) {
        orderDao.saveOrder(id, products);
    }

    @Override
    public boolean isActive() {
        boolean result = orderDao.isActive();
        System.out.println("Order is active:" + result);
        return result;
    }
}
