package com.vashchenko.services;

import com.vashchenko.domain.Order;
import com.vashchenko.domain.Product;

import java.util.List;

public interface OrderService {
    /**
     * Make order.
     * @param id of client.
     * @param products list of products.
     */
    public void makeOrder(long id, List<Product> products);
    /**
     * Delete order by client's id.
     * @param id the client's id.
     */
    void deleteOrder(long id);

    /**
     * Modify order by client's id.
     * @param id the client's id.
     */
    void modifyOrder(long id);
    /**
     * Returns list of all orders.
     * @return List of all orders
     */
     List<Order> getAllOrders();
}
