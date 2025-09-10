package com.market.saas.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

//A MODEL É UTILIZADA PARA CRIAR NOSSOS OBJETOS
@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;
    String name;
    double price;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
