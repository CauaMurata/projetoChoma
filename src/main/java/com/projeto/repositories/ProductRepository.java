package com.projeto.repositories;

import com.projeto.model.user.ProductModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProductRepository extends JpaRepository<ProductModel, Long> {
    Optional<ProductModel> findProductById(Long id);
}
