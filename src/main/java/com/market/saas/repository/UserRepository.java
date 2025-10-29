package com.market.saas.repository;

import com.market.saas.model.ProductEntity;
import com.market.saas.model.UserEntity;
import org.apache.catalina.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {
    Optional<User> findAll(long id);

}
