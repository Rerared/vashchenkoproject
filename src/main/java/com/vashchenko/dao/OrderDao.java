package com.vashchenko.dao;

import com.vashchenko.domain.Order;
import com.vashchenko.domain.Product;

import java.util.List;

public interface OrderDao {
    /**
     * Create order.
     * @param clientId of the client.
     * @param products list of products.
     */
    void createOrder(long clientId, List<Product> products);

    /**
     * Delete order by client's id.
     * @param clientId the client's id.
     */
    void delete(long clientId);

    /**
     * Modify order by client's id.
     * @param clientId the client's id.
     */
    void modify(long clientId);

    /**
     * Returns list of all orders.
     * @return List of all orders
     */
    List<Order> getAllOrders();


}
