package com.market.saas.service;

import com.market.saas.dto.OrderRequest;
import com.market.saas.dto.OrderResponse;
import com.market.saas.model.OrderEntity;
import com.market.saas.model.OrderItem;
import com.market.saas.model.ProductEntity;
import com.market.saas.repository.OrderRepository;
import com.market.saas.repository.OrderItemRepository;
import com.market.saas.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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
        double total = 0.0;

        // Primeiro: salvar o pedido
        OrderEntity order = new OrderEntity();
        order.setUserId(request.getUserId());
        order.setStatus("PENDING");
        OrderEntity savedOrder = orderRepository.save(order);

        // Segundo: salvar os itens do pedido
        for (OrderRequest.ItemRequest itemRequest : request.getItems()) {
            Optional<ProductEntity> productOpt = productRepository.findById(itemRequest.getProductId());

            if (productOpt.isEmpty()) {
                throw new RuntimeException("Produto não encontrado: " + itemRequest.getProductId());
            }

            ProductEntity product = productOpt.get();

            OrderItem orderItem = new OrderItem();
            orderItem.setOrderId(savedOrder.getId());
            orderItem.setProductId(product.getId());
            orderItem.setProductName(product.getNome());
            orderItem.setProductPrice(product.getPreco());
            orderItem.setQuantity(itemRequest.getQuantity());
            orderItem.setSubtotal(product.getPreco() * itemRequest.getQuantity());

            orderItemRepository.save(orderItem);
            total += orderItem.getSubtotal();
        }

        // Terceiro: atualizar o total do pedido
        savedOrder.setTotalValue(total);
        orderRepository.save(savedOrder);

        return findOrderById(savedOrder.getId());
    }

    public List<OrderResponse> findAllOrders() {
        List<OrderEntity> orders = orderRepository.findAll();
        List<OrderResponse> responses = new ArrayList<>();

        for (OrderEntity order : orders) {
            responses.add(findOrderById(order.getId()));
        }

        return responses;
    }

    public OrderResponse findOrderById(Long id) {
        Optional<OrderEntity> orderOpt = orderRepository.findById(id);

        if (orderOpt.isEmpty()) {
            throw new RuntimeException("Pedido não encontrado: " + id);
        }

        OrderEntity order = orderOpt.get();
        List<OrderItem> items = orderItemRepository.findByOrderId(id);

        OrderResponse response = new OrderResponse();
        response.setId(order.getId());
        response.setUserId(order.getUserId());
        response.setStatus(order.getStatus());
        response.setOrderDate(order.getOrderDate());
        response.setTotalValue(order.getTotalValue());

        List<OrderResponse.ItemResponse> itemResponses = new ArrayList<>();
        for (OrderItem item : items) {
            OrderResponse.ItemResponse itemResponse = new OrderResponse.ItemResponse();
            itemResponse.setProductId(item.getProductId());
            itemResponse.setProductName(item.getProductName());
            itemResponse.setProductPrice(item.getProductPrice());
            itemResponse.setQuantity(item.getQuantity());
            itemResponse.setSubtotal(item.getSubtotal());
            itemResponses.add(itemResponse);
        }

        response.setItems(itemResponses);
        return response;
    }
}
