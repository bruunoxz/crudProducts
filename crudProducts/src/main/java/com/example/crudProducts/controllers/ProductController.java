package com.example.crudProducts.controllers;

import com.example.crudProducts.domain.Product;
import com.example.crudProducts.domain.RequestProduct;
import com.example.crudProducts.repositories.ProductRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/products")
public class ProductController {
    @Autowired
    ProductRepository repository;

    @GetMapping
    public ResponseEntity getAllProducts(){
        List<Product> listProducts = repository.findAll();
        return ResponseEntity.ok(listProducts);
    }

    @PostMapping
    public ResponseEntity registerProduct(@RequestBody @Valid RequestProduct data){
        Product product = new Product(data);
        repository.save(product);
        return ResponseEntity.ok(product);
    }

    @PutMapping
    public ResponseEntity updateProduct(@RequestBody @Valid RequestProduct data){
        Optional<Product> optionalProduct = repository.findById(data.id());
        if(optionalProduct.isPresent()){
            Product product = optionalProduct.get();
            product.setName(data.name());
            product.setPrice(data.price());
            repository.save(product);
            return ResponseEntity.ok(product);
        }else{
            return ResponseEntity.noContent().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteProduct(@PathVariable String id){
        repository.deleteById(id);
        return ResponseEntity.noContent().build();
    }

}
