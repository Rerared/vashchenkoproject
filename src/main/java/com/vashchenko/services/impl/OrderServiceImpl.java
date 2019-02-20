package com.vashchenko.services.impl;

import com.vashchenko.dao.OrderDao;
import com.vashchenko.dao.impl.OrderDaoImpl;
import com.vashchenko.domain.Order;
import com.vashchenko.domain.Product;
import com.vashchenko.services.OrderService;

import java.util.List;

public class OrderServiceImpl implements OrderService {
    private OrderDao orderDao;

    public OrderServiceImpl(OrderDao orderDao) {
        this.orderDao = orderDao;
    }

    @Override
    public void makeOrder(long id, List<Product> products) {
        orderDao.createOrder(id, products);
    }

    @Override
    public void deleteOrder(long id) {
        orderDao.delete(id);
    }

    @Override
    public void modifyOrder(long id) {
        orderDao.modify(id);
    }

    @Override
    public List<Order> getAllOrders() {
        return orderDao.getAllOrders();
    }
}
