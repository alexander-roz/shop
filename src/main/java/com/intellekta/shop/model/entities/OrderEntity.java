package com.intellekta.shop.model.entities;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.time.LocalDateTime;

@Entity
@Data
public class OrderEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_id")
    private int orderID;

    @Column(name = "order_time", columnDefinition = "datetime", nullable = false)
    private LocalDateTime time;

    @Enumerated(EnumType.STRING)
    @Column(name = "order_status", columnDefinition = "", nullable = false)
    private Status status;

    @ManyToOne
    @JoinColumn (referencedColumnName = "product_id", name = "product_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private ProductEntity productID;

    @OneToOne
    @JoinColumn (referencedColumnName = "customer_id", name = "customer_id", nullable = false)
    private CustomerEntity customerID;
}