package com.ecommerce.orderservice.controllers;

import com.ecommerce.orderservice.models.Order;
import com.ecommerce.orderservice.services.OrderService;
import com.google.gson.Gson;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping(path = "/")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @GetMapping("/welcome")
    public ResponseEntity<String> welcome() {
        return new ResponseEntity<>("welcome", HttpStatus.OK);
    }

    @GetMapping("/order/{id}")
    public ResponseEntity<String> getOrderById(@PathVariable Long id) {
        Order order = this.orderService.getOrderById(id);
        return new ResponseEntity<>(new Gson().toJson(order), HttpStatus.OK);
    }

    @PostMapping("/order")
    public ResponseEntity<String> createOrder(@RequestBody Order order) {
        try {
            this.orderService.createOrder(order);
            return new ResponseEntity<>("success", HttpStatus.CREATED);
        } catch (Exception e) {
            log.error("problem while saving order");
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("problem while saving order");
        }
    }

    @DeleteMapping(name = "/order")
    public ResponseEntity<String> cancelOrder(@RequestBody Order order) {
        try {
            this.orderService.cancelOrder(order);
            return new ResponseEntity<>("success", HttpStatus.CREATED);
        }catch (Exception e) {
            log.error("problem while cancelling order");
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("problem while cancelling order");
        }
    }
}
