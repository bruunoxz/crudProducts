package com.example.crudProducts.domain;

import jakarta.persistence.*;
import lombok.*;


@Table(name = "product")
@Entity(name = "product")
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of="id")
@Getter
@Setter
public class Product {
    @Id @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    private String name;
    private Integer price;

    public Product(RequestProduct requestProduct){
        this.name = requestProduct.name();
        this.price = requestProduct.price();
    }
}
