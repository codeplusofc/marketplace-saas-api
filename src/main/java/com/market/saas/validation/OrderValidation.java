package com.market.saas.validation;

import com.market.saas.model.OrderEntity;

public class OrderValidation {

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
