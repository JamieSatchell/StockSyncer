package com.JamieSatchell.ims.domain

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.OneToOne
import jakarta.persistence.ManyToMany
import lombok.NoArgsConstructor



@Entity
@NoArgsConstructor
data class Stock (
        @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
        var id: Long? = null,
        @OneToOne
        var location: Location? = null,
        var quanity: Int? = null,
        @ManyToMany
        var products: MutableList<Product> = mutableListOf()

)
