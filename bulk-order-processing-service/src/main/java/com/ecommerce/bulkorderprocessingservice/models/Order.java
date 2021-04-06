package com.ecommerce.bulkorderprocessingservice.models;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "ORDERS")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    private Long id;

    @Column(name = "STATUS")
    private String status;

    @Column(name = "CUSTOMER_ID")
    private Long customerId;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Item> items;

    @Column(name = "SUB_TOTAL")
    private Double subTotal;

    @Column(name = "TAX")
    private Double tax;

    @Column(name = "SHIPPING_CHARGES")
    private Double shippingCharges;

    @Column(name = "TOTAL")
    private Double total;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Payment> payments;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "SHIPPING_ADDRESS_ID", referencedColumnName = "ID")
    private ShippingAddress shippingAddress;

    @Column(name = "DELIVERY_METHOD")
    private String deliveryMethod;

    @Column(name = "CREATE_DATE")
    private LocalDateTime createDate;

    @Column(name = "UPDATE_DATE")
    private LocalDateTime updatedDate;
}
