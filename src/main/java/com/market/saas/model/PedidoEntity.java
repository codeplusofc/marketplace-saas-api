package com.market.saas.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;


import java.time.LocalDateTime;

@Entity
public class PedidoEntity  {



    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private Double preco;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    // hora do pedido criado
    private LocalDateTime dataDoPedido = LocalDateTime.now();



}
