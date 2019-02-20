package com.vashchenko.dao.impl;

import com.vashchenko.dao.ProductDao;
import com.vashchenko.domain.Product;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProductDaoImpl implements ProductDao {
    private Map<Long, Product> products = new HashMap<>();

    private static long generator = 3;

    public ProductDaoImpl() {
        products.put(0L,new Product("Book", BigDecimal.valueOf(50)));
        products.put(1L,new Product("Disk", BigDecimal.valueOf(100)));
        products.put(2L,new Product("Water", BigDecimal.valueOf(15)));
    }
    @Override
    public boolean addProduct(String name, BigDecimal price) {
        Product product = new Product(name,price);
        product.setId(generator++);
        products.put(product.getId(), product);
        System.out.println("Saved" + product);
        return true;
    }

    @Override
    public void deleteProduct(long productId) {
        products.remove(productId);
    }

    @Override
    public void modifyProduct(long productId) {

    }

    @Override
    public List<Product> getListProduct() {
        List<Product> productList = (List<Product>) products.values();
        return productList;
    }
}
