package com.ecommerce.orderservice;


import com.ecommerce.orderservice.models.Item;
import com.ecommerce.orderservice.models.Order;
import com.ecommerce.orderservice.models.OrderResponse;
import com.ecommerce.orderservice.models.Payment;
import com.ecommerce.orderservice.services.OrderService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class OrderServiceTest {

    @Mock
    private OrderRepository orderRepository;

    @InjectMocks
    private OrderService orderService = new OrderService();

    @BeforeEach
    void testInit() {
    }

    @Test
    void testGetOrderById() {
        Mockito.when(orderRepository.findById(Mockito.anyLong())).thenReturn(Optional.of(getOrderMock()));
        assertEquals(orderService.getOrderById(new Long(1)).getId(), getOrderMock().getId());
    }

    @Test
    void testGetOrderByIdReturnsNull() throws NullPointerException {
        Mockito.when(orderRepository.findById(Mockito.anyLong())).thenReturn(null);
    }

    @Test
    void testCreateOrder() {
        OrderResponse mockRes = OrderResponse.builder().orderId(getOrderMock().getId()).build();
        Mockito.when(orderRepository.save(Mockito.any())).thenReturn(getOrderMock());
        assertEquals(orderService.createOrder(getOrderMock()).getOrderId(), mockRes.getOrderId());
    }

    @Test
    void testCancelOrder() {

    }

    public Order getOrderMock() {
        Item mockItems = Item.builder()
                        .name("iphone8")
                        .qty(1).build();

        Payment paymentMock = Payment.builder()
                .paymentMethod("credit card")
                .paymentDate("4/4/2021")
                .confirmationNumber("12S233CCV")
                .billingAddressLine1("Abc")
                .billingAddressLine2("ABC")
                .billingCity("TEST")
                .billingState("TEST")
                .billingZip("TEST")
                .build();

        return Order.builder()
                .id(new Long(1))
                .customerId(new Long(1))
                .items(Arrays.asList(mockItems))
                .subTotal(new Double(600))
                .tax(new Double(80))
                .shippingCharges(new Double(14))
                .total(new Double(694))
                .payments(Arrays.asList(paymentMock))
                .build();
    }

}
