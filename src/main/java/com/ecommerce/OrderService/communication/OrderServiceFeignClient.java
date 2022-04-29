package com.ecommerce.OrderService.communication;

import com.ecommerce.OrderService.commons.PaymentTransaction;
import com.ecommerce.OrderService.commons.Product;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient(name = "PAYMENT-SERVICE")
public interface OrderServiceFeignClient {

    @PostMapping("/api/product/product")
     Product getProduct(Product product);

    @PostMapping(value = "api/payment/member/payment/transaction")
     String  savePaymentTransaction(PaymentTransaction paymentTransaction);
}
