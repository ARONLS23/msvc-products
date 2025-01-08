package com.arom.spring.msvc.products.controllers;

import com.arom.spring.msvc.products.entities.Product;
import com.arom.spring.msvc.products.services.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/products")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @GetMapping
    public List<Product> getProducts() {
        return productService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> details(@PathVariable Long id){
        Optional<Product> product = productService.findById(id);
        if(product.isPresent()){
            return ResponseEntity.ok(product.orElseThrow());           }
        return ResponseEntity.notFound().build();
    }

}
