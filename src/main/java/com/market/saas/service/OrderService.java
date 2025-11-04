package com.market.saas.service;

import com.market.saas.dto.OrderRequest;
import com.market.saas.dto.OrderResponse;
import com.market.saas.repository.OrderItemRepository;
import com.market.saas.repository.OrderRepository;
import com.market.saas.repository.ProductRepository;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

    private final OrderRepository orderRepository;
    private final OrderItemRepository orderItemRepository;
    private final ProductRepository productRepository;

    public OrderService(OrderRepository orderRepository,
                        OrderItemRepository orderItemRepository,
                        ProductRepository productRepository) {
        this.orderRepository = orderRepository;
        this.orderItemRepository = orderItemRepository;
        this.productRepository = productRepository;
    }

    public OrderResponse createOrder(OrderRequest request) {
        //TODO:Essa funcionalidade deve salvar um pedido no banco de dados.
        //TODO:Ao salvar o pedido no banco de dados, ele deverá estar com status pendente.
        return null;
    }
}
