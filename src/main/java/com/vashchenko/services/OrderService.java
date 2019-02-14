package com.vashchenko.services;

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
     * @return a status of order, is he active or no.
     */
    public boolean isActive();
}
