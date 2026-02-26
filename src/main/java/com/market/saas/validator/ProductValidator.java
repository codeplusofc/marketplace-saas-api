package com.market.saas.validator;

import com.market.saas.model.ProductEntity;

public class ProductValidator {
    public static void validate(ProductEntity product) {
        if (product == null) {
            throw new RuntimeException("Produto não pode ser nulo");
        }

        if (product.getProductName() == null || product.getProductName().isEmpty()) {
            throw new RuntimeException("Nome do produto obrigatório");
        }

        if (product.getProductPrice() == 0) {
            throw new RuntimeException("Preço obrigatório");
        }
    }

    public static void validateEstoque(Integer quantidade) {

        if (quantidade == null) {
            throw new IllegalArgumentException("Quantidade em estoque é obrigatória.");
        }

        if (quantidade < 0) {
            throw new IllegalArgumentException("Quantidade não pode ser negativa.");
        }

    }

    }



