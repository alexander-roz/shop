package com.intellekta.shop.model.entities;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
@Data
@Table(name = "customers")
public class CustomerEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "customer_id")
    private int customerID;

    @Column(name = "customer_name")
    private String name;

    @Column(name = "customer_surname")
    private String surname;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn (referencedColumnName = "order_id", name = "order_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private OrderEntity order;
}