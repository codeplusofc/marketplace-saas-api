package com.market.saas.service;

import com.market.saas.exception.NotFoundException;
import com.market.saas.model.OrderEntity;
import com.market.saas.repository.OrderRepository;
import com.market.saas.validator.OrderValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
// Removido o import do UUID para usar Long

import static com.market.saas.validator.OrderValidator.validate;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private OrderValidator businessValidator;

    public OrderEntity createOrder(OrderEntity order) {
        validate(order);
        return orderRepository.save(order);
    }

    public List<OrderEntity> getAllOrders() {
        var orders = orderRepository.findAll();

        if (orders.isEmpty()) {
            throw new NotFoundException("Nenhum pedido foi encontrado no banco de dados.");
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


        existingOrder.setPaymentStatus(order.getPaymentStatus());
        existingOrder.setDeliveryStatus(order.getDeliveryStatus());

        return orderRepository.save(existingOrder);
    }


    public OrderEntity findOrderByIdOrThrow(Long id) {
        return orderRepository.findById(id)
                .orElseThrow(() -> new NotFoundException(
                        "Pedido com ID " + id + " não encontrado"
                ));
    }
}