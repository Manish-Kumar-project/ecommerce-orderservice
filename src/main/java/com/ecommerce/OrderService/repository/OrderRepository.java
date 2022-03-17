package com.ecommerce.OrderService.repository;

import com.ecommerce.OrderService.entities.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface OrderRepository extends JpaRepository<OrderItem, Integer> {
}
