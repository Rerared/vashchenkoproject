package com.vashchenko.dao.impl;

import com.vashchenko.dao.OrderDao;
import com.vashchenko.domain.Order;
import com.vashchenko.domain.Product;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OrderDaoImpl implements OrderDao {
    private Map<Long, Order> orders = new HashMap<>();
    private static long generator = 0;

    @Override
    public void createOrder(long clientId, List<Product> products) {
        Order order = new Order(clientId,products);
        order.setId(generator++);
        orders.put(order.getId(), order);
        System.out.println("Saved" + order);
    }

    @Override
    public void delete(long clientId) {
        orders.remove(clientId);
    }

    @Override
    public void modify(long clientId) {

    }

    @Override
    public List<Order> getAllOrders() {
        List<Order> ordersList = (List<Order>) orders.values();
        return ordersList;
    }
}
