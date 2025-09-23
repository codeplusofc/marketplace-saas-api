package com.market.saas.Usuario;

import javax.management.relation.Role;

public class User {

    private Long id;
    private String nome;
    private String email;
    private String senha;
    private Role role;

    public int getId() {
        return Math.toIntExact(id);
    }

    public void setId(int id) {
        this.id = (long) id;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
