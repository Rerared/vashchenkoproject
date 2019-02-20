package com.vashchenko.dao;

import com.vashchenko.domain.Product;

import java.math.BigDecimal;
import java.util.List;

public interface ProductDao {
    /**
     * Add new product to the product list.
     * @param name
     * @param price
     * @return
     */
    boolean addProduct(String name, BigDecimal price);

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
