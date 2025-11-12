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
    private String nome;
    private double preco;
    private String descricao;
    private Long vendedorId;
    private double totalValue;

    public OrderEntity() {
        this.orderDate = LocalDateTime.now();
        this.status = "PENDING";
    }

    public OrderEntity(Long id, Long userId, String status, LocalDateTime orderDate,
                       String nome, double preco, String descricao, Long vendedorId, double totalValue) {
        this.id = id;
        this.userId = userId;
        this.status = status;
        this.orderDate = orderDate;
        this.nome = nome;
        this.preco = preco;
        this.descricao = descricao;
        this.vendedorId = vendedorId;
        this.totalValue = totalValue;
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

    public LocalDateTime getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(LocalDateTime orderDate) {
        this.orderDate = orderDate;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Long getVendedorId() {
        return vendedorId;
    }

    public void setVendedorId(Long vendedorId) {
        this.vendedorId = vendedorId;
    }

    public double getTotalValue() {
        return totalValue;
    }

    public void setTotalValue(double totalValue) {
        this.totalValue = totalValue;
    }
}
