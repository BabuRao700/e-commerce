package com.ecommerce.orderservice.models;


import lombok.*;

import javax.persistence.*;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "PAYMENT")
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column (name = "ID")
    private Long id;

    @Column(name = "PAYMENT_METHOD")
    private String paymentMethod;

    @Column(name = "PAYMENT_DATE")
    private String paymentDate;

    @Column(name = "PAYMENT_AMOUNT")
    private String paymentAmount;

    @Column(name = "CONFIRMATION_NUMBER")
    private String confirmationNumber;

    @Column (name = "BILLING_ADDRESS_LINE_1")
    private String billingAddressLine1;

    @Column (name = "BILLING_ADDRESS_LINE_2")
    private String billingAddressLine2;

    @Column (name = "BILLING_CITY")
    private String billingCity;

    @Column (name = "BILLING_STATE")
    private String billingState;

    @Column (name = "BILLING_ZIP")
    private String billingZip;
}
