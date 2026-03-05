package com.market.saas.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "products")
@Getter
@Setter
@Entity
public class ProductEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long orderId;
    private String productName;
    private double productPrice;
    private int quantity;
    private double subtotal;

    public ProductEntity(Long id, Long orderId, String productName, double productPrice, int quantity, double subtotal) {
        this.id = id;
        this.orderId = orderId;
        this.productName = productName;
        this.productPrice = productPrice;
        this.quantity = quantity;
        this.subtotal = subtotal;
    }
}