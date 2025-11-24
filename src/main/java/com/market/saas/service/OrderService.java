package com.market.saas.service;

import com.market.saas.exception.OrderNotFoundException;
import com.market.saas.model.OrderEntity;
import com.market.saas.repository.OrderRepository;
import com.market.saas.validator.OrderBusinessValidator;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static com.market.saas.validation.OrderValidation.validate;

@Service
public class OrderService {

    private final OrderRepository orderRepository;
    private final OrderBusinessValidator businessValidator;

    public OrderService(OrderRepository orderRepository, OrderBusinessValidator businessValidator) {
        this.orderRepository = orderRepository;
        this.businessValidator = businessValidator;
    }

    @Transactional
    public OrderEntity createOrder(OrderEntity orderEntity) {
        validate(orderEntity);

        OrderEntity newOrder = new OrderEntity(
                orderEntity.getUserId(),
                orderEntity.getDescription()
        );

        return orderRepository.save(newOrder);
    }

    public List<OrderEntity> getAllOrders() {
        return orderRepository.findAll();
    }

    @Transactional
    public void deleteOrderById(Long id) {
        OrderEntity order = findOrderByIdOrThrow(id);
        businessValidator.validateCanDelete(order);
        orderRepository.deleteById(id);
    }

    @Transactional
    public OrderEntity updateOrder(OrderEntity updates, Long id) {
        validate(updates);
        OrderEntity existingOrder = findOrderByIdOrThrow(id);
        existingOrder.updateFrom(updates);
        return orderRepository.save(existingOrder);
    }

    public OrderEntity findOrderById(Long id) {
        return findOrderByIdOrThrow(id);
    }

    private OrderEntity findOrderByIdOrThrow(Long id) {
        return orderRepository.findById(id)
                .orElseThrow(() -> new OrderNotFoundException(
                        "Pedido com ID " + id + " não encontrado"
                ));
    }
}
