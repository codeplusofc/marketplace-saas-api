package com.market.saas.controller;

import com.market.saas.model.OrderEntity;
import com.market.saas.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping
    public ResponseEntity<OrderEntity> createOrder(@RequestBody OrderEntity orderEntity) {
        return ResponseEntity.status(201).body(orderService.createOrder(orderEntity));
    }

    @GetMapping
    public List<OrderEntity> getAllOrders() {
        return orderService.getAllOrders();
    }

    @GetMapping("/{id}")
    public OrderEntity findOrderById(@PathVariable Long id) {
        return orderService.findOrderByIdOrThrow(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<OrderEntity> updateOrder(@PathVariable Long id, @RequestBody OrderEntity orderEntity) {
        return ResponseEntity.status(204).body(orderService.updateOrder(orderEntity, id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteOrderById(@PathVariable Long id) {
        orderService.deleteOrderById(id);
        return ResponseEntity.noContent().build();
    }
}
