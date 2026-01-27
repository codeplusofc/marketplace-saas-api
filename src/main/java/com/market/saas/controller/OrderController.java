package com.market.saas.controller;


import com.market.saas.model.OrderEntity;
import com.market.saas.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/pedidos")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping
    public ResponseEntity<OrderEntity> criar(@RequestBody OrderEntity orderEntity) {
        return ResponseEntity.status(HttpStatus.CREATED).body(orderService.createOrder(orderEntity));
    }
}
