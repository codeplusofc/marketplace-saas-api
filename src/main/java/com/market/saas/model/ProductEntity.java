package com.market.saas.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Getter;
import lombok.Setter;

@Entity
public class ProductEntity {

    private Number productId;

    @Setter
    @Getter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Setter
    @Getter
    private Long orderId;

    @Setter
    @Getter
    @NotBlank(message = "O nome do produto é obrigatório")
    private String productName;

    @Setter
    @Getter
    @NotNull(message = "O preço do produto é obrigatório")
    @Positive(message = "O preço deve ser maior que zero")
    private double productPrice;

    @Getter
    @Setter
    @Min(value = 1, message = "A quantidade mínima deve ser 1")
    private int quantity;

    @Getter
    @Setter
    private double subtotal;


    public ProductEntity() {
    }


    public ProductEntity(Long orderId, Long productId, String productName, double productPrice, int quantity) {
        this.orderId = orderId;
        this.productId = productId;
        this.productName = productName;
        this.productPrice = productPrice;
        this.quantity = quantity;
        this.subtotal = productPrice * quantity;
    }


    public Long getProductId() {

        return productId != null ? productId.longValue() : null;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

}