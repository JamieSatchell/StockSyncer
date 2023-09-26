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
public class Location {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String address;

    @OneToMany(mappedBy = "location")
    private List<Stock> stock = new ArrayList<>();

    public void addStock(Stock stockItem) {
        if(stockItem != null) {
            this.stock.add(stockItem);
        }
    }
}
