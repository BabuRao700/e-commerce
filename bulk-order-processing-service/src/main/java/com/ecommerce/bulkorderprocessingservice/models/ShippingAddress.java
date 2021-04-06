package com.ecommerce.bulkorderprocessingservice.models;

import lombok.*;

import javax.persistence.*;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "SHIPPING_ADDRESS")
public class ShippingAddress {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    private Long id;

    @Column (name = "ADDRESS_LINE_1")
    private String addressLine1;

    @Column (name = "ADDRESS_LINE_2")
    private String addressLine2;

    @Column (name = "CITY")
    private String city;

    @Column (name = "STATE")
    private String state;

    @Column (name = "ZIP")
    private String zip;

    // does non owning side mapping required ?
//    @OneToOne(mappedBy = "SHIPPING_ADDRESS")
//    private Order order;
}
