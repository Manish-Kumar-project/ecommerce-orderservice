package com.ecommerce.OrderService.commons;

public class Product {

    private Integer productId;
    private String ProductStatus;
    private Integer orderId;
    private Double orderAmount;

    public Product() {
    }

    public Product(Integer productId, String productStatus, Integer orderId, Double orderAmount) {
        this.productId = productId;
        ProductStatus = productStatus;
        this.orderId = orderId;
        this.orderAmount = orderAmount;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public String getProductStatus() {
        return ProductStatus;
    }

    public void setProductStatus(String productStatus) {
        ProductStatus = productStatus;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public Double getOrderAmount() {
        return orderAmount;
    }

    public void setOrderAmount(Double orderAmount) {
        this.orderAmount = orderAmount;
    }

    @Override
    public String toString() {
        return "Product{" +
                "productId=" + productId +
                ", ProductStatus='" + ProductStatus + '\'' +
                ", orderId=" + orderId +
                ", orderAmount=" + orderAmount +
                '}';
    }
}
