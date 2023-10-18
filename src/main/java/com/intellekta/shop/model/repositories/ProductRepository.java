package com.intellekta.shop.model.repositories;

import com.intellekta.shop.model.entities.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.ArrayList;

public interface ProductRepository extends JpaRepository<ProductEntity, Integer> {
    ArrayList<ProductEntity> findProductEntitiesByYear(int year);
}
