package com.ecommerce.bulkorderprocessingservice;


import com.ecommerce.bulkorderprocessingservice.models.Order;
import com.ecommerce.bulkorderprocessingservice.models.OrderUpdate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class BulkOrderProcessingService {

    @Autowired
    private BulkOrderProcessingRepository bulkOrderProcessingRepository;

    public void saveBulkOrder(List<Order> orders) {
        List<Order> newOrders = orders.stream().map(o -> {
            Order temp = o ;
            temp.setCreateDate(LocalDateTime.now());
            return temp;
        }).collect(Collectors.toList());
        List<Order> savedOrders = this.bulkOrderProcessingRepository.saveAll(newOrders);
    }

    public void updateBulkOrder(List<OrderUpdate> orders) {
        // we can divide this logic tobe called for batch set,
        // and a batch set can be based on number of orders to be updated.
        Map<Long, OrderUpdate> mappedOrders = orders.stream()
                .collect(Collectors.toMap(OrderUpdate :: getId , o -> o));

        List<Long> orderId = orders.stream()
                .map(o -> o.getId())
                .collect(Collectors.toList());

        List<Order> toBeUpdatedOrders = this.bulkOrderProcessingRepository.findAllById(orderId);

        List<Order> updatedOrders = toBeUpdatedOrders.stream().map(o -> {
            Order temp = o;
            temp.setStatus(mappedOrders.get(o.getId()).getStatus());
            temp.setUpdatedDate(LocalDateTime.now());
            return temp;
        }).collect(Collectors.toList());

        this.bulkOrderProcessingRepository.saveAll(updatedOrders);
    }
}
