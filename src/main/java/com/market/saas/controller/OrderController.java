package com.market.saas.controller;

import com.market.saas.model.OrderEntity;
import com.market.saas.service.OrderService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/orders")
public class OrderController {

    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping
    public OrderEntity createOrder(@RequestBody OrderEntity orderEntity) {
        return orderService.createOrder(orderEntity);
    }
}
