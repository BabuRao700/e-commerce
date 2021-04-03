package com.ecommerce.orderservice.models;

import lombok.*;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
import java.util.Set;

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

//    @Column(name = "ITEM_NAME")
//    private String itemName;
//
//    @Column(name = "ITEM_QTY")
//    private Integer itemQty;

    @Column(name = "SUB_TOTAL")
    private Double subTotal;

    @Column(name = "TAX")
    private Double tax;

    @Column(name = "SHIPPING_CHARGES")
    private Double shippingCharges;

    @Column(name = "TOTAL")
    private Double total;

    @Column(name = "PAYMENT_METHOD")
    private String paymentMethod;

    @Column(name = "PAYMENT_DATE")
    private String paymentDate;

    @Column(name = "CONFIRMATION_NUMBER")
    private String confirmationNumber;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "BILLING_ADDRESS_ID", referencedColumnName = "ID")
    private BillingAddress billingAddress;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "SHIPPING_ADDRESS_ID", referencedColumnName = "ID")
    private ShippingAddress shippingAddress;

}
