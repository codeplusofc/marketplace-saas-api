package com.market.saas.service;

import com.market.saas.exception.OrderNotFoundException;
import com.market.saas.model.OrderEntity;
import com.market.saas.repository.OrderRepository;
import com.market.saas.validator.OrderValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

import static com.market.saas.validator.OrderValidator.validate;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private OrderValidator businessValidator;

    public OrderEntity createOrder(OrderEntity order) {
        validate(order);

        var newOrder = new OrderEntity(
                order.getUserId(),
                order.getDescription()
        );
        return orderRepository.save(newOrder);
    }

    public List<OrderEntity> getAllOrders() {
        var orders = orderRepository.findAll();

        if (orders.isEmpty()) {
            throw new OrderNotFoundException("Nenhum pedido foi encontrado no banco de dados.");
        }
        return orders;
    }

    public void deleteOrderById(Long id) {
        var order = findOrderByIdOrThrow(id);
        businessValidator.validateCanDelete(order);
        orderRepository.deleteById(id);
    }

    public OrderEntity updateOrder(OrderEntity order, Long id) {
        validate(order);
        var existingOrder = findOrderByIdOrThrow(id);
        existingOrder.setStatus(order.getStatus());
        existingOrder.setDescription(order.getDescription());
        existingOrder.setUpdatedAt(LocalDateTime.now());

        return orderRepository.save(existingOrder);
    }

    public OrderEntity findOrderByIdOrThrow(Long id) {
        return orderRepository.findById(id)
                .orElseThrow(() -> new OrderNotFoundException(
                        "Pedido com ID " + id + " não encontrado"
                ));
    }
}
