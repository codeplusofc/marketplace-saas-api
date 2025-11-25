package com.market.saas.validator;

import com.market.saas.exception.OrderStatusException;
import com.market.saas.model.OrderEntity;
import org.springframework.stereotype.Component;

@Component
public class OrderBusinessValidator {

    public void validateCanDelete(OrderEntity order) {
        if (!"PENDING".equals(order.getStatus())) {
            throw new OrderStatusException(
                    "Pedido não pode ser deletado - status: " + order.getStatus()
            );
        }
    }

    public void validateStatusTransition(String currentStatus, String newStatus) {
        if ("COMPLETED".equals(currentStatus)) {
            throw new OrderStatusException("Pedido concluído não pode ser alterado");
        }
    }
}
