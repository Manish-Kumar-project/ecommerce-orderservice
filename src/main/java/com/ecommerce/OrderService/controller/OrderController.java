package com.ecommerce.OrderService.controller;

import com.ecommerce.OrderService.commons.OrderRequest;
import com.ecommerce.OrderService.commons.OrderResponse;
import com.ecommerce.OrderService.entities.OrderItem;
import com.ecommerce.OrderService.repository.OrderRepository;
import com.ecommerce.OrderService.service.OrderService;
import org.aspectj.weaver.ast.Or;
import org.hibernate.criterion.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/product")
public class OrderController {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private OrderService orderService;



    @PostMapping(value = "/order")
    public ResponseEntity<OrderResponse> saveCustomer(@RequestBody OrderRequest order){
        OrderResponse orderItem = orderService.addOrder(order);
        return new ResponseEntity<OrderResponse>(orderItem, HttpStatus.OK);

    }

    @GetMapping(value = "/orders")
    public ResponseEntity<List<OrderItem>> getAllProducts(){
        List<OrderItem> allproducts = orderService.getAllOrders();
        return new ResponseEntity<List<OrderItem>>(allproducts,HttpStatus.OK);
    }
}