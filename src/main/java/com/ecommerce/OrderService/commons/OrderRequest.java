package com.ecommerce.OrderService.commons;

import com.ecommerce.OrderService.entities.OrderItem;

public class OrderRequest {
    private OrderItem order;
    private Product product;

    public OrderRequest() {
    }

    public OrderRequest(OrderItem order, Product product) {
        this.order = order;
        this.product = product;
    }

    public OrderItem getOrder() {
        return order;
    }

    public void setOrder(OrderItem order) {
        this.order = order;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    @Override
    public String toString() {
        return "TransactionRequest{" +
                "order=" + order +
                ", product=" + product +
                '}';
    }
}
