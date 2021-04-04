package com.ecommerce.orderservice.models;


import lombok.*;

@Builder
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class OrderResponse {
    private long orderId;
    private String message;
}
