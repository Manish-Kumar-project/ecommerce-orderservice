package com.ecommerce.OrderService.communication;

import com.ecommerce.OrderService.commons.Product;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient(name = "PRODUCT-SERVICE")
public interface OrderServiceFeignClient {

    @PostMapping("/api/product/product")
    public Product getProduct(Product product);
}
