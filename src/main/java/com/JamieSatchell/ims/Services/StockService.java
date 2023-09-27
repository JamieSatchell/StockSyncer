package com.JamieSatchell.ims.Services;

import com.JamieSatchell.ims.domain.Stock;
import com.JamieSatchell.ims.repositories.StockRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StockService {

    private final StockRepository stockRepository;

    public StockService(StockRepository stockRepository) {
        this.stockRepository = stockRepository;
    }

    public List<Stock> getAllStocks() {
        return stockRepository.findAll();
    }

    public Stock addStock(Stock stock) {
        return stockRepository.save(stock); // Saving the new stock instance to the database
    }
}
