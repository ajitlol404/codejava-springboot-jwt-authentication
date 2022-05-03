package com.springjwt.product.api;

import com.springjwt.product.api.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Integer> {
}
