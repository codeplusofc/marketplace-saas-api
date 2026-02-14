package com.market.saas.controller;


import com.market.saas.model.OrderEntity;
import com.market.saas.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pedidos")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping
    public ResponseEntity<OrderEntity> createOrder(@RequestBody OrderEntity orderEntity) {
        return ResponseEntity.status(HttpStatus.CREATED).body(orderService.createOrder(orderEntity));
    }

    @GetMapping
    public ResponseEntity<List<OrderEntity>> getAllOrders() {
        return ResponseEntity.status(200).body(orderService.getAllOrders());
    }

    @DeleteMapping("/{id}")
    public void deleteOrder(@PathVariable Long id) {
        orderService.deleteOrderById(id);
    }

    @PutMapping("{id}")
    public ResponseEntity<OrderEntity> updateOrder(@RequestBody OrderEntity orderEntity, @PathVariable Long id) {
        return ResponseEntity.status(200).body(orderService.updateOrder(orderEntity, id));
    }
}
