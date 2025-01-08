package com.arom.spring.msvc.products.repositories;

import com.arom.spring.msvc.products.entities.Product;
import org.springframework.data.repository.CrudRepository;

public interface ProductRepository extends CrudRepository<Product, Long> {
}
