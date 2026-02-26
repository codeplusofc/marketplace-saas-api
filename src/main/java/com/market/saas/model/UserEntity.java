package com.market.saas.model;
import  com.market.saas.validator.UserValidator;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
@Entity
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nome;
    private String cpf;
    private int idade;
@Transient
    public UserValidator userValidator = new UserValidator();
}
