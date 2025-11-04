package com.market.saas.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class OrderEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long userId;
    private String status;
    private LocalDateTime orderDate;
    private double totalValue;

    public OrderEntity() {
        this.orderDate = LocalDateTime.now();
        this.status = "PENDING";
    }

    public OrderEntity(Long userId, String status, double totalValue) {
        this.userId = userId;
        this.status = status;
        this.totalValue = totalValue;
        this.orderDate = LocalDateTime.now();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public LocalDateTime getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(LocalDateTime orderDate) {
        this.orderDate = orderDate;
    }

    public double getTotalValue() {
        return totalValue;
    }

    public void setTotalValue(double totalValue) {
        this.totalValue = totalValue;
    }
}
