package com.example.crudProducts.repositories;

import com.example.crudProducts.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, String> {
}
