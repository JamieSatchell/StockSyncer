package com.JamieSatchell.ims.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.NoArgsConstructor;
import lombok.Getter;
import lombok.Setter;

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

    // No manual getters, setters, or constructors are needed due to Lombok annotations
}
