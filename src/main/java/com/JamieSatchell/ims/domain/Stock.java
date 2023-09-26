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
    @ManyToOne
    @JoinColumn(name = "location_id")
    private Location location;
    private Integer quantity;
    @ManyToOne(cascade = CascadeType.MERGE)
    private Product product;
    public void setLocationTEST(Location locationItem){
        this.location=locationItem;
        locationItem.addStock(this);
    }
}
