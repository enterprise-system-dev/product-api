package com.ecom.product_api.repository;

import com.ecom.product_api.entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ProductRepo extends JpaRepository<Product, String> {
    @Query(value = "SELECT * FROM product WHERE description LIKE %?1%", nativeQuery = true)
    Page<Product> search(String searchText, Pageable pageable);
    @Query(value = "SELECT COUNT(*) FROM product WHERE description LIKE %?1%", nativeQuery = true)
    long searchCount(String searchText);
}
