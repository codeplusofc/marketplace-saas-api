package com.market.saas.validator;

import com.market.saas.exception.BadRequestException;
import com.market.saas.model.ProductEntity;

public class ProductValidator {

    public static void validateProductFields(ProductEntity product) {
        if (product == null) {
            throw new BadRequestException("Produto não pode ser nulo!");
        }
        if (product.getProductName() == null || product.getProductName().isEmpty()) {
            throw new BadRequestException("Nome do produto é obrigatório!");
        }
        if (product.getProductPrice() == 0) {
            throw new BadRequestException("Preço obrigatório!");
        }
        if (product.getQuantity() < 0) {
            throw new BadRequestException("Quantidade não pode ser negativa.");
        }
    }
}



