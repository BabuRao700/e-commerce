package com.ecommerce.bulkorderprocessingservice;

import com.ecommerce.bulkorderprocessingservice.models.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BulkOrderProcessingRepository extends JpaRepository<Order, Long> {

}
