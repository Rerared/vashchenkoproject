package com.vashchenko.domain;

import java.util.List;
import java.util.Objects;

public class Order {
    private long id;
    private long clientId;
    private List<Product> products;

    public Order() {

    }

    public Order(long clientId, List<Product> products) {
        this.clientId = clientId;
        this.products = products;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", client=" + clientId +
                ", products=" + products +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o){
            return true;
        }
        if (o == null || getClass() != o.getClass()){
            return false;
        }
        Order order = (Order) o;
        return id == order.id &&
                clientId == order.clientId &&
                products.equals(order.products);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, clientId, products);
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getClientId() {
        return clientId;
    }

    public void setClient(long clientId) {
        this.clientId = clientId;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }
}
