package com.market.saas.repository;

import com.market.saas.model.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderItemRepository extends JpaRepository<ProductEntity, Long> {
    List<ProductEntity> findByOrderId(Long orderId);
}