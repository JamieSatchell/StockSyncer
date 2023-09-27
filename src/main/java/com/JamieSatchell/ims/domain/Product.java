package com.JamieSatchell.ims.domain;

import jakarta.persistence.*;
import lombok.NoArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@NoArgsConstructor
@Getter
@Setter
public class Product {
    @Transient
    private int totalStock; // This field will not be persisted to the database
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Double price;
    @ManyToOne
    private Category category;
    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Stock> stock = new ArrayList<>();
    public void addStock(Stock stockItem) {
        if(stockItem != null) {
            this.stock.add(stockItem);
            stockItem.setProduct(this);
        }
    }

    public void removeStock(Stock stockItem) {
        if(stockItem != null) {
            this.stock.remove(stockItem);
        }
    }
}


