package com.market.saas.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class ProductEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long orderId;

    @NotBlank(message = "O nome do produto é obrigatório")
    private String productName;

    @NotNull(message = "O preço do produto é obrigatório")
    @Positive(message = "O preço deve ser maior que zero")
    private double productPrice;

    @Min(value = 1, message = "A quantidade mínima deve ser 1")
    private int quantity;

    private double subtotal;


    public ProductEntity() {
    }

    public ProductEntity(Long id, Long orderId, String productName, double productPrice, int quantity, double subtotal) {
        this.id = id;
        this.orderId = orderId;
        this.productName = productName;
        this.productPrice = productPrice;
        this.quantity = quantity;
        this.subtotal = subtotal;
    }
}