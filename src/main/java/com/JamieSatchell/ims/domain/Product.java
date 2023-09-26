package com.JamieSatchell.ims.domain;

import jakarta.persistence.*;
import lombok.NoArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor
@Getter
@Setter
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private Double price;

    @ManyToOne
    private Category category;

    @ManyToMany(mappedBy = "products")
    private List<Stock> stock = new ArrayList<>();

    // No manual getters, setters, or constructors are needed due to Lombok annotations
}
