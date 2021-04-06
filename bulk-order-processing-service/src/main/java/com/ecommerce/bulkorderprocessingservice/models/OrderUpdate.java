package com.ecommerce.bulkorderprocessingservice.models;


import lombok.*;

import javax.persistence.Column;
import java.time.LocalDateTime;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class OrderUpdate {
    private Long id;
    private String status;
    private LocalDateTime lastUpdateTime;
}
