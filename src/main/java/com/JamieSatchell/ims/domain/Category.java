package com.JamieSatchell.ims.domain;

import jakarta.persistence.*;
import lombok.NoArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import java.util.List;

@Entity
@Getter @Setter
@NoArgsConstructor // Generates a no-arg constructor
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @OneToMany(mappedBy = "category")
    private List<Product> products;
}
