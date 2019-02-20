package com.vashchenko.services.impl;

import com.vashchenko.dao.ProductDao;
import com.vashchenko.dao.impl.ProductDaoImpl;
import com.vashchenko.domain.Product;
import com.vashchenko.services.ProductService;

import java.math.BigDecimal;
import java.util.List;

public class ProductServiceImpl implements ProductService {
    private ProductDao productDao;

    public ProductServiceImpl(ProductDao productDao){
        this.productDao = productDao;
    }

    @Override
    public void addProduct(String name, BigDecimal price) {
        productDao.addProduct(name, price);
        System.out.println("Product was added");
    }

    @Override
    public void deleteProduct(long productId) {
        productDao.deleteProduct(productId);
    }

    @Override
    public void modifyProduct(long productId) {
        productDao.modifyProduct(productId);
        System.out.println("Product:" + productId + " was modified");
    }

    @Override
    public List<Product> getListProduct() {
        return productDao.getListProduct();
    }
}
