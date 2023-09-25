
package com.JamieSatchell.ims.domain

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.ManyToOne
import jakarta.persistence.OneToMany



import lombok.NoArgsConstructor

@Entity
@NoArgsConstructor
data class Product(
        @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
        var id: Long? = null,
        var name: String? = null,
        var price: Double? = null,
        @ManyToOne
        var category: Category? = null,
        @OneToMany(mappedBy = "product")
        var stock: MutableList<Stock> = mutableListOf()
)

