package com.market.saas.repository;

import com.market.saas.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

//CONTRATO COM O BANCO DE DADOS!
public interface UserRepository extends JpaRepository<User, Long> {
}
