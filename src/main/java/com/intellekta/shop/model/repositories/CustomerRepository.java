package com.intellekta.shop.model.repositories;

import com.intellekta.shop.model.entities.CustomerEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.ArrayList;

public interface CustomerRepository extends JpaRepository<CustomerEntity, Integer> {
    ArrayList<CustomerEntity> findCustomerEntityByName(String name);
}
