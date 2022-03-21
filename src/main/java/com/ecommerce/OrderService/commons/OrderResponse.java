package com.ecommerce.OrderService.commons;

import com.ecommerce.OrderService.entities.OrderItem;

public class OrderResponse {
    private OrderItem order;
    private Double amount;
    private String message;

    public OrderResponse() {
    }

    public OrderResponse(OrderItem order, Double amount, String message) {
        this.order = order;
        this.amount = amount;
        this.message = message;
    }

    public OrderItem getOrder() {
        return order;
    }

    public void setOrder(OrderItem order) {
        this.order = order;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "OrderResponse{" +
                "order=" + order +
                ", amount=" + amount +
                ", message='" + message + '\'' +
                '}';
    }
}
