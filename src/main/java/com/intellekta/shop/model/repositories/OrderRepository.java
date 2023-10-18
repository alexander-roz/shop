package com.intellekta.shop.model.repositories;

import com.intellekta.shop.model.entities.OrderEntity;
import com.intellekta.shop.model.entities.Status;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.ArrayList;

public interface OrderRepository extends JpaRepository<OrderEntity, Integer> {
    ArrayList<OrderEntity> findOrderEntitiesByStatus(Status status);
}
