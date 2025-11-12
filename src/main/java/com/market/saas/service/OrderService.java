package com.market.saas.service;

import com.market.saas.model.OrderEntity;
import com.market.saas.repository.OrderRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class OrderService {

    private final OrderRepository orderRepository;

    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public OrderEntity createOrder(OrderEntity orderEntity) {
        return orderRepository.save(orderEntity);
    }

    public OrderEntity getAllOrders() {
        return (OrderEntity) orderRepository.findAll();
    }

    public void deleteOrderById(Long id) {
        if (orderRepository.existsById(id)) {
            throw new RuntimeException("Pedido com ID " + id + " não encontrado!");
        }
        orderRepository.deleteById(id);
    }

    public OrderEntity updateOrder(OrderEntity orderEntity, Long id) {
        Optional<OrderEntity> pedidoDoBanco = orderRepository.findById(id);

        if (pedidoDoBanco.isEmpty()) {
            throw new RuntimeException("Pedido não encontrado!");
        }

        pedidoDoBanco.get().setUserId(orderEntity.getUserId());
        pedidoDoBanco.get().setStatus(orderEntity.getStatus());
        pedidoDoBanco.get().setCreatedAt(orderEntity.getCreatedAt());
        pedidoDoBanco.get().setDescricao(orderEntity.getDescription());

        return orderRepository.save(pedidoDoBanco.get());
    }

    public Optional<OrderEntity> findOrderById(Long id) {
        return orderRepository.findById(id);
    }


}
