package com.ecommerce.bulkorderprocessingservice.models;

import com.ecommerce.bulkorderprocessingservice.BulkOrderProcessingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class MessageProcessor {

    @Autowired
    private BulkOrderProcessingService bulkOrderProcessingService;

    public void processMessage(String json) {
        List<Order> orders = Arrays.asList(Order.builder().build());
        this.bulkOrderProcessingService.saveBulkOrder(orders);
    }

    public void processMessageForBatchUpdate(String json) {
        List<OrderUpdate> orders = Arrays.asList(OrderUpdate.builder().build());
        this.bulkOrderProcessingService.updateBulkOrder(orders);
    }
}
