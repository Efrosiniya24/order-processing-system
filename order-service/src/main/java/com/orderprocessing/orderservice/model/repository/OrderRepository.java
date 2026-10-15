package com.orderprocessing.orderservice.model.repository;

import com.orderprocessing.orderservice.model.entity.OrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author yefrosiniya.zinkovskaya
 * @since 19.09.2026
 */
@Repository
public interface OrderRepository extends JpaRepository<OrderEntity, Long> {
}
