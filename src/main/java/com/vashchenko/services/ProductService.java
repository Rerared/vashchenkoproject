package com.vashchenko.services;

import com.vashchenko.domain.Product;

import java.math.BigDecimal;
import java.util.List;

public interface ProductService {
    /**
     * Add new {@link Product} to the List of products.
     * @param name of the product;
     * @param price of the product.
     */
    void addProduct(String name, BigDecimal price);

    /**
     * Deletes product by product's id.
     * @param productId
     */
    void deleteProduct(long productId);

    /**
     * Modifies product by product's id.
     * @param productId
     */
    void modifyProduct(long productId);

    /**
     * Gets list of all product.
     * @return list of all available products.
     */
    List<Product> getListProduct();
}
