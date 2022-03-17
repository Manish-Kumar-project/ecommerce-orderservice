package com.ecommerce.OrderService.entities;

import javax.persistence.*;

@Entity
public class OrderItem {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Integer id;
    private Integer orderId;
    private String orderName;
    private String orderCode;
    private String orderUniqueId;


    public OrderItem() {
    }

    public OrderItem(Integer id, Integer orderId, String orderName, String orderCode, String orderUniqueId) {
        this.id = id;
        this.orderId = orderId;
        this.orderName = orderName;
        this.orderCode = orderCode;
        this.orderUniqueId = orderUniqueId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public String getOrderName() {
        return orderName;
    }

    public void setOrderName(String orderName) {
        this.orderName = orderName;
    }

    public String getOrderCode() {
        return orderCode;
    }

    public void setOrderCode(String orderCode) {
        this.orderCode = orderCode;
    }

    public String getOrderUniqueId() {
        return orderUniqueId;
    }

    public void setOrderUniqueId(String orderUniqueId) {
        this.orderUniqueId = orderUniqueId;
    }
}
