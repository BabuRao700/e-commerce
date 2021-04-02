package com.ecommerce.orderservice.services;

import com.ecommerce.orderservice.OrderRepository;
import com.ecommerce.orderservice.models.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    public Order getOrderById(Long id) {
        return this.orderRepository.findById(id).orElse(null);
    }

    public void createOrder(Order order) {
        this.orderRepository.save(order);
    }

    public void cancelOrder(Order order) {
        this.orderRepository.delete(order);
    }
}


