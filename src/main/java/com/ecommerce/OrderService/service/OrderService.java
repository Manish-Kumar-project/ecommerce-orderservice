package com.ecommerce.OrderService.service;

import com.ecommerce.OrderService.entities.OrderItem;
import com.ecommerce.OrderService.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.Order;
import java.util.List;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    public OrderItem addOrder(OrderItem order){
        OrderItem saveOrder = orderRepository.save(order);
        return saveOrder;
    }

    public List<OrderItem> getAllOrders(){
        List<OrderItem> listOfOrders = orderRepository.findAll();
        return listOfOrders;
    }

}
