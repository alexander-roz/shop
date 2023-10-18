package com.intellekta.shop.model.entities;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table (name = "products", schema = "shop")
public class ProductEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id")
    private int productID;

    @Column(name = "product_name")
    private String name;

    @Column(name = "product_year")
    private int year;
}
