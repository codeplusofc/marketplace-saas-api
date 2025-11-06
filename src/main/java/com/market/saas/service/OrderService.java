package com.market.saas.service;

import com.market.saas.dto.OrderRequest;
import com.market.saas.dto.OrderResponse;
import com.market.saas.model.OrderEntity;
import com.market.saas.model.OrderStatus;
import com.market.saas.repository.OrderItemRepository;
import com.market.saas.repository.OrderRepository;
import com.market.saas.repository.ProductRepository;
import jakarta.persistence.criteria.Order;
import org.springframework.stereotype.Service;

import static com.market.saas.model.OrderStatus.PENDING;

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
        //Criando novo pedido
        OrderEntity order = new OrderEntity();
        //Dando um status ao pedido
        order.setStatus(PENDING);
        //Salvando o novo pedido no repositório
        OrderEntity savedOrder = orderRepository.save(order);
        //Dando resposta ao usuário
        OrderResponse response = new OrderResponse();
        response.setId(response.getId());
        response.setStatus(response.getStatus());


        //TODO:Essa funcionalidade deve salvar um pedido no banco de dados.
        //TODO:Ao salvar o pedido no banco de dados, ele deverá estar com status pendente.
        return response;
    }
}
