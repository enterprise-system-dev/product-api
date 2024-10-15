package com.ecom.product_api.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

@Entity(name = "product")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Product {
    @Id
    @Column(name = "product_id", length = 80, nullable = false)
    private String productId;
    @Column(name = "description", length = 1000)
    private String description;
    @Column(name = "unit_price", precision = 2)
    private double unitPrice;
    @Column(name = "qty", nullable = false)
    private int qty;
    @Embedded
    private FileResource fileResource;
}
