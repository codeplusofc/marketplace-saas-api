package com.market.saas.validator;

import com.market.saas.exception.StatusException;
import com.market.saas.model.OrderEntity;
import org.springframework.stereotype.Component;

@Component
public class OrderValidator {

    public void validateCanDelete(OrderEntity order) {
        if (!"PENDING".equals(order.getStatus())) {
            throw new StatusException(
                    "Pedido não pode ser deletado - status: " + order.getStatus()
            );
        }
    }

    public void validateStatusTransition(String currentStatus, String newStatus) {
        if ("COMPLETED".equals(currentStatus)) {
            throw new StatusException("Pedido concluído não pode ser alterado");
        }
    }
    public static void validate(OrderEntity order) {
        if (order == null) {
            throw new IllegalArgumentException("Order não pode ser nulo");
        }

        if (order.getUserId() == null) {
            throw new IllegalArgumentException("O ID do usuário é obrigatório");
        }

        if (order.getDescription() != null && order.getDescription().length() > 200) {
            throw new IllegalArgumentException("A descrição não pode ter mais do que 200 caracteres!");
        }
    }
}
