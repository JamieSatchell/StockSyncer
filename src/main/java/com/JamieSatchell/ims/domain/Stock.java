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
public class Stock {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    private Location location;

    private Integer quantity;

    @ManyToMany
    private List<Product> products = new ArrayList<>();

    // No manual getters, setters, or constructors are needed due to Lombok annotations
}
