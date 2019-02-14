package com.vashchenko.dao;

import com.vashchenko.domain.Product;

import java.util.List;

public interface OrderDao {
    /**
     * Save order.
     * @param id of the client.
     * @param products list of products.
     */
    void saveOrder(long id, List<Product> products);
    /**
     * @return status of order.
     */
    boolean isActive();

}
