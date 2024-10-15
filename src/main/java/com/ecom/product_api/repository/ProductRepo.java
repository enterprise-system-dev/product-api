package com.ecom.product_api.repository;

import com.ecom.product_api.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepo extends JpaRepository<Product, String> {
}
