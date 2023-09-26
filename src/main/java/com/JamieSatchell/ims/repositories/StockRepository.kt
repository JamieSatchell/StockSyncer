package com.JamieSatchell.ims.repository

import com.JamieSatchell.ims.domain.Stock
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface StockRepository : JpaRepository<Stock, Long>
