package com.ecommerce.orderservice.services;

import com.ecommerce.orderservice.OrderRepository;
import com.ecommerce.orderservice.models.Order;
import com.ecommerce.orderservice.models.OrderResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

// all the business logic goes in the service layer
@Slf4j
@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    public Order getOrderById(Long id) {
        return this.orderRepository.findById(id)
                .orElse(null);
    }

    public OrderResponse createOrder(Order order) {
        order.setCreateDate(LocalDateTime.now());
        Order savedOrder = this.orderRepository.save(order);
        log.info("Order saved successfully with ID: ", savedOrder.getId());

        return OrderResponse.builder()
                .orderId(savedOrder.getId())
                .message("Order successfully saved!!")
                .build();
    }

    public void cancelOrder(Order order) {
        this.orderRepository.delete(order);
    }

    //    public void createBulkOrder(List<Order> orders) {
//        this.orderRepository.saveAll(orders);
//    }

}


