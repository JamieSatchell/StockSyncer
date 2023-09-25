package com.JamieSatchell.ims.domain

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.OneToMany



import lombok.NoArgsConstructor

@Entity
@NoArgsConstructor
data class Category (
        @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
        var id: Long? = null,
        var name: String? = null,
        @OneToMany (mappedBy = "catagory")
        var products: MutableList<Product> = mutableListOf()

)


