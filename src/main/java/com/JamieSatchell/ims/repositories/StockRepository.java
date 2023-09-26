package com.JamieSatchell.ims.repositories;

import com.JamieSatchell.ims.domain.Stock;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StockRepository extends JpaRepository<Stock, Long> {
}
